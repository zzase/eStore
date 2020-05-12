package kr.ac.hansung.cse.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//private static final Logger logger = LoggerFactory.getLogger("kr.ac.hansung.cse.controller.HomeController.java");
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale) {
		//logging level : trace -> debug-> info-> warn -> error
		
		logger.info("info level: Welcome home! THe client locale is {}",locale);
		
		String url = request.getRequestURI().toString();
		String clientIPaddress = request.getRemoteAddr();
		
		logger.info("Request URL: {}, client IP : {}",url,clientIPaddress);
		
		//logback.xml에서 설정한 logging level 은 debug이기 때문에 trace는 출력되지 않는다. 
		return "home";
	}
	
}
