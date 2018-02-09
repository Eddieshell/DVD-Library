/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Eddie
 */
public class auditDaoImpl implements auditDao{
    
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws LiberaryDaoException {
        PrintWriter out;
        
        try{
        out = new PrintWriter(new FileWriter(AUDIT_FILE,true));
        }catch(IOException ex) {
            throw new LiberaryDaoException("Could not persist audit information.");
        }
        
        LocalDateTime timeStamp = LocalDateTime.now();
        out.println(timeStamp+":"+entry);
        out.flush();
        
       
    }
    
    
}
