package com.esprit.macchiato.emarchi.delegate;

import java.util.List;

import javax.management.Query;

import com.esprit.macchiato.emarchi.domain.Admin;
import com.esprit.macchiato.emarchi.domain.Client;
import com.esprit.macchiato.emarchi.locator.ServiceLocator;
import com.esprit.macchiato.emarchi.service.ClientCrudEJBRemote;

public class ClientCrudDelegate {
	private static ClientCrudEJBRemote PersonCrud;

	private static ClientCrudEJBRemote getRemoteEJB() {
		PersonCrud = (ClientCrudEJBRemote) ServiceLocator.getInstance()
				.getProxy("/e-marchiEJB/ClientCrudEJB!com.esprit.macchiato.emarchi.service.ClientCrudEJBRemote");
		return PersonCrud;
	}

	public static void addPerson(Client p) throws Exception {
		getRemoteEJB().addPerson(p);
	}

	public static Client findById(int id) {
		return getRemoteEJB().findbyid(id);
	}

	
	public static void delete(int id) {
		getRemoteEJB().delete(id);
	}
	
	public static  List<Client> findAllclient() {
		return getRemoteEJB().findAllclient();
	}

}


