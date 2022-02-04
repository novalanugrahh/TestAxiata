package com.axiatadigitallabs.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
	@Value("${browser}")
	private String browser;
	
	@Value("${textafterlogin}")
	private String textafterLogin;
	
	@Value("${name}")
	private String username;
	
	@Value("${password}")
	private String Password;
	
	@Value("${description}")
	private String DescriptionGist;
	
	@Value("${filename}")
	private String filegist;
	
	@Value("${code}")
	private String CodeGist;
	
	@Value("${textafterseelist}")
	private String TextAfterSeeList;
	
	@Value("${textafterdelete}")
	private String TextAfterDelete;
	
	@Value("${editdescription}")
	private String editDescriptionGist;
	
	@Value("${editfilename}")
	private String editfilegist;
	
	@Value("${editkodegist}")
	private String editCodeGist;
	
	@Value("${textafterlogout}")
	private String textAfterLogout;
}
