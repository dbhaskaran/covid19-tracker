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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CovidDataServiceImpl implements ICovidDataService {
	private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";
	private static String currDate = new String("10-07-2020.csv");

	@Autowired
	private ICovid covidRepo;

	@Override
	@PostConstruct
	@Scheduled(cron = "0 0/50 * * * ?", zone = "America/Los_Angeles")
	public void fetchCovidData() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(DATA_URL + currDate);
		HttpEntity entity = null;
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				currDate = getNextDate();
				entity = response.getEntity();
			}

			if (entity != null) {
				String result = EntityUtils.toString(entity);
				StringReader csvBody = new StringReader(result);
				Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBody);
				covidRepo.deleteAll();
				for (CSVRecord record : records) {
					String country = record.get(3);
					String lastupdate = record.get(4);
					int confirmed = Integer.parseInt(record.get(7));
					int deaths = Integer.parseInt(record.get(8));
					int recovered = Integer.parseInt(record.get(9));
					String latitude = record.get(5);
					String longitude = record.get(6);
					Covid c = new Covid(country, lastupdate, confirmed, deaths, recovered, latitude, longitude);
					Covid curr = covidRepo.findByCountry(country);
					if (curr != null) {
						curr.setLastUpdate(c.getLastUpdate());
						curr.setConfirmed(curr.getConfirmed() + c.getConfirmed());
						curr.setDeaths(curr.getDeaths() + c.getDeaths());
						curr.setRecovered(curr.getRecovered() + c.getRecovered());
						covidRepo.save(curr);
					} else {
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

	private static String getNextDate() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		localDate = localDate.plusDays(1);
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
