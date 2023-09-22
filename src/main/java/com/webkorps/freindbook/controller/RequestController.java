package com.webkorps.freindbook.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webkorps.freindbook.Entity.Followers;
import com.webkorps.freindbook.Entity.Following;
import com.webkorps.freindbook.Entity.Request;
import com.webkorps.freindbook.Entity.User;
import com.webkorps.freindbook.repository.RequestRepository;
import com.webkorps.freindbook.servicesImpl.FollowerServicesImpl;
import com.webkorps.freindbook.servicesImpl.FollowingServiceImpl;
import com.webkorps.freindbook.servicesImpl.RequestServiceImpl;




@Controller
public class RequestController {


	@Autowired
	private RequestServiceImpl reqeustservice;
	@Autowired
	private FollowingServiceImpl followingser;
	@Autowired
	private FollowerServicesImpl followerservice;
	private HttpSession session;
	private int userid;
	

	@PostMapping("/search")
	    public String ReqSent(@ModelAttribute Request req,Model model,String username)
	   	{
		  req.setAcceptid(0);
		  reqeustservice.saveRequest(req);
		  if(Objects.nonNull(req))
		  {
			  model.addAttribute("msg","Request sent");
			  
		  } 	
	        return "search";
	    }
	   @GetMapping("/notification")
	   public String notification(Request req,HttpServletRequest request,Model model)
	   {
		   this.session = request.getSession();
			this.userid = (int) session.getAttribute("id");
			int acceptid = 0;
			List<Request> requests = reqeustservice.getRequests(userid, acceptid);
			model.addAttribute("requests", requests);
			System.out.println(requests);
			Iterator<Request> it = requests.listIterator();
			while (it.hasNext()) {

				System.out.println(it.next());
			}
			
		

			return "notification";
		  
	   }
		@PostMapping("/acceptrequest")
		public String acceptRequest(@RequestParam("id") int id, Followers followers, Following following,
				HttpServletRequest req) {
			this.session = req.getSession();
			followingser.addtoFollowingList(following);
			followerservice.addtoFollower(followers);
			reqeustservice.acceptRequest(id);
			return "notification";
		}

		
		@PostMapping("/declinerequest")
		public String deleteRequest(@RequestParam("id") int id, Followers followers, Following following,
				HttpServletRequest req) {
			
			this.session = req.getSession();
			reqeustservice.deleteRequest(id);
			return "profile";
		}
}
