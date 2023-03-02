package com.roberto.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberto.notas.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
