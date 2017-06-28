package com.social.backend.controller;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

import com.social.backend.DAO.EventsDAO;
import com.social.backend.model.Events;

	
@RestController
public class EventsController {
		
		
		@Autowired
		EventsDAO eventsDAO;
		
		private static final Logger log = LoggerFactory.getLogger(EventsController.class);

		
		@RequestMapping(value = "/EventList", method = RequestMethod.GET)
		public ResponseEntity<List<Events>> listAllEvents(){
			log.debug("**********Starting of Method listAllEvents**********");
			List<Events> eventList = eventsDAO.getAllEvents();
			if(eventList.isEmpty()){
				return new ResponseEntity<List<Events>>(HttpStatus.NO_CONTENT);
			}else{
				log.debug("**********Size found :- "+eventList.size()+"**********");
				log.debug("**********Ending of Method listAllEvents**********");
				return new ResponseEntity<List<Events>>(eventList,HttpStatus.OK);
			}
		}
			

		@RequestMapping(value = "/CreateEvent", method = RequestMethod.POST)
		public ResponseEntity<Events> createEvent(@RequestBody Events event){
			log.debug("**********Starting of Method createUser**********");
			if(eventsDAO.getEventById(event.getE_eventId()) == null){
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date date = new Date();
	            String eventDate = (dateFormat.format(date));
	            event.setE_eventDate(eventDate);
	            event.setE_eventStatus('1');
				eventsDAO.saveEvent(event);
				event = new Events();
				event.setErrorMessage("New Event Posted Successfully..!!!");
				log.debug("New Event Created Successfully");
				return new ResponseEntity<Events>(event , HttpStatus.OK);
			}
			log.debug("**********Event already Exist with ID :-"+event.getE_eventId()+" **********");
			event.setErrorMessage("Event Already Exist With ID:-"+event.getE_eventId());
			return new ResponseEntity<Events>(event , HttpStatus.OK);
		}
		

		@RequestMapping(value = "/UpdateEvent/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Events> updateEvent(@PathVariable("id") int eventId,@RequestBody Events event){
			log.debug("**********Starting of Method updateEvent**********" + eventId);
			if(eventsDAO.getEventById(eventId) == null){
				log.debug("**********Event Does not Exist with this ID :-"+eventId+"**********");
				event = new Events();
				event.setErrorCode("404");
				event.setErrorMessage("Event Does not Exist with this ID :-"+eventId);
				return new ResponseEntity<Events>(event , HttpStatus.NOT_FOUND);
			}else{
				event.setE_eventId(eventId);
				eventsDAO.updateEvent(event);
				log.debug("**********Event Updated Successfully WITH ID:- "+eventId+"**********");
				return new ResponseEntity<Events>(event , HttpStatus.OK);
			}
		}
		
		@RequestMapping(value = "/RemoveEvent/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Events> removeEvent(@PathVariable("id") int eventId){
			log.debug("**********Starting of Method removeUser**********");
			Events event = eventsDAO.getEventById(eventId);
			if(event == null){
				log.debug("**********Event Does not Exist with this ID :-"+eventId+"**********");
				event = new Events();
				event.setErrorCode("404");
				event.setErrorMessage("Event Does not Exist with this ID :-"+ eventId);
				return new ResponseEntity<Events>(event , HttpStatus.NOT_FOUND);
			}else{
				eventsDAO.removeEvent(eventId);
				log.debug("**********Event Deleted Successfully WITH ID:- "+eventId+"**********");
				return new ResponseEntity<Events>(event , HttpStatus.OK);
			}
		}
}


