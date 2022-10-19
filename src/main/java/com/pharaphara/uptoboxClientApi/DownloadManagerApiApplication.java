package com.pharaphara.uptoboxClientApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DownloadManagerApiApplication extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(DownloadManagerApiApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DownloadManagerApiApplication.class, args);
	}

}
