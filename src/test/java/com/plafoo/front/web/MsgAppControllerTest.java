package com.plafoo.front.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MsgAppControllerTest {
    @Test
    public void appbuild() {
        
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("\"canvas\": {");
    	sb.append("\"content\": {");
    	sb.append("\"components\": [");
    	sb.append("{ \"type\": \"button\", \"label\": \"Check your location(map)\", \"style\": \"primary\", \"id\": \"url_button\", \"action\": {\"type\": \"sheet\", \"url\" : \"https://plafoo.com/\"} },");
    	sb.append("],");
    	sb.append("},");
    	sb.append("},"); 
    	
    	//then
        assertThat(sb.toString()).contains("Check your location(map)");
    	
    	
    }
}
