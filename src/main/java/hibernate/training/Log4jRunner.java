package hibernate.training;

import org.jboss.logging.Logger;

public class Log4jRunner {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(Log4jRunner.class);
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
}
