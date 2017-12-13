package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.User;

public interface RateBasedBillingRecordRepository extends JpaRepository<User, Long> {

}
