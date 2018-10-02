package com.drivingschool.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

public class PopulaDB {
	
	public static void main(String[] args) {
	
	//Class for create tables//	
	
	EntityManager em = new JPAUtil().getEntityManager();
	
	em.getTransaction().begin();

	em.getTransaction().commit();
	em.close();
}
	
	private static Calendar parseData(String data) {
	try {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	} catch (ParseException e) {
		throw new IllegalArgumentException(e);
	}
}
}
