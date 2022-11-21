package com.jdc.ledgers.model.result;

import com.jdc.ledgers.model.form.LedgerForm.LedgerType;

public class Ledger {

	public Ledger() {
	}

	private int id;

	private String name;

	private LedgerType type;

	private int ownerId;

	private String ownerName;

	private String description;

	private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LedgerType getType() {
		return type;
	}

	public void setType(LedgerType type) {
		this.type = type;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}