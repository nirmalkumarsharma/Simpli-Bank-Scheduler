package org.eko.repository;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.springframework.data.jpa.repository.JpaRepository;

/* An interface extending JpaRepository interface to use Spring JPA for the interaction with database through hibernate */
public interface SimpliJobRepository extends JpaRepository<SimpliJob, Integer>
{
	SimpliJob findByName(String name);

	List<SimpliJob> findByStatus(int status);

	SimpliJob findTopByOrderByNameDesc();
}
