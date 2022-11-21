package com.jdc.ledgers.model.result;

import java.time.YearMonth;

public class YearlyReport {

	public YearlyReport() {
	}

	private Ledger ledger;

	private YearMonth month;

	private int total;

	public Ledger getLedger() {
		return ledger;
	}

	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}

	public YearMonth getMonth() {
		return month;
	}

	public void setMonth(YearMonth month) {
		this.month = month;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}