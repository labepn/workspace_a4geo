package eterrapn.reps;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eterrapn.jpa.Kn_Nosilacprava;

public interface KnNosilacpravaRepository extends JpaRepository<Kn_Nosilacprava, Integer>{

	
	
}