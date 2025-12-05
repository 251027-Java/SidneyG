package com.revature.ExpenseReport.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "app_users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})
    }
)
@Data
@NoArgsConstructor

public class AppUser {
    // Fields
    @Id //ensures not null and unique (primary key)
    @GeneratedValue
    private Long userid;

    @Column(unique = true)
    private String username;
    
    @Column(nullable = false)
    private String password;

    @Column(name = "user_role")
    private String userrole;

    // Constructor

    public AppUser( String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.userrole = role;
    }

    // Methods
    
}
