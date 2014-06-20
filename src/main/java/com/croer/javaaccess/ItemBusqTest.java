/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croer.javaaccess;

import com.croer.search.entities.Itembusq;
import com.croer.search.entities.ItembusqPK;
import com.croer.search.entities.Ortograma;
import com.croer.search.repositories.ItembusqRepository;
import com.croer.search.repositories.OrtogramaRepository;
import com.croer.services.ItembusqManagement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author elialva
 */
public class ItemBusqTest {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\IBM_ADMIN\\Documents\\@Projects_Eli\\201309 Finder&Getter\\_NBP\\digitalcatalog\\JavaAccess\\src\\main\\java\\springXMLConfig.xml");
        ItembusqManagement bean3 = context.getBean("itembusqManagement", ItembusqManagement.class);
        OrtogramaRepository ortoRepo = context.getBean("ortogramaRepository", OrtogramaRepository.class);
        ItembusqRepository itemRepo = context.getBean("itembusqRepository", ItembusqRepository.class);

        Ortograma ortoTmp = ortoRepo.findOne("vaca");
        List<Ortograma> ortoList = new ArrayList<>();
        ortoList.add(ortoTmp);
        Itembusq itembusq = itemRepo.findOne(new ItembusqPK("Producto", "99"));
        bean3.borraOrtograma(ortoList, itembusq);
    }
}
