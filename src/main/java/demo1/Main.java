package demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Main entry point for our application using Spring Boot. It can be run as an
 * executable or as a standard war file. This is a much more typical way to
 * setup and run an application since you would usually have many Controllers
 * and making one of them also boot the application would be poor design.
 * <p>
 * Details of annotations used:
 * <ul>
 * <li><tt>@EnableAutoConfiguration</tt>: makes Spring Boot setup its defaults.
 * <li><tt>@Import</tt>: Bring in the Controller we need. Again in a typical
 * application you would either component-scan for the controllers and other
 * components that you need using <tt>@ComponentScan</tt> or declare them in XML
 * beans file and load them via <t>@ImportREsource</tt>. classes.
 * </ul>
 * 
 * @author Paul Chapman
 */
@Import(value = SampleController.class)
@EnableAutoConfiguration
public class Main extends SpringBootServletInitializer {

	public static final String QUICK_PROFILE = "Quick";
	public static final String REST_PROFILE = "REST";

	/**
	 * When running as a war, this class is picked up as the Servlet
	 * Initialiser. You must override this abstract method to tell it what
	 * Spring Java Configuration files to use. In this case, it is using itself,
	 * so it will pick up and use all the class annotations above to initialise
	 * the application.
	 * <p>
	 * You <i>must</i> have a container that supports the Servlet 3 spec.
	 */
	@Override
	protected Class<?>[] getConfigClasses() {
		return new Class<?>[] { Main.class };
	}

	/**
	 * When running as a Java application, Spring Boot will automatically run up
	 * an embedded container (Tomcat by default). <tt>SpringApplication.run</tt>
	 * tells Spring Boot to use this class as the initialiser for the whole
	 * application (via the class annotations above).
	 * 
	 * @param args
	 *            Any command line arguments.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new Main().run(args);
	}

	/**
	 * Run the application using Spring Boot.
	 * 
	 * @param args
	 *            Any command line arguments.
	 */
	protected void run(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
