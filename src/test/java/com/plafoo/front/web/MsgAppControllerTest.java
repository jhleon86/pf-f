package com.plafoo.front.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.intercom.api.Visitor;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MsgAppControllerTest {
    @Test
    public void appbuild() {
        
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location(map)\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"url\", \"url\" : \"https://plafoo.com/\"} },");
    	sb.append("],");
    	sb.append("},");
    	sb.append("},"); 
    	
    	//then
        assertThat(sb.toString()).contains("Check your location(map)");
    	
    	
    }
    
//    
//    @Test
//    public void getVisitorInfo() {
//
//    	String visitorID = "21548567-6a23-44bc-8d07-c36fc3ace683";
//    	
//    	Visitor visitor = new Visitor();
//    	
//    	visitor = Visitor.findByID(visitorID);	
//    	
//    	System.out.println(visitor.toString());
//    	
//    }
//    
}
