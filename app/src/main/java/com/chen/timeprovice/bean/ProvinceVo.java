package com.chen.timeprovice.bean;

import java.io.Serializable;

public class ProvinceVo implements Serializable {

	private String provinceName;
	private String provincePostCode;
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProvincePostCode() {
		return provincePostCode;
	}
	public void setProvincePostCode(String provincePostCode) {
		this.provincePostCode = provincePostCode;
	}
	
	
}
