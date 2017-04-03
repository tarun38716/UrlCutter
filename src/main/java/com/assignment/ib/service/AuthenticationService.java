package com.assignment.ib.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Account;
import com.assignment.ib.repositories.AccountRepository;

/**
 * @author Tarun
 *
 */
@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	@Qualifier("AccountRepository")
	AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
		Account accInfo  =  accountRepository.findOne(accountId);
		GrantedAuthority authority = new SimpleGrantedAuthority("user");
		UserDetails userDetails = new User(accInfo.getAccountId(), 
				accInfo.getPassword(),Arrays.asList(authority));
		return userDetails;
	}

}
