package atm.business.api.model;

import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author Mike Wilson
 * 
 */
public class Transaction {

	/**
	 * Primary key
	 */
	private UUID transactionId;

	/**
	 * When the transaction was submitted or maybe when it was persisted...
	 */
	private Date timestamp;

	/**
	 * The account this transaction applies to.
	 */
	private Account account;

	/**
	 * The session that was used to submit this transaction.
	 */
	private Session session;

	public Transaction() {

	}

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
