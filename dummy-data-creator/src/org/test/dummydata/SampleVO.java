package org.test.dummydata;

import java.util.List;


public class SampleVO {

	private String firstName;
	private String lastName;
	private List<EmployeeVO> users;
	

	
	/**
	 * @return the users
	 */
	public List<EmployeeVO> getUsers() {
	
		return users;
	}

	
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<EmployeeVO> users) {
	
		this.users = users;
	}

	private String phoneNumber;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
	
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
	
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
	
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	}
	
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
	
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
	
		this.phoneNumber = phoneNumber;
	}
}
