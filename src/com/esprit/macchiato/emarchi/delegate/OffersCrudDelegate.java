package com.esprit.macchiato.emarchi.delegate;

import java.util.Collection;
import java.util.List;

import com.esprit.macchiato.emarchi.domain.Products;
import com.esprit.macchiato.emarchi.locator.ServiceLocator;
import com.esprit.macchiato.emarchi.service.OffersCRUDRemote;

public class OffersCrudDelegate {
	private static OffersCRUDRemote offersCrud;
	private static OffersCRUDRemote getRemoteEJB(){
		offersCrud =  (OffersCRUDRemote) ServiceLocator.getInstance().getProxy("/E-marchi-master/OffersCRUD!com.esprit.macchiato.emarchi.service.OffersCRUDRemote");
		return offersCrud;
	}

	public static void addOffer(Products p) {
		getRemoteEJB().addOffer(p);
	}

	public static Products findOfferById(int id) {
		return getRemoteEJB().findOfferById(id);
	}

	public static List<Products> findAllOffers() {
		return getRemoteEJB().findAllOffers();
	}
	
	public static void updateOffer(Products p){
		getRemoteEJB().updateOffer(p);
	}
	public static void deleteOffer(int id) throws Exception {
		getRemoteEJB().deleteOffer(id);
	}
	
	public static List<Products> findOffersByCategory(String catego){
		return getRemoteEJB().findOffersByCategory(catego);
	}
	
	public static void moveOfferTo(int idOffer,String Catego){
		getRemoteEJB().moveOfferTo(idOffer, Catego);
	}

	
}
