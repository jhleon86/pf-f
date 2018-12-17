package com.plafoo.front.web;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.intercom.api.Visitor;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MsgAppController {

    @PostMapping("/initialize")
    public String initialize(@CookieValue(value="intercom-id-fx8n9i8g",defaultValue="") String visitorID) {
    	
    	Visitor visitor = new Visitor();
    	
    	String lat = "30.5128305";
    	String lng = "100.0197909";
    	String loc = "Seoul, South Korea";
    	
    	if(!visitorID.isEmpty()) {
    		visitor = Visitor.findByID(visitorID);	
    		lat = visitor.getCustomAttributes().get("Latitude").toString();
    		lng = visitor.getCustomAttributes().get("longtitude").toString();
    		loc = visitor.getCustomAttributes().get("Location").toString();
    	}
 
    	StringBuilder sb = new StringBuilder();

    	sb.append("{\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"text\", \"text\": \"You are on "+loc+" \", \"style\": \"header\", \"align\": \"left\"},");
    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location on the map\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"sheet\", \"url\" : \"https://plafoo.com/map/"+lat+"/"+lng+"\"} }");
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
}
