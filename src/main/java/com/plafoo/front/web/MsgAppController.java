package com.plafoo.front.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.intercom.api.Contact;
import io.intercom.api.CustomAttribute;
import io.intercom.api.Intercom;
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
    	sb.append("{ \"type\": \"text\", \"text\": \"Touch the button below to automatically track your location by GPS and send it to PLAFOO. Please agree to the location tracking.\", \"style\": \"header\", \"align\": \"center\" },");
    	sb.append("{ \"type\": \"button\", \"label\": \"Show me your location on the map.\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"url\", \"url\" : \"https://plafoo.com/map\"} }");
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
    
    
    @PostMapping("/intercom/update")
    public void update(HttpServletRequest request) {
 
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    	LocalDateTime now = LocalDateTime.now();
    	
    	String LocationLastUpdatedTime = dtf.format(now);   
    	String Latitude = request.getParameter("lat");
    	String Longtitude = request.getParameter("lng");
    	String Address = request.getParameter("loc");
    	String TrakingMap = "https://plafoo.com/intercom/tracking/";
    	
    	Intercom.setToken("dG9rOjdlNGIxZGU4Xzg5OWJfNGM0M185MTJiXzQ2YTYxZTQxNmMyZDoxOjA=");
    	String ID = request.getParameter("vsid");
    	
    	TrakingMap = TrakingMap+ID; 
    	
    	Contact contact = new Contact();
    	contact = Contact.findByUserID(ID);
    	
    	contact.addCustomAttribute(CustomAttribute.newStringAttribute("Latitude", Latitude));
    	contact.addCustomAttribute(CustomAttribute.newStringAttribute("Longtitude", Longtitude));
    	contact.addCustomAttribute(CustomAttribute.newStringAttribute("Address", Address));
    	contact.addCustomAttribute(CustomAttribute.newStringAttribute("TrakingMap", TrakingMap));
    	contact.addCustomAttribute(CustomAttribute.newStringAttribute("LocationLastUpdatedTime", LocationLastUpdatedTime));
    	
    	Contact.update(contact);
    }
    
    @PostMapping("/intercom/delete")
    public void delete(@RequestBody Map<String, Object> request) throws IOException {
    	
    	Map<String, Object> dataMap = (Map<String, Object>) request.get("data");   	
    	Map<String, Object> itemMap = (Map<String, Object>) dataMap.get("item");
 
    	String ID = (String) itemMap.get("user_id");
    	
    	Intercom.setToken("dG9rOjdlNGIxZGU4Xzg5OWJfNGM0M185MTJiXzQ2YTYxZTQxNmMyZDoxOjA=");
    	
    	Contact contact = new Contact();
    	contact = Contact.findByUserID("e1a7d875-d83a-46f7-86f4-73be98a98584");
    			
    	Contact.delete(contact);
    }
}
