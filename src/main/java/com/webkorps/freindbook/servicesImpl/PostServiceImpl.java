package com.webkorps.freindbook.servicesImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.Entity.Post;
import com.webkorps.freindbook.Entity.User;
import com.webkorps.freindbook.repository.PostRepository;
import com.webkorps.freindbook.service.PostService;


@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postrepo;
	


	public boolean uploadPst(MultipartFile image, HttpSession session) throws IOException {
        String photo = ""; // Initialize the photo variable with an empty string

        if (!image.isEmpty()) {
            photo = image.getOriginalFilename().trim(); // Get the original filename from MultipartFile
            InputStream i = image.getInputStream();
            
            String path = "C:\\Users\\raghu\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\FreindBook\\src\\main\\webapp\\users\\views\\image\\post\\" + photo;
            
            
            int bytes = 0;
            FileOutputStream fs = new FileOutputStream(path);
            
            while ((bytes = i.read()) != -1)
                fs.write(bytes);
            
            fs.close();
            
            int id = (int) session.getAttribute("id");
           
            Post p = new Post();
            p.setPostpic(photo); // Set the correct image filename
            User user = new User();
            user.setId(id);
            p.setUserId(user);
            postrepo.save(p);

            return true;
        }

        return false;
    }

	public List<Post> viewPost(int userid) {

		return this.postrepo.findbyUserid(userid);
	}


	public List<Post> viewPostofFollowing(int userid) {
		return this.postrepo.findbyFollowerid(userid);
	}

	
}
