package org.dbhaskaran.covid19.service;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dbhaskaran.covid19.entities.Covid;
import org.dbhaskaran.covid19.repos.ICovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidDataServiceImpl implements ICovidDataService {
	private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

	@Autowired
	private ICovid covidRepo;

	@Override
	@PostConstruct
	public void fetchCovidData() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(DATA_URL + getCurrentDate());
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String result = EntityUtils.toString(entity);
					StringReader csvBody = new StringReader(result);
					System.out.println(csvBody);
					Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBody);
					for (CSVRecord record : records) {
						String state = record.get("Province/State");
						String country = record.get("Country/Region");
						String lastupdate = record.get("Last Update");
						int confirmed = Integer.parseInt(record.get("Confirmed"));
						int deaths = Integer.parseInt(record.get("Deaths"));
						int recovered = Integer.parseInt(record.get("Recovered"));
						String latitude = record.get("Latitude");
						String longitude = record.get("Longitude");
						Covid c = new Covid(state, country, lastupdate, confirmed, deaths, recovered, latitude,
								longitude);
						covidRepo.save(c);
					}
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static String getCurrentDate() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String year = Integer.toString(localDate.getYear());
		String month = Integer.toString(localDate.getMonthValue());
		String day = Integer.toString(localDate.getDayOfMonth());
		if (day.length() == 1)
			day = "0" + day;
		if (month.length() == 1)
			month = "0" + month;
		return month + "-" + day + "-" + year + ".csv";

	}

}
