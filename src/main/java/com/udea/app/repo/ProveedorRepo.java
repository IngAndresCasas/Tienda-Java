package com.udea.app.repo;

import com.udea.app.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor,Integer> {

}
