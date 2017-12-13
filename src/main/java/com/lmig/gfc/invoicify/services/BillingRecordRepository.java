package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

}
