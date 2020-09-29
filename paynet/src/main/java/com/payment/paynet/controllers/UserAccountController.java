package com.payment.paynet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.payment.paynet.dto.LoginDto;
import com.payment.paynet.models.UserAccount;
import com.payment.paynet.services.UserAccountService;
import com.payment.paynet.util.TransactionReferenceGenerator;


@RestController
@RequestMapping("/user-account")
public class UserAccountController {
	@Autowired
	UserAccountService userAccountService;
	
	@PostMapping("/signup")
	public UserAccount signUp(@RequestBody UserAccount useraccount) {
		return userAccountService.signUp(useraccount);
	}
	
	@PostMapping("/login")
	public UserAccount login(@RequestBody LoginDto loginDto) throws Exception {
		return userAccountService.login(loginDto);
	}
	
	@GetMapping("/hello")
	public String Hello() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Integer date = Integer.valueOf(sdf.format(d));
		long input = 3;
		return date +"-" + TransactionReferenceGenerator.generateReference(input);
	}
}
