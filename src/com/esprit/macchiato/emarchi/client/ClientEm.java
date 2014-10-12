package com.esprit.macchiato.emarchi.client;

import java.util.Collection;

import com.esprit.macchiato.emarchi.delegate.ClientCrudDelegate;
import com.esprit.macchiato.emarchi.delegate.OffersCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Client;
import com.esprit.macchiato.emarchi.domain.Products;


public class ClientEm {
public static void main(String[] args) throws Exception {

	Products p1 = new Products();
	p1.setNameProduct("produit");
	OffersCrudDelegate.addOffer(p1);
	
		
//	Products p = new Products();
//	p.setDescription("test");
//	OffersCrudDelegate.addOffer(p);
		
//		Client p1=new Client();
//		p1.setFirstName("hamza");
//		ClientCrudDelegate.addPerson(p1);
//		Collection<Client> clients=ClientCrudDelegate.findAllclient();
//		for(Client c:clients){
//			System.out.println(c);
//	}
//	
//		//ClientCrudDelegate.delete(1);
	}


}

