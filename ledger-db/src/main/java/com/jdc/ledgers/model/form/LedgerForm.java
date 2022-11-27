package com.jdc.ledgers.model.form;

public class LedgerForm {

	private int id;

	private String name;

	private LedgerType type;

	private String description;

	private boolean deleted;
	
	public LedgerForm() {
	}

	public LedgerForm(String name, LedgerType type, String description, boolean deleted) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.deleted = deleted;
	}

	public enum LedgerType {
		Credit, Debit
	}

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