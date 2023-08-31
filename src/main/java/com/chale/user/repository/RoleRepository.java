package com.chale.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chale.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
