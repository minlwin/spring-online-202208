package com.jdc.ledgers.model.result;

import java.time.LocalDate;

public class MonthlyReport {

	public MonthlyReport() {
	}

	private Ledger ledger;

	private LocalDate date;

	private int total;

	public Ledger getLedger() {
		return ledger;
	}

	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}