package com.social.backend.DAO;

import java.util.List;
import com.social.backend.model.Events;

public interface EventsDAO {

	public boolean saveEvent(Events event);
	
	public boolean updateEvent(Events event);
	
	public boolean removeEvent(int e_eventId);
	
	public List<Events> getAllEvents();
	
	public Events getEventById(int e_eventId);

}
