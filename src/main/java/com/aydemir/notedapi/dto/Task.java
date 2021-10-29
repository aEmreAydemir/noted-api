package com.aydemir.notedapi.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String userId;
    @NotNull
    private String description;
    @NotNull
    private boolean checked;
}
