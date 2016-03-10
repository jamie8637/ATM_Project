package atm.business.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ServerProperties {

	private static final Logger logger = Logger
			.getLogger(ServerProperties.class);

	public static ServerProperties load() {
		Properties properties = new Properties();

		// set the defaults
		properties.setProperty("tcp.port", "4242");
		properties.setProperty("db.url",
				"jdbc:mysql://mysql.brokerlogic.com:3306/atmdb");
		properties.setProperty("db.user", "sd2");
		properties.setProperty("db.password", "fpcEbQ*XunF#h6BW$$b4");

		// load from server.properties file
		try (InputStream in = ClassLoader
				.getSystemResourceAsStream("server.properties")) {
			if (in == null) {
				logger.warn("Using default settings. Unable to locate server.properties file on classpath: "
						+ System.getProperty("java.class.path"));
			} else {
				properties.load(in);
			}
		} catch (IOException e) {
			logger.error(
					"An exception occurred while loading settings from server.properties",
					e);
		}

		return new ServerProperties(properties);
	}

	private Properties properties;

	private ServerProperties(Properties properties) {
		this.properties = properties;
	}

	public int getTcpPort() {
		return Integer.parseInt(properties.getProperty("tcp.port"));
	}

	public String getDbUrl() {
		return properties.getProperty("db.url");
	}

	public String getDbUser() {
		return properties.getProperty("db.user");
	}

	public String getDbPassword() {
		return properties.getProperty("db.password");
	}

}
