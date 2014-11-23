package com.esprit.macchiato.emarchi.delegate;

import java.util.List;

import com.esprit.macchiato.emarchi.domain.Client;
import com.esprit.macchiato.emarchi.locator.ServiceLocator;
import com.esprit.macchiato.emarchi.service.ClientCrudEJBRemote;

public class ClientCrudDelegate {
	private static ClientCrudEJBRemote PersonCrud;

	private static ClientCrudEJBRemote getRemoteEJB() {
		PersonCrud = (ClientCrudEJBRemote) ServiceLocator
				.getInstance()
				.getProxy(
						"/E-marchi-master/ClientCrudEJB!com.esprit.macchiato.emarchi.service.ClientCrudEJBRemote");
		return PersonCrud;
	}

	public static void addPerson(Client p) throws Exception {
		getRemoteEJB().addPerson(p);
	}

	public static List<Client> findbynom(String nom) throws Exception {
		return getRemoteEJB().findbynom(nom);
	}

	public static void delete(int p) throws Exception {
		getRemoteEJB().delete(p);

	}

	public static Client findById(int id) throws Exception {
		return getRemoteEJB().findbyid(id);
	}

	public static List<Client> findAllclient() {
		return getRemoteEJB().findAllclient();
	}

	public static List<Client> findByState() {
		return getRemoteEJB().findByState();
	}

	public static void confirmClient(Client c) throws Exception {
		getRemoteEJB().confirmClient(c);
	}

}