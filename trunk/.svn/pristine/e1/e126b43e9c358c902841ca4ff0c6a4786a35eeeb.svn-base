package atm.business.server.dal;

import java.util.UUID;

import atm.business.api.model.Session;

/**
 * SessionDao (Data Access Object) used to interact with Sesssions in the
 * database.
 * 
 * @author Mike Wilson
 * 
 */
public interface SessionDao {

	/**
	 * Accepts a Session object without the primary key (sessionId populated).
	 * Returns a Session with the primary key populated on success. Failure
	 * should throw an appropriate exception.
	 * 
	 * @param session
	 * @return
	 */
	Session createSession(Session session); // might need to specify a DAO
											// exception or something like that
											// which can be thrown here.

	/**
	 * Updates an existing session. Typically the only change would be the
	 * lastActiveField.
	 * 
	 * @param session
	 * @return
	 */
	Session updateSession(Session session);

	/**
	 * Retrieves a Session by its sessionId.
	 * 
	 * @param sessionId
	 * @return
	 */
	Session getSessionBySessionId(UUID sessionId);

}
