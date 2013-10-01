package demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simplest possible controller with Spring Boot. The
 * <tt>@EnableAutoConfiguration</tt> does all the hard work - looks for
 * dependencies to use on the class-path.
 * 
 * @author Paul Chapman
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

	/**
	 * Simplest possible controller method - not even using output templates or
	 * JSP. Very similar to the Spring Boot Quick Start example.
	 * <p>
	 * Most of the effort when using Spring Boot is to get the dependencies
	 * right. Once they are in place, Spring Boot picks them up and applies
	 * default configuration rules.
	 * 
	 * @return
	 */
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<body><h1>Hello World!</h1><p>One instant web-app</p></body>";
	}

	/**
	 * Back to the future: run the application as a Java application and it will
	 * pick up a container Tomcat, Jetty) automatically if present. Pulls in
	 * Tomcat by default, running in embedded mode.
	 * <p>
	 * As it stands this application won't run as a traditional war file because
	 * it has no servlet configuration - see {@link Main} instead.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}
