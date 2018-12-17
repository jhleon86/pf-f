package com.plafoo.front.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MsgAppController {

    @PostMapping("/initialize")
    public String initialize() {
    	
    	String lat = "37.5128305";
    	String lng = "127.0197909";
    	String loc = "28-4 Jamwon-dong, Seocho-gu, Seoul, South Korea";
    	
    	StringBuilder sb = new StringBuilder();

    	sb.append("{\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"text\", \"text\": \"You are on "+loc+" \", \"style\": \"header\", \"align\": \"left\"}");
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
