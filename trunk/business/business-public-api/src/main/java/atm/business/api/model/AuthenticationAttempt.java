package atm.business.api.model;

import java.util.Date;

/**
 * 
 * @author Mike Wilson
 * 
 */
public class AuthenticationAttempt {

	/**
	 * Whether or not the attempt was successful.
	 */
	private boolean successful;

	/**
	 * When the attempt occurred.
	 */
	private Date timestamp;

	/**
	 * The cardNumber attempting to be authenticated.
	 */
	private Integer cardNumber;

	public AuthenticationAttempt() {

	}

	public AuthenticationAttempt(Integer cardNumber, Date timestamp,
			boolean successful) {
		this.cardNumber = cardNumber;
		this.timestamp = timestamp;
		this.successful = successful;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

}
