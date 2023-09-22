package com.webkorps.freindbook.service;

import java.util.List;

import com.webkorps.freindbook.Entity.Coment;

public interface CommentService {

	public Coment addComment(Coment com);
	public List<Coment> listComment(int id);
	
}

