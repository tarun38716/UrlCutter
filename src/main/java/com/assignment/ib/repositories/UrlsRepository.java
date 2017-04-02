package com.assignment.ib.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.ib.entities.Urls;

/**
 * @author Tarun
 *
 */
@Repository("UrlsRepository")
public interface UrlsRepository extends CrudRepository<Urls, Integer>{
	
}

