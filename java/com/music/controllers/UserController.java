 package com.music.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.music.dao.UserRepository;
import com.music.entities.User;


import jakarta.servlet.http.HttpSession;


@Controller
/* @RequestMapping("/user") */
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/signup")
	public String login(Model m , Principal principal) {
    return "index";	
	}
	
	@PostMapping("/process_register" )
	public String register( @ModelAttribute("user") User user ,  Model m, HttpSession session) {
	 try { 
		 
		 //result1 for server side validation errors
			/*
			 * if(result1.hasErrors()) { System.out.println("ERROR"+ result1.toString());
			 * //to send the data back to the form ,the data you have entered remains
			 * preserved even signup is reloaded again m.addAttribute("user", user); return
			 * "signup"; }
			 */
		   
			/*
			 * user.setPassword(passwordEncoder.encode(user.getPassword()));
			 */ 

		/* to save the user data to DataBase */
		 user.setRole("USER");
		 m.addAttribute("user", new User());
	  User result= this.userRepository.save(user);
	  
	  
	  
	  System.out.println("The user is successfully added!!");
		/*
		 * session.setAttribute("message", new
		 * Messages("Successfully registered","alert-success"));
		 */
	  return "login";
	  }catch(Exception e) {
		  e.printStackTrace();
			/*
			 * m.addAttribute("user", user); session.setAttribute("message", new
			 * Messages("Something Went wrong!!"+ e.getMessage(),"alert-danger"));
			 */
		  return "login";
	  }
	
	}
	
	 @RequestMapping("/signin")
	  	public String CustomLogIn(Model m) {
		   m.addAttribute("title" ,"LogIn");
	  		
	  		return "login";
	  		
	  	}
	 @RequestMapping("/failure")
	  	public String FailedSignIn(Model m) {
		   m.addAttribute("title" ,"LogIn");
	  		
	  		return "index";
	  		
	  	}
	
	
	
	@PostMapping("/user/index")
  	public String home(Model m) {

  		return "music_play";
  		
  	}
	
	

}
