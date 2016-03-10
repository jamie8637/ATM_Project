package atm.business.api.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mike Wilson
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	
	@XmlElement
	private String accountId;
	
	@XmlElement
	private String accountNumber;

	@XmlElement
	private BigDecimal availableBalance;

	@XmlElement
	private BigDecimal pendingBalance;

	@XmlElement
	private Set<BankUser> bankUsers;
	
	private String customerId;
	
	private String pinNumber;

	public Account() {

	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BigDecimal getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(BigDecimal pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public Set<BankUser> getBankUsers() {
		return bankUsers;
	}

	public void setBankUsers(Set<BankUser> bankUsers) {
		this.bankUsers = bankUsers;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}
}
