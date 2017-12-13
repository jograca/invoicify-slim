package com.lmig.gfc.invoicify.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	public BillingRecord findById(Long id);

	List<BillingRecord> findByClientIdAndLineItemIsNull(Long clientId);

}
