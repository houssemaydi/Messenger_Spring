package tn.enig.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IMessageDao;
import tn.enig.dao.IUserDao;
import tn.enig.model.Message;
import tn.enig.model.User;

@CrossOrigin("*")
@RestController
public class Service {
	
	@Autowired
	IMessageDao daom;
	
	@Autowired
	IUserDao daou;

	public void setDaom(IMessageDao daom) {
		this.daom = daom;
	}
	
	public void setDaou(IUserDao daou) {
		this.daou = daou;
	}
	
	@GetMapping("/GetAllMessage")
	public List<Message> fnct1() {
		return daom.findAll();
	}
	@GetMapping("/GetAllUser")
	public List<User> fnct99() {
		return daou.findAll();
	}
	@GetMapping("/GetAllMessageSent/{id}")
	public List<Message> fnct2(@PathVariable("id") Integer id) {
		return daom.getAllMessagesSent(id);
				}
	
	@GetMapping("/GetAllMessageRecived/{id}")
	public List<Message> fnct3(@PathVariable("id") Integer id) {
		return daom.getAllMessagesRecived(id);
				}
	
	@GetMapping("/GetMessage/{id}")
	public Optional<Message> fnct5(@PathVariable("id") Integer id) {
		return daom.findById(id);
				}
	
	@GetMapping("/GetUser/{id}")
	public Optional<User> fnct98(@PathVariable("id") Integer id) {
		return daou.findById(id);
				}
	
	@PostMapping("/sendMessage")
	public Message fnct2(@RequestBody Message m) {
		return daom.save(m);
	}
	
	@PostMapping("/addUser")
	public User fnct22(@RequestBody User u) {
		return daou.save(u);
	}
	
	@PostMapping("/login")
	public User fnct3(@RequestBody User u) {	
		User u1=null;
		u1=daou.getuser(u.getUsername(),u.getPassword());
		return u1;
		
	}
	
	@DeleteMapping("/deleteMessage/{id}")
	public void fnct44(@PathVariable("id") Integer id) {
		daom.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
