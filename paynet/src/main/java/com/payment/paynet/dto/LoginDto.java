package com.payment.paynet.dto;

public class LoginDto {

	private String password;
	private String mobileNo;

	public LoginDto(String password, String mobileNo) {
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public LoginDto() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobieNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
