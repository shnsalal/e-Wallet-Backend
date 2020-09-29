package com.payment.paynet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionReferenceGenerator {
    private final static String base10String = "0123456789";
	private final static char[] base10character = base10String.toCharArray();
	private final static int base10length = base10character.length;
    
    public static String generateReference(Long id) {
        Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Integer date = Integer.valueOf(sdf.format(d));
		long input = date  * id;
		return encoder(input);
	}

	public static String encoder(long input) {
		StringBuilder encodedString = new StringBuilder();
		while(input != 0) {
			long reminder = input % base10length;
			encodedString.append(base10character[(int)reminder]);
			input = input / base10length;
		}
		return encodedString.reverse().toString();
	}
}
