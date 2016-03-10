package com.presentation.service;

import java.math.BigDecimal;

import com.presentation.domain.ATM;

/**
 * The Class AtmService.
 */
public class AtmService {

	/** The atm. */
	private static ATM atm;

	/**
	 * Initialize atm.
	 *
	 * @param cash the cash
	 * @param bankType the bank type
	 * @return true, if successful
	 */
	public static boolean initializeAtm(BigDecimal cash, String bankType) {
		atm = new ATM(cash, bankType, true);

		return true;
	}

	/**
	 * Adds the cash.
	 *
	 * @param cash the cash
	 */
	public static void addCash(BigDecimal cash) {
		atm.setCurrentBalance(atm.getCurrentBalance().add(cash));
	}

	/**
	 * Removes the cash.
	 *
	 * @param cash the cash
	 */
	public static void removeCash(BigDecimal cash) {
		BigDecimal newValue = atm.getCurrentBalance().subtract(cash);
		if (newValue.compareTo(BigDecimal.ZERO) <= 0) {
			// IMPLEMENT EXCEPTION THROW
		}
		atm.setCurrentBalance(newValue);
	}

	/**
	 * Sets the failure state.
	 *
	 * @param failureMessage the failure message
	 * @param isFunctional the is functional
	 */
	public static void setFailureState(String failureMessage,
			boolean isFunctional) {
		atm.setFunctional(isFunctional);
	}

	/**
	 * Checks if is functional.
	 *
	 * @return true, if is functional
	 */
	public static boolean isFunctional() {
		return atm.isFunctional();
	}

	/**
	 * Gets the bank type.
	 *
	 * @return the bank type
	 */
	public static String getBankType() {
		return atm.getBankType();
	}

}
