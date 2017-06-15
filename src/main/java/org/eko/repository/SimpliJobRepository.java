package org.eko.repository;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpliJobRepository extends JpaRepository<SimpliJob, Integer>
{
	SimpliJob findByName(String name);

	List<SimpliJob> findByStatus(int status);
}
