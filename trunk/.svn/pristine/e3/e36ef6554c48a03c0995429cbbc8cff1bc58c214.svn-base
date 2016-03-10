package atm.business.api.model;

import java.math.BigDecimal;

/**
 * 
 * @author Mike Wilson
 * 
 */
public class Deposit extends Transaction {

	private BigDecimal amount;

	/**
	 * The amount that has already been added to the Account's availableBalance.
	 */
	private BigDecimal amountCleared;

	private boolean pending;

	public Deposit() {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountCleared() {
		return amountCleared;
	}

	public void setAmountCleared(BigDecimal amountCleared) {
		this.amountCleared = amountCleared;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

}
