package com.solai.util;

import org.apache.commons.mail.EmailException;

public class TestMailUtil {

	public static void main(String[] args) {
try {
	MailUtil.sendSimpleMail();
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}