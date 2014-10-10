package com.esprit.macchiato.emarchi.client;

import java.util.Collection;

import com.esprit.macchiato.emarchi.delegate.ClientCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Client;


public class ClientEm {
public static void main(String[] args) throws Exception {

		
		
		
		Client p1=new Client();
		p1.setFirstName("hamza");
		ClientCrudDelegate.addPerson(p1);
		Collection<Client> clients=ClientCrudDelegate.findAllclient();
		for(Client c:clients){
			System.out.println(c);
	}
	
		//ClientCrudDelegate.delete(1);
	}


}
