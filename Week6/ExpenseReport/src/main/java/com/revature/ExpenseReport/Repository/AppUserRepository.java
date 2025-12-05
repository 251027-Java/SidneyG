package com.revature.ExpenseReport.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ExpenseReport.Model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
