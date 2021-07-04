package com.bunnings.codeChallenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
Created by Kuladeep Parella on 05/07/2021
 */
@Data
@NoArgsConstructor
@Entity
public class SuppliersA {

    @Id
    private Long id;
    private String name;

    public SuppliersA(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
