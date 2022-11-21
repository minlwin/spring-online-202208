package com.jdc.ledgers.model.result;

import java.time.LocalDate;

import com.jdc.ledgers.model.form.LedgerForm.LedgerType;

public class EntryData {

	public EntryData() {
	}

	private int id;

	private int ledgerId;

	private LedgerType ledgerType;

	private String ledgerName;

	private int ownerId;

	private String ownerName;

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

	public LedgerType getLedgerType() {
		return ledgerType;
	}

	public void setLedgerType(LedgerType ledgerType) {
		this.ledgerType = ledgerType;
	}

	public String getLedgerName() {
		return ledgerName;
	}

	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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