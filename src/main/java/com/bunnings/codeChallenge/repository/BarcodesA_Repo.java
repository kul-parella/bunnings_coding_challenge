package com.bunnings.codeChallenge.repository;

import com.bunnings.codeChallenge.model.BarcodesA;
import com.bunnings.codeChallenge.model.BarcodesAId;
import com.bunnings.codeChallenge.model.CatalogB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Created by Kuladeep Parella on 05/07/2021
 */
@Repository
public interface BarcodesA_Repo extends JpaRepository<BarcodesA, BarcodesAId> {


}
