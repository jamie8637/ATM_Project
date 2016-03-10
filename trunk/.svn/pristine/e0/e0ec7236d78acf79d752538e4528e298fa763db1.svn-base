package atm.business.api.model;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mike Wilson
 * 
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Session {

	@XmlElement
	private UUID sessionId;

	@XmlElement
	private Date lastActive;

	@XmlElement
	private BankUser bankUser;

	public Session() {

	}

	public Session(BankUser bankUser, Date lastActive) {
		this.bankUser = bankUser;
		this.lastActive = lastActive;
	}

	public UUID getSessionId() {
		return sessionId;
	}

	public void setSessionId(UUID sessionId) {
		this.sessionId = sessionId;
	}

	public Date getLastActive() {
		return lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

}
