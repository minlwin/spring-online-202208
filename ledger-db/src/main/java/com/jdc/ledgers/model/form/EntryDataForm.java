package com.jdc.ledgers.model.form;

import java.time.LocalDate;

public class EntryDataForm {

	private int id;

	private int ledgerId;

	private String details;

	private LocalDate useDate;

	private int quantity;

	private int unitPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getUseDate() {
		return useDate;
	}

	public void setUseDate(LocalDate useDate) {
		this.useDate = useDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

}