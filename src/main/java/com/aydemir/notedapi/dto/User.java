package com.aydemir.notedapi.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    @Column(unique = true)
    String email; //todo add email validator later

    String name;

    @NotNull
    String password; //todo add password validator later
}
