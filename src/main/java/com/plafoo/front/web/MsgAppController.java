package com.plafoo.front.web;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.intercom.api.Intercom;
import io.intercom.api.Visitor;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MsgAppController {

//    @PostMapping("/initialize")
//    public String initialize(@CookieValue(value="intercom-id-fx8n9i8g",defaultValue="") String visitorID) {
//    	
//    	Visitor visitor = new Visitor();
//    	
//    	String lat = "30.5128305";
//    	String lng = "100.0197909";
//    	String loc = "Seoul, South Korea";
//    	
//    	if(!visitorID.isEmpty()) {
//    		visitor = Visitor.findByID(visitorID);	
//    		lat = visitor.getCustomAttributes().get("Latitude").toString();
//    		lng = visitor.getCustomAttributes().get("longtitude").toString();
//    		loc = visitor.getCustomAttributes().get("Location").toString();
//    	}
// 
//    	StringBuilder sb = new StringBuilder();
//
//    	sb.append("{\"canvas\": {");
//    	sb.append("\"content\": {");
//    	sb.append("\"components\": [");
//    	sb.append("{ \"type\": \"text\", \"text\": \"You are on "+loc+" \", \"style\": \"header\", \"align\": \"left\"},");
//    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location on the map\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"sheet\", \"url\" : \"https://plafoo.com/map/"+lat+"/"+lng+"\"} }");
//    	sb.append("]");
//    	sb.append("}");
//    	sb.append("}}"); 
//    	
//    	return sb.toString();
//    }
    
    
    
    @PostMapping("/initialize")
    public String initialize() {
    	
    	StringBuilder sb = new StringBuilder();

    	sb.append("{\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location on the map\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"url\", \"url\" : \"https://plafoo.com/map\"} }");
    	sb.append("]");
    	sb.append("}");
    	sb.append("}}"); 
    	
    	return sb.toString();
    }
    
    @PostMapping("/submit")
    public String submit() {
 
    	StringBuilder sb = new StringBuilder();

    	sb.append("{\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"text\", \"text\": \"Someone just clicked something AND you just created a new component!\", \"style\": \"header\", \"align\": \"center\" }");
    	sb.append("]");
    	sb.append("}");
    	sb.append("}}");
    	
    	 
    	
    	return sb.toString();
    }
    
    
    @GetMapping("/Intercom/updateLoc/{vid}")
    public Map getVisitorLocation(@PathVariable("vid") String vid) {
 
    	Intercom.setToken("dG9rOjdlNGIxZGU4Xzg5OWJfNGM0M185MTJiXzQ2YTYxZTQxNmMyZDoxOjA=");
    	
    	String visitorID = vid;
    	
    	Visitor visitor = new Visitor();
    	
    	visitor = visitor.findByUserID(visitorID);
    	//visitor = Visitor.findByID(visitorID);	
    	
    	System.out.println(visitor.toString());
    	
    	return null;
    }
    
}
