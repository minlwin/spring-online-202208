package com.jdc.ledgers.model.service;

import java.time.YearMonth;
import java.util.List;

import com.jdc.ledgers.model.form.LedgerForm;
import com.jdc.ledgers.model.result.Ledger;
import com.jdc.ledgers.model.result.MonthlyReport;
import com.jdc.ledgers.model.result.YearlyReport;

public interface LedgerService {

	public List<Ledger> getUserLedgers();

	public Ledger save(LedgerForm form);

	public Ledger findById(int id);

	public List<YearlyReport> getYearlyReport(int year);

	public List<MonthlyReport> getMonthlyReport(YearMonth month);

}