package com.croer.javaaccess;

import com.croer.search.entities.Diccionario;
import com.croer.search.entities.ItemOrtograma;
import com.croer.search.entities.Itembusq;
import com.croer.search.entities.Ortograma;
import com.croer.search.repositories.ItemOrtogramaRepository;
import com.croer.search.repositories.ItembusqRepository;
import com.croer.search.repositories.OrtogramaRepository;
import com.croer.services.ItembusqManagement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\IBM_ADMIN\\Documents\\@Projects_Eli\\201309 Finder&Getter\\_NBP\\digitalcatalog\\JavaAccess\\src\\main\\java\\springXMLConfig.xml");
        DataSource bean = context.getBean("dataSourceSearch", DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println("cone " + connection.getCatalog() + " " + connection.getClientInfo());
        ItembusqRepository bean1 = context.getBean("itembusqRepository", ItembusqRepository.class);
        List<Itembusq> findAll1 = bean1.findAll();
        for (Itembusq itembusq : findAll1) {
            System.out.println("Context! " + itembusq.getContexto());
        }
        OrtogramaRepository bean2 = context.getBean("ortogramaRepository", OrtogramaRepository.class);
        List<Ortograma> findAll2 = bean2.findAll();
        for (Ortograma ortograma : findAll2) {
            System.out.println("Ortis! " + ortograma.getOrtograma());
        }
        Pageable pageable = new PageRequest(2, 3, Direction.ASC, "ortograma");
        Page<Ortograma> findAll = bean2.findAll(pageable);
        for (Ortograma ortograma : findAll) {
            System.out.println("Orip " + ortograma.getOrtograma());
        }
        
        List<Order> l =  new ArrayList();
        l.add(new Sort.Order(Direction.ASC, "ortograma"));
        l.add(new Sort.Order(Direction.DESC, "numegrama"));

        Sort sort = new Sort(l);
        List<Ortograma> findAll3 = bean2.findAll(sort);
        for (Ortograma ortograma : findAll3) {
            System.out.println("OPi2 " + ortograma.getNumegrama());
        }
        
        List l1 = new ArrayList(Arrays.asList("one","two","three"));
        List l2 = new ArrayList(Arrays.asList("two","three","four"));
//        l1.removeAll(l2);
//        for (Object object : l1) {
//            System.out.println("Right " + object);
//        }
//         l1.retainAll(l2);
//        for (Object object : l1) {
//            System.out.println("Join " + object);
//        }
        
        l2.removeAll(l1);
        for (Object object : l2) {
            System.out.println("Left " + object);
        }
        
        Collections.copy(l1, new ArrayList());
        ItembusqManagement bean3 = context.getBean("itembusqManagement", ItembusqManagement.class);
        Itembusq ib = new Itembusq("18", "Producto");
        ib.setContexto("perón manila");
        ib.setPrioridad(3);
        List<ItemOrtograma> lio = new ArrayList<>();
//        lio.add(new ItemOrtograma("18", "Producto", "perón"));
        lio.add(new ItemOrtograma("18", "Producto", "manila"));
        lio.add(new ItemOrtograma("18", "Producto", "sandía"));
        ib.setItemOrtogramaList(lio);
        ItemOrtogramaRepository bean4 = context.getBean("itemOrtogramaRepository", ItemOrtogramaRepository.class);
        List<ItemOrtograma> findByOrtogramaAndType = bean4.findByOrtogramaAndType("sandía", "Producto");
        for (ItemOrtograma itemOrtograma : findByOrtogramaAndType) {
            System.out.println("itemOrtograma " + itemOrtograma.getOrtograma1() + ":" + itemOrtograma.getItemOrtogramaPK());
        }
        
        Diccionario d =  new Diccionario("test");
        List lor = new ArrayList();
        lor.add("mana");
        lor.add("nuez");
        bean3.saveDic(d);
        
    }
}
