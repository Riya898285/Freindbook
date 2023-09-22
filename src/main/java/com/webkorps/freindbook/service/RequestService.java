package com.webkorps.freindbook.service;

import java.util.List;

import com.webkorps.freindbook.Entity.Request;

public interface RequestService {
	
	public Request saveRequest(Request request);
	public List<Request> getRequests(int recieverrid,int accepptid);
	public int acceptRequest(int id);
	public int deleteRequest(int id);

}
