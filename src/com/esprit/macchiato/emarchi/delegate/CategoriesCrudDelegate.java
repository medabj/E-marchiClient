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
	
	public static void addCategorie(Categories p) throws Exception {
		getRemoteEJB().addCategorie(p);
	}
	
	public static void delete(int id) throws Exception {
		getRemoteEJB().delete(id);
	}
	
	public static void updateCategory(Categories p){
		getRemoteEJB().update(p);
	}
	
	public static Categories findById(int id) {
		return getRemoteEJB().getById(id);
	}
	
}
