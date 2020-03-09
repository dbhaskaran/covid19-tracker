package org.dbhaskaran.covid19.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "covid")
public class Covid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "province")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "lastupdate")
	private String lastUpdate;
	@Column(name = "confirmed")
	private int confirmed;
	@Column(name = "deaths")
	private int deaths;
	@Column(name = "recovered")
	private int recovered;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;

	public Covid() {
	}

	public Covid(String state, String country, String lastUpdate, int confirmed, int deaths, int recovered,
			String latitude, String longitude) {
		super();
		this.state = state;
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
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
		return "Covid [state=" + state + ", country=" + country + ", lastUpdate=" + lastUpdate + ", confirmed="
				+ confirmed + ", deaths=" + deaths + ", recovered=" + recovered + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

}
