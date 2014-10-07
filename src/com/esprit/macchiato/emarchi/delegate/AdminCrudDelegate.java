package com.esprit.macchiato.emarchi.delegate;

import com.esprit.macchiato.emarchi.domain.Admin;
import com.esprit.macchiato.emarchi.domain.Client;
import com.esprit.macchiato.emarchi.locator.ServiceLocator;
import com.esprit.macchiato.emarchi.service.AdminCrudEJBRemote;

public class AdminCrudDelegate {
	private static AdminCrudEJBRemote PersonCrud;

	private static AdminCrudEJBRemote getRemoteEJB() {
		PersonCrud = (AdminCrudEJBRemote) ServiceLocator.getInstance()
				.getProxy("/e-marchiEJB/AdminCrudEJB!com.esprit.macchiato.emarchi.service.AdminCrudEJBRemote");
		return PersonCrud;
	}

	public static void addPerson(Admin p) {
		getRemoteEJB().addPerson(p);
	}

	public static Client findById(int id) {
		return getRemoteEJB().findbyid(id);
	}

	
	public static void delete(Client p) {
		getRemoteEJB().delete(p);
	}
	
	

}


