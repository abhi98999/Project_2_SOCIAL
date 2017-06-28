package com.social.backend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="C_Event")
public class Events extends ErrorPage {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private int e_eventId;
		
		@NotBlank(message="Please Enter Event Title")
		private String e_eventTitle;
		
		@NotBlank(message="Please Enter Event Description")
		private String e_eventDescription;
		
		private String e_eventDate;
			
		@NotBlank(message="Please Enter Event Venue")
		private String e_eventVenue;
		
		private char e_eventStatus;

		
		
		

		public int getE_eventId() {
			return e_eventId;
		}

		public void setE_eventId(int e_eventId) {
			this.e_eventId = e_eventId;
		}

		public String getE_eventTitle() {
			return e_eventTitle;
		}

		public void setE_eventTitle(String e_eventTitle) {
			this.e_eventTitle = e_eventTitle;
		}

		public String getE_eventDescription() {
			return e_eventDescription;
		}

		public void setE_eventDescription(String e_eventDescription) {
			this.e_eventDescription = e_eventDescription;
		}

		public String getE_eventDate() {
			return e_eventDate;
		}

		public void setE_eventDate(String e_eventDate) {
			this.e_eventDate = e_eventDate;
		}

		public String getE_eventVenue() {
			return e_eventVenue;
		}

		public void setE_eventVenue(String e_eventVenue) {
			this.e_eventVenue = e_eventVenue;
		}

		public char getE_eventStatus() {
			return e_eventStatus;
		}

		public void setE_eventStatus(char e_eventStatus) {
			this.e_eventStatus = e_eventStatus;
		}
		
		
	}
