package com.gaurav.usecase;

import java.util.List;

import com.gaurav.bean.Crime;
import com.gaurav.bean.User;
import com.gaurav.dao.CrimeDao;
import com.gaurav.dao.CrimeDaoImpl;
import com.gaurav.exceptions.CrimeException;

public class FindUnsolvedCases {
	
	private int size;
	private String msg;
	private List<Crime> unsolvedCasesList;
	public FindUnsolvedCases(User user) {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
		 	List<Crime> list = dao.findUnsolvedCase(user);
		 	size = list.size();
		 	unsolvedCasesList = list;
		} catch (CrimeException e) {
			msg = (e.getMessage());
			size = -1;
		}
	}
	public int getSize() {
		return size;
	}
	
	public String getMsg() {
		return msg;
	}
	public List<Crime> getUnsolvedCasesList() {
		return unsolvedCasesList;
	}
	
}
