package com.bunnings.codeChallenge.repository;

import com.bunnings.codeChallenge.model.CatalogA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Created by Kuladeep Parella on 04/07/2021
 */
@Repository
public interface CatalogA_Repo extends JpaRepository<CatalogA,Long> {


}
