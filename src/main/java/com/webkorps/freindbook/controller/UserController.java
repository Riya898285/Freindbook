package com.webkorps.freindbook.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.Entity.Coment;
import com.webkorps.freindbook.Entity.Followers;
import com.webkorps.freindbook.Entity.Following;
import com.webkorps.freindbook.Entity.Like;
import com.webkorps.freindbook.Entity.Post;
import com.webkorps.freindbook.Entity.User;
import com.webkorps.freindbook.servicesImpl.CommentServiceImpl;
import com.webkorps.freindbook.servicesImpl.FollowerServicesImpl;
import com.webkorps.freindbook.servicesImpl.FollowingServiceImpl;
import com.webkorps.freindbook.servicesImpl.LikeServiceImpl;
import com.webkorps.freindbook.servicesImpl.PostServiceImpl;
import com.webkorps.freindbook.servicesImpl.UserServicesImpl;


@Controller
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserServicesImpl freindservice;
	@Autowired
	private FollowingServiceImpl followingservice;
	@Autowired 
	private FollowerServicesImpl followerService;
	@Autowired
	private PostServiceImpl postservice;
	@Autowired
	private LikeServiceImpl likeservice;
	@Autowired
	private CommentServiceImpl commentservice;
	
	private int userid;
	
	int i=0;
    //This API is used for showing the loginpage.
	@GetMapping
    public String loginHandler()
    {
   	    return "loginpage";
    }
    
    
    //Using this API we are register succesfully and go back to the usernamegshow page.
	@PostMapping
	public String afterSigninHandler(@ModelAttribute User u,Model m)
	{
		User user=freindservice.creatUser(u.getName(),u.getEmail(),u.getPassword());
		m.addAttribute(user);
		m.addAttribute("username",user.getUsername());
	    return "usernameshow";	
    }
	
	
	//Using this API we are fetch the signup form.
	@GetMapping("/signup")
	public String showSignupFormHandler()
	{
		return "signup";
	}
	
	   //Using this API we acces the profile
	   @GetMapping("/profile")
	   public String showProfile(HttpSession session, Model model) {
	       int userId = (int) session.getAttribute("id");
	       String name = (String) session.getAttribute("name");
	      
	       List<Following> followingList = followingservice.showFolowings(userId);
	       model.addAttribute("followinglist", followingList);
	       
	       List<Followers> followerlist=followerService.showFollowers(userId);
	       model.addAttribute("followerlist", followerlist);
	       
	       List<Post> AllpostofUser=postservice.viewPost(userid);
	       model.addAttribute("post",AllpostofUser);
	       
	       List<Like> likePost=likeservice.getAllLikes(userid);
		   model.addAttribute("like",likePost);
			
		   List<Coment>  commentpost=commentservice.listComment(userid);
		   model.addAttribute("comment",commentpost);
			
	       
	       
	       
	       
	      //  model.addAttribute("name", name);
	       return "profile";
	   }
	
	
    

	
	//Using this API we are show profile detailsss!!
	@PostMapping("/profilesave")
	public String Update(@ModelAttribute("user") User user, HttpSession session,
			@RequestParam("profile_pic") MultipartFile imageFile,Model model) throws IOException {
		freindservice.Update(user.getUsername(),user.getFavSong(), user.getFavPlace() ,user.getFavbook());
		User u =freindservice.profileSave(user, imageFile, (String) session.getAttribute("username"));
	
		
		/*model.addAttribute("profilepic", user.getProfilePic());
		model.addAttribute("favSong",user.getFavSong());
		model.addAttribute("favbook",user.getFavbook());
		model.addAttribute("favPlace",user.getFavPlace());*/
		
		return "profile";
	}
	
	
	//This API is used for search other users in freindbook
	@GetMapping("/search")
	public String Search(User user, Model model, String username, HttpSession session) {
		if (username != null) {
			
			List<User> list = freindservice.searchUser(username);
			model.addAttribute("list", list);
			//session.setAttribute("otheruser",user);
			return "search";
		} 
		
		model.addAttribute("message", "No Users Found..");

	
		return "search";
	}
	 @GetMapping("/home")
	    public String home(Model m,HttpSession session,String username,Model model)
	    {
		    session.getAttribute("username");
		    this.userid = (int) session.getAttribute("id");
		    List<Post> Allpostsoffollowing = postservice.viewPostofFollowing(userid);
			model.addAttribute("Allpost", Allpostsoffollowing);
			
			List<Like> likePost=likeservice.getAllLikes(userid);
			model.addAttribute("likess",likePost);
			
			List<Coment>  commentpost=commentservice.listComment(userid);
			model.addAttribute("comment",commentpost);
			
	    	return "home";
	    }
	    
	    //Using this API  we are on the Home Page.   
		@PostMapping("/home")
		public String homeHandler(@ModelAttribute User u,Model m,HttpSession session)
		{
			
		
			if(freindservice.checkLogin(u.getEmail(), u.getPassword()) != null)
			{
				
				User user=freindservice.getByEmail(u);
				System.out.println(user);
				
		      if(Objects.nonNull(session))
				{
					session.setAttribute("username", user.getUsername());
					session.setAttribute("id",user.getId());
					session.setAttribute("name",user.getName());
					session.setAttribute("favSong", user.getFavSong());
					session.setAttribute("favPlace",user.getFavPlace());
					session.setAttribute("favbook",user.getFavbook());
					session.setAttribute("profilepic",user.getProfilePic());
					System.out.print(user.getProfilePic());
					
			    }
				m.addAttribute("username",user.getUsername());
				
				return "home";
				
			}
			
				
				return "home";			
	     	}
		
		@GetMapping("/notification")
		public String shownotification() {
			return "notification";
		}
   
}
























