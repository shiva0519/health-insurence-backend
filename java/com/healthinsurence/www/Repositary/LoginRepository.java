package com.healthinsurence.www.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.Loginpage;

@Repository
public interface LoginRepository extends JpaRepository<Loginpage,String> {



	





}
