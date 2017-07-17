package com.social.backend.DAO;

import java.util.List;
import com.social.backend.model.Friend;


public interface FriendDao {
	
	public List<Friend> getMyFriends(String userId);
	
	public Friend get(String userId,String friendId);
	
	public boolean save(Friend friend);
	
	public boolean update(Friend friend);
	
	public boolean remove(String userId,String friendId);
	
	public List<Friend> getNewFriendRequests(String userId);
	


}
