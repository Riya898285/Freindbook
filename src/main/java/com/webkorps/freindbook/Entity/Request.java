package com.webkorps.freindbook.Entity;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity 
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User senderid;
	private int recieverid;
	public Request(int id, User senderid, int recieverid, int acceptid) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.recieverid = recieverid;
		this.acceptid = acceptid;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer acceptid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getSenderid() {
		return senderid;
	}
	public void setSenderid(User senderid) {
		this.senderid = senderid;
	}
	public int getRecieverid() {
		return recieverid;
	}
	public void setRecieverid(int recieverid) {
		this.recieverid = recieverid;
	}
	public int getAcceptid() {
		return acceptid;
	}
	public void setAcceptid(int acceptid) {
		this.acceptid = acceptid;
	}
	
}
