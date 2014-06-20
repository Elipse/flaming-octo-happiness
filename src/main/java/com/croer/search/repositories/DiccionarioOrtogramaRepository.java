/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.croer.search.repositories;

import com.croer.search.entities.DiccionarioOrtograma;
import com.croer.search.entities.DiccionarioOrtogramaPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elialva
 */
public interface DiccionarioOrtogramaRepository extends JpaRepository<DiccionarioOrtograma, DiccionarioOrtogramaPK>{
    
}
