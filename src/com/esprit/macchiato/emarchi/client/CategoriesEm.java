package com.esprit.macchiato.emarchi.client;

import javax.naming.NamingException;

import com.esprit.macchiato.emarchi.delegate.CategoriesCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Categories;

public class CategoriesEm {
	
public static void main(String[] args) throws Exception {

		
		
		Categories p = new Categories();
		
		p.setDescription("aaaaaaaaabbbb");
		CategoriesCrudDelegate.addCategorie(p);

	}

}
