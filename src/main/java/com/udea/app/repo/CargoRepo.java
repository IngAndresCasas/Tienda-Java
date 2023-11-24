package com.udea.app.repo;

import com.udea.app.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepo extends JpaRepository<Cargo,Integer> {
}
