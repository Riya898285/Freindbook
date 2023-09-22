package com.webkorps.freindbook.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.freindbook.Entity.Coment;
import com.webkorps.freindbook.repository.CommentRepository;
import com.webkorps.freindbook.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentrepo;
	
	@Override
	public Coment addComment(Coment com) {
		commentrepo.save(com);
		return com;
	}

	@Override
	public List<Coment> listComment(int id) {
		List l=commentrepo.findByPostId(id);
		return l;
	}
	
	

}
