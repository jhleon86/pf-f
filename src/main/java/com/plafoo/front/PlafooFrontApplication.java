package com.plafoo.front;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class PlafooFrontApplication {
	
	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "C:\\workspace_sts\\real\\real-application.yml," /*로컬(windows)*/
			+ "/home/ec2-user/app/config/plafoo-front/real-application.yml"; /*EC2*/
	

	public static void main(String[] args) {
		new SpringApplicationBuilder(PlafooFrontApplication.class)
        .properties(APPLICATION_LOCATIONS)
        .run(args);
	}
}
