package com.workfileuploadsystem.bean;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String occupation;
	
	public User(String firstName, String lastName, String email, String phone, String password, String occupation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.occupation = occupation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", occupation=" + occupation + "]";
	}
	


	

}
