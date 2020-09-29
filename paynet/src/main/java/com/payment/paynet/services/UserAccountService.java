package com.payment.paynet.services;

import com.payment.paynet.dto.LoginDto;
import com.payment.paynet.models.UserAccount;

public interface UserAccountService {
	
	public UserAccount signUp(UserAccount useraccount);
	public UserAccount login(LoginDto loginDto) throws Exception;
	public UserAccount findByMobileNo(String MobileNo);
	

}
