package com.assignment.ib.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.ib.entities.Account;

/**
 * @author Tarun
 *
 */
@Repository("AccountRepository")
public interface AccountRepository extends CrudRepository<Account, String> {

}
