package org.liangjunjie.store.entity;

import java.io.Serializable;

public class User extends BaseEntity implements Serializable{
	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private String avatar;
	private String phone;
	private String email;
	private Integer gender;
	private Integer isDelete;
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", salt=" + salt + ", avatar=" + avatar
				+ ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", isDelete=" + isDelete + "]";
	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
