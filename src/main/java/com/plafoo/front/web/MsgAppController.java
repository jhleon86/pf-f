package com.plafoo.front.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MsgAppController {

    @PostMapping("/initialize")
    public String initialize() {
 
    	StringBuilder sb = new StringBuilder();

    	sb.append("\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location(map)\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"sheet\", \"url\" : \"https://plafoo.com/\"} },");
    	sb.append("],");
    	sb.append("},");
    	sb.append("},"); 
    	
    	return sb.toString();
    }
}
