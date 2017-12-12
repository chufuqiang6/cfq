package com.cfq.demo.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.cfq.demo.util.Constants;
@XmlRootElement  
@XmlType(name = "User", namespace = Constants.NS)  
public class User implements Serializable{
    /**
	 * use
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String userName;

    private String passWord;

    private String updateTime;

    private String addTime;

    private String addPeople;
    
    private String updatePeople;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getAddPeople() {
		return addPeople;
	}

	public void setAddPeople(String addPeople) {
		this.addPeople = addPeople;
	}

	public String getUpdatePeople() {
		return updatePeople;
	}

	public void setUpdatePeople(String updatePeople) {
		this.updatePeople = updatePeople;
	}

    
}