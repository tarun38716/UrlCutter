package com.assignment.ib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.ib.entities.Urls;

/**
 * @author Tarun
 *
 */
@Repository("UrlsRepository")
public interface UrlsRepository extends CrudRepository<Urls, Integer>{

	@Query("SELECT url.longUrl, url.count FROM Urls url INNER JOIN "
			+ "url.account acc WHERE acc.accountId=:accountId")
	List<Object[]> getUrlStats(@Param("accountId") String accountId);
}

