package cst438hw2.domain;

public class TempAndTime {
	public double temp;
	public long time;
	public int timezone;
	
	//Helper class to return temperature, time, and timezone data retrieved by WeatherService
	public TempAndTime(double temp, long time, int timezone){
		this.temp = temp;
		this.time = time;
		this.timezone = timezone;
	}
}
