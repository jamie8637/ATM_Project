package atm.business.server;

import javax.xml.bind.JAXBContext;

import org.apache.log4j.Logger;

import atm.business.api.services.AccountService;
import atm.business.api.services.AuthenticationService;
import atm.business.api.services.CustomerService;
import atm.business.server.services.AccountServiceImpl;
import atm.business.server.services.AuthenticationServiceImpl;
import atm.business.server.services.CustomerServiceImpl;
import data.AccountRepository;
import data.CustomerRepository;
import data.DataUtils;
import fromBusinesTeam.JAXBContextFactory;
import fromBusinesTeam.ServiceInvokingRequestProcessor;
import fromBusinesTeam.TcpServer;

/**
 * Main class used to start up the ATM server (the bank).
 * 
 * @author Mike Wilson
 * 
 */
public class Server {

	private static final String version = "0.1127.956";

	private static final Logger logger = Logger.getLogger(Server.class);

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.start();
	}

	private Server() {
	}

	/**
	 * This method should create and initialize the different components and
	 * services.
	 * 
	 * @throws Exception
	 */
	private void start() throws Exception {

		// load settings
		ServerProperties serverProperties = ServerProperties.load();

		// prepare data access layer objects
		DataUtils.configure(serverProperties.getDbUrl(),
				serverProperties.getDbUser(), serverProperties.getDbPassword());

		// create business layer services
		AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
		AccountServiceImpl accountService = new AccountServiceImpl();
		CustomerServiceImpl customerService = new CustomerServiceImpl();

		// inject data access layer objects into business layer services
		// (basically wire everything together)
		accountService.setAccountDao(AccountRepository.getInstance());

		customerService.setCustomerDao(CustomerRepository.getInstance());

		// create TCP listener (or whatever the communication layer
		// requires)
		JAXBContext jaxb = JAXBContextFactory.createContext();

		ServiceInvokingRequestProcessor serviceInvoker = new ServiceInvokingRequestProcessor(
				jaxb.createMarshaller(), jaxb.createUnmarshaller());

		TcpServer server = new TcpServer(serverProperties.getTcpPort(),
				serviceInvoker);
		logger.info("tcp server created");

		logger.info("registering services");
		serviceInvoker.registerService(
				AuthenticationService.class.getSimpleName(),
				authenticationService);
		serviceInvoker.registerService(AccountService.class.getSimpleName(),
				accountService);
		serviceInvoker.registerService(CustomerService.class.getSimpleName(),
				customerService);

		logger.info("starting tcp server version " + version);
		server.start(); // infinite loop to receive tcp client connections
	}
}
