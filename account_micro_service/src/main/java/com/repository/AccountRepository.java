package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	// custom query based upon non-primary key, we find account details

	@Query("select account.accno from Account account where account.emailid=:emalilId")
	public int findAccountNumber(@Param("emalilId") String emalilId);
}
