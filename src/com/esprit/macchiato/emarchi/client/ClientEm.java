package com.esprit.macchiato.emarchi.client;

import javax.naming.NamingException;

import com.esprit.macchiato.emarchi.delegate.ClientCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Admin;
import com.esprit.macchiato.emarchi.domain.Client;


public class ClientEm {
public static void main(String[] args) throws Exception {

		
		
		
		Client p1=new Client();
		//p1.setFirstName("amine");
		//ClientCrudDelegate.addPerson(p1);
		//ClientCrudDelegate.findAllclient();
	
		ClientCrudDelegate.delete(1);

	}


}
