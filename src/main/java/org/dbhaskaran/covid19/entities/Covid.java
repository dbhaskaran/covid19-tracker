package org.dbhaskaran.covid19.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Covid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String country;
	private String lastupdate;
	private int confirmed;
	private int deaths;
	private int recovered;
	private String latitude;
	private String longitude;

	public Covid() {
	}

	public Covid(String country, String lastUpdate, int confirmed, int deaths, int recovered, String latitude,
			String longitude) {
		super();
		this.country = country;
		this.lastupdate = lastUpdate;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastUpdate() {
		return lastupdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastupdate = lastUpdate;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Covid [country=" + country + ", lastUpdate=" + lastupdate + ", confirmed=" + confirmed + ", deaths="
				+ deaths + ", recovered=" + recovered + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}