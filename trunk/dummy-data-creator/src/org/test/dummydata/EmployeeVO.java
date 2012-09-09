package org.test.dummydata;

import java.util.List;


public class EmployeeVO {

	
	/**
	 * @return the userId
	 */
	public String getUserId() {
	
		return userId;
	}

	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
	
		this.userId = userId;
	}

	private String userId;
	private int age;
	private List<Integer> accountNumber;
	private String summery;
	
	
	/**
	 * @return the summery
	 */
	public String getSummery() {
	
		return summery;
	}


	
	/**
	 * @param summery the summery to set
	 */
	public void setSummery(String summery) {
	
		this.summery = summery;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
	
		return age;
	}


	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
	
		this.age = age;
	}


	
	/**
	 * @return the accountNumber
	 */
	public List<Integer> getAccountNumber() {
	
		return accountNumber;
	}


	
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(List<Integer> accountNumber) {
	
		this.accountNumber = accountNumber;
	}
}
