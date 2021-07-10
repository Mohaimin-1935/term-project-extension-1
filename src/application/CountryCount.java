package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CountryCount {
	private SimpleStringProperty country = new SimpleStringProperty();
	private SimpleIntegerProperty count = new SimpleIntegerProperty();
	
	public CountryCount(String country, Integer count) {
		this.country.set(country);
		this.count.set(count);
	}
	
	public String getCountry() { return country.get(); }
	public Integer getCount() { return count.get(); }
	
	public void setCountry(String country) { this.country.set(country); }
	public void setCount(Integer count) { this.count.set(count); }
}
