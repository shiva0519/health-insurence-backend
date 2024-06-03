package com.healthinsurence.www.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.Payment;

@Repository
public interface paymentRepo extends JpaRepository<Payment,String>{

	 @Query("SELECT p FROM Payment p JOIN p.register r WHERE r.email = :email")
	    Payment findByRegistrationEmail(@Param("email") String email);


	  List<Payment> findAllByRegisterEmail(String email);
//
//  @Modifying
//  @Query("UPDATE Payment p SET p.email = :newEmail WHERE p.email = :oldEmail")
//  void updateEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);


	
}
