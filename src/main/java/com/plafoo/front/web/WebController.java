package com.plafoo.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.intercom.api.Contact;
import io.intercom.api.Intercom;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	//private PostsService postsService;
	
    @GetMapping("/")
    public String main() {
    	/*o
    	model.addAttribute("posts", postsService.findAllDesc());
    	
        return "main";
        */
    	
    	return "index";
    }
    
    
//    @PostMapping("/map/{lat}/{lng}")
//    public String map(@PathVariable("lat") String lat,@PathVariable("lng") String lng, Model model) { 
//    	
//    	model.addAttribute("lat",lat);
//    	model.addAttribute("lng",lng);
//    	
//    	return "map";
//    }
    
    
    @GetMapping("/map")
    public String map() { 
    	return "map";
    }
    
    @GetMapping("/intercom/tracking/{vsid}")
    public String traking(@PathVariable("vsid") String ID, Model model) { 
  	
    	Intercom.setToken("dG9rOjdlNGIxZGU4Xzg5OWJfNGM0M185MTJiXzQ2YTYxZTQxNmMyZDoxOjA=");
    	
    	Contact contact = new Contact();
    	contact = Contact.findByUserID(ID);
    	
    	contact.getCustomAttributes();
    	
    	String lat = contact.getCustomAttributes().get("Latitude").getValue().toString();
    	String lng = contact.getCustomAttributes().get("Longtitude").getValue().toString();
    	
    	model.addAttribute("lat", lat);
    	model.addAttribute("lng", lng);
    	model.addAttribute("ID", ID);
    	
    	return "intercom/tracking";
    }
    
}