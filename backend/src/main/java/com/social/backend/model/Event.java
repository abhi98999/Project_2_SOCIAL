package com.social.backend.model;

import java.sql.Clob;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="E_Event")
public class Event extends ErrorPage {
	
	@Id
	private String e_eventId;
	private String e_eventName; //EVENT TITLE
	private String e_eventVenue;
	private Clob  e_eventDescp;
	private String e_eventDate;
	private char eventStatus;
	
	public char getEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(char eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getE_eventId() {
		return e_eventId;
	}
	public void setE_eventId(String e_eventId) {
		this.e_eventId = e_eventId;
	}
	public String getE_eventName() {
		return e_eventName;
	}
	public void setE_eventName(String e_eventName) {
		this.e_eventName = e_eventName;
	}
	public String getE_eventVenue() {
		return e_eventVenue;
	}
	public void setE_eventVenue(String e_eventVenue) {
		this.e_eventVenue = e_eventVenue;
	}
	public Clob getE_eventDescp() {
		return e_eventDescp;
	}
	public void setE_eventDescp(Clob e_eventDescp) {
		this.e_eventDescp = e_eventDescp;
	}
	public String getE_eventDate() {
		return e_eventDate;
	}
	public void setE_eventDate(String e_eventDate) {
		this.e_eventDate = e_eventDate;
	}
	
	
	
	
	
}
