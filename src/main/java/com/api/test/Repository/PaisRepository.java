package com.api.test.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.test.Models.Pais;

@Repository
public interface PaisRepository extends PagingAndSortingRepository<Pais, Long>{
	List<Pais> findByNameIgnoreCaseContaining(String name);
	Optional<Pais> findById(Long id);
}
