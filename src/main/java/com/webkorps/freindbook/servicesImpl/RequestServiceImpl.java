package com.webkorps.freindbook.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webkorps.freindbook.Entity.Request;
import com.webkorps.freindbook.repository.RequestRepository;
import com.webkorps.freindbook.service.RequestService;






@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	public static RequestRepository reqrepo;
	
	public RequestRepository getReqrepo() {
		return reqrepo;
	}
	@Autowired
	public void setReqrepo(RequestRepository reqrepo) {
		this.reqrepo = reqrepo;
	}
	
	public Request saveRequest(Request request) {
		reqrepo.save(request);
		return request;
	}
	
	public List<Request> getRequests(int recieverrid,int accepptid)
	{
		
		return this.reqrepo.findByReciverId(recieverrid, accepptid);
		
	}
	
	@Transactional
	public int acceptRequest(int id) {
		reqrepo.acceptRequest(id);
		return 1;
	}

	@Transactional
	public int deleteRequest(int id) {
	    try {
	        reqrepo.deleteById(id);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception for debugging
	        return 0; // Indicate failure
	    }
	}

		

	
	

}
