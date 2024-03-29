/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croer.search.repositories;

import com.croer.search.entities.Alineacion;
import com.croer.search.entities.AlineacionPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elialva
 */
public interface AlineacionRepository extends JpaRepository<Alineacion, AlineacionPK> {

    List<Alineacion> findByOrtograma(String ortograma);

}
