package communications;

import org.apache.log4j.Logger;


public class TestLogger {

	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.fatal("fatal error");
	}

}
