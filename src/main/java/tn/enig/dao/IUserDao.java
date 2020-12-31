package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enig.model.User;
@CrossOrigin("*")
@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
	
	
	@Query("select u from User u where u.username=?1 and u.password=?2")
	public User getuser(String username,String password);
	
	


}
