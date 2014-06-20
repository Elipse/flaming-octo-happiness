/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.croer.javaaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author elialva
 */
public class Structure {

    private final List<String> keyList;
    private final List<String> contextList;
    
    public Structure(Object object) {
        Properties properties = new Properties();
        try {
            String fileProps = System.getProperty("user.dir") + "\\target\\classes\\entityStruc.properties";
            FileInputStream input = new FileInputStream(fileProps);
            properties.load(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Structure.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Structure.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String type = object.getClass().getName();
        String key = properties.getProperty(type + ".key");
        String context = properties.getProperty(type + ".context");
        
        if (key == null || context == null) {
            throw new IllegalArgumentException("Properties missing for type: " + type + " key " + key + " context " + context);
        }
        
        keyList = Arrays.asList(StringUtils.split(key, "|"));
        contextList = Arrays.asList(StringUtils.split(context, "|"));
    }
    
    public List<String> getKeyProperties() {
        return keyList;
    }
    
    public List<String> getConxtextProperties() {
        return contextList;
    }
    
    public static void main(String[] args) {
        Structure structure = new Structure(new Goderbo());
        List<String> keyProperties = structure.getKeyProperties();
        List<String> conxtextProperties = structure.getConxtextProperties();
        System.out.println("Yupi " + keyProperties + " - " + conxtextProperties);
        
    }
}
