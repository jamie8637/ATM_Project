package atm.business.api.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Joseph Persie
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountSub {
	
	@XmlElement
	private Integer accountSubId;
	
	@XmlElement
	private Integer accountId;

	@XmlElement
	private Integer accountType;
	
	@XmlElement
	private Double accountBalance;
	
	@XmlElement
	private Double pendingCredits;
	
	@XmlElement
	private Double holdAmount;
	
	@XmlElement
	private Boolean awaitingRelease;
	
	
	public AccountSub() {

	}


	public Integer getAccountSubId() {
		return accountSubId;
	}


	public void setAccountSubId(Integer accountSubId) {
		this.accountSubId = accountSubId;
	}


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


	public Integer getAccountType() {
		return accountType;
	}


	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}


	public Double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public Double getPendingCredits() {
		return pendingCredits;
	}


	public void setPendingCredits(Double pendingCredits) {
		this.pendingCredits = pendingCredits;
	}


	public Double getHoldAmount() {
		return holdAmount;
	}


	public void setHoldAmount(Double holdAmount) {
		this.holdAmount = holdAmount;
	}


	public Boolean getAwaitingRelease() {
		return awaitingRelease;
	}


	public void setAwaitingRelease(Boolean awaitingRelease) {
		this.awaitingRelease = awaitingRelease;
	}
}
