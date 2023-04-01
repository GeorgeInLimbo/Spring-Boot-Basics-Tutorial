package com.smt.georgeclam;

import org.springframework.data.jpa.repository.JpaRepository;

/****
 <b>Title:</b> CustomerRepository<br>
 <b>Project:</b> area51club<br>
 <b>Description:</b> <br>
 <b>Copyright:</b> Copyright (c) 2023<br>
 <b>Company:</b> Silicon Mountain Technologies<br>
 @author George Clam
 @version 1.0
 @since 3/30/23
 @updates:
 ****/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
