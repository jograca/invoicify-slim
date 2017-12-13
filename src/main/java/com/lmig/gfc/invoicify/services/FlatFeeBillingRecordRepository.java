package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;

public interface FlatFeeBillingRecordRepository extends JpaRepository<FlatFeeBillingRecord, Long> {

}
