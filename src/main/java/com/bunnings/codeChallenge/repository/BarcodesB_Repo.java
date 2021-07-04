package com.bunnings.codeChallenge.repository;

import com.bunnings.codeChallenge.model.BarcodesB;
import com.bunnings.codeChallenge.model.CatalogB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Created by Kuladeep Parella on 05/07/2021
 */
@Repository
public interface BarcodesB_Repo extends JpaRepository<BarcodesB, Long> {


}
