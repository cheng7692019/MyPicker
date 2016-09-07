package com.chen.timeprovice.bean;

import java.io.Serializable;

public class CityVo implements Serializable {

	private String cityName;
	private String cityPostCode;
	private String provincePostCode;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityPostCode() {
		return cityPostCode;
	}
	public void setCityPostCode(String cityPostCode) {
		this.cityPostCode = cityPostCode;
	}
	public String getProvincePostCode() {
		return provincePostCode;
	}
	public void setProvincePostCode(String provincePostCode) {
		this.provincePostCode = provincePostCode;
	}
	
	
}
