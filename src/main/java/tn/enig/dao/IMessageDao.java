package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.model.Message;
import tn.enig.model.User;
@CrossOrigin ("*")
@Repository
public interface IMessageDao extends JpaRepository<Message, Integer>{

	@Query("select m from Message m where m.usersend.id =:x")
	public List<Message> getAllMessagesSent(@Param("x") Integer id); 
	
	@Query("select m from Message m where m.userreceive.id =:x")
	public List<Message> getAllMessagesRecived(@Param("x") Integer id);
	
	
}
