package com.esprit.macchiato.emarchi.delegate;

import java.util.List;

import com.esprit.macchiato.emarchi.domain.Categories;
import com.esprit.macchiato.emarchi.locator.ServiceLocator;
import com.esprit.macchiato.emarchi.service.CategorieCrudEJBRemote;

public class CategoriesCrudDelegate {

	private static CategorieCrudEJBRemote CategorieCrud;
	private static CategorieCrudEJBRemote getRemoteEJB() {
		CategorieCrud = (CategorieCrudEJBRemote) ServiceLocator.getInstance()
				.getProxy("/E-marchi-master/CategorieCrudEJB!com.esprit.macchiato.emarchi.service.CategorieCrudEJBRemote");
		return CategorieCrud;
	}
	
	public static List<Categories> findAllCategories() {
		return getRemoteEJB().findAllCategories();
	}
}
