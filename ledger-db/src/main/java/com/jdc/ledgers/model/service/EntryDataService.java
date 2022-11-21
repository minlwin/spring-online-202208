package com.jdc.ledgers.model.service;

import java.time.LocalDate;
import java.util.List;

import com.jdc.ledgers.model.form.EntryDataForm;
import com.jdc.ledgers.model.result.EntryData;

public interface EntryDataService {

	public EntryData findById(int id);

	public EntryData save(EntryDataForm form);

	public List<EntryData> search(Integer ledgerId, LocalDate from, LocalDate to);

}