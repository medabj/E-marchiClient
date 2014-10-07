package com.esprit.machiato.emarchi.client;

import javax.naming.NamingException;

import com.esprit.macchiato.emarchi.delegate.AdminCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Admin;
import com.esprit.macchiato.emarchi.domain.Client;

public class ClientEm {
public static void main(String[] args) throws NamingException {

		
		
		Admin p = new Admin();
		
		p.setLogin("ali");
		AdminCrudDelegate.addPerson(p);

	}


}
