package com.webkorps.freindbook.servicesImpl;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.Entity.User;
import com.webkorps.freindbook.exception.InvalidCredentialsException;
import com.webkorps.freindbook.repository.UserRepository;
import com.webkorps.freindbook.service.UserService;


@Service
public class UserServicesImpl implements UserService{

	@Autowired
	private UserRepository UserRepository;



  
	public User creatUser(String name,String email, String password)
	{
		
		User user=new User(name,email,password);
		String Username=this.generateUsername(name);
		user.setUsername(Username);
		return UserRepository.save(user);
	}
    
	public String generateUsername(String name)
	{
			    
	    String[] array = name.split(" ");
	    Random r=new Random();
	    String firstCharacter = array[0];
	    String username = firstCharacter.substring(0, 1).toUpperCase() + firstCharacter.substring(1)+r.nextInt(111,999);
	    return username;
	   
	  
	}
  
	public User findUsername(String username)
	{
		return UserRepository.findByUsername(username);
	}
	public User checkLogin(String email,String password)
	{
		
		 User user = UserRepository.findByEmail(email);
		    if (user == null || !user.getPassword().equals(password)) {
		        throw new InvalidCredentialsException("Invalid login credentials");
		    }
		    return user;
	}
	


	public User Update(String username,String favSong,String favPlace,String favbook) 
	{
		User user = UserRepository.findByUsername(username);
		user.setFavSong(favSong);
		user.setFavPlace(favPlace);
		user.setFavbook(favbook);
		UserRepository.save(user);
		return user;
		
	}
	
	public User profileSave(User u, MultipartFile imageFile, String username) throws IOException {
        String profilePhoto = "";
        if (!imageFile.isEmpty()) {
            profilePhoto = imageFile.getOriginalFilename().trim();
            byte[] imageData = imageFile.getBytes();
            String path = "C:\\Users\\raghu\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\FreindBook\\src\\main\\webapp\\users\\views\\image\\profilepicture\\" + profilePhoto;
           Files.write(Paths.get(path), imageData);
        }
       

        u = UserRepository.findByUsername(username);

        if (!profilePhoto.isEmpty()) {
            u.setProfilePic(profilePhoto);
        }
        UserRepository.save(u);
        return u;
    }

		
	
	public List<User> searchUser(@RequestParam("username") String user)
	{
		return UserRepository.searchByUsername(user);
	}
	 
	
	public User getUser(String username)
	{
		User u=UserRepository.findByUsername(username);
		return u;
	}
	public User getByEmail(User user)
	{
		User u=UserRepository.findByEmail(user.getEmail());
		return u;
	}


}
