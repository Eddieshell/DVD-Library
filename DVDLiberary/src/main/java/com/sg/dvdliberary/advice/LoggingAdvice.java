/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.advice;

import com.sg.dvdliberary.dao.LiberaryDaoException;
import com.sg.dvdliberary.dao.auditDao;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Eddie
 */
public class LoggingAdvice {
    
    auditDao auditDao;
    
    public LoggingAdvice(auditDao myAuditDao){
        this.auditDao = myAuditDao;
    }
    
    public void createAuditEntry(JoinPoint jp){
        Object[] arg = jp.getArgs();
        
        String auditEntry = jp.getSignature().getName() + ": ";
        
        try {
        for(Object currentArg : arg) {
            auditEntry += currentArg;
            auditDao.writeAuditEntry(auditEntry);
        }
        }catch (LiberaryDaoException ex) {
            
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");    
                
        }
    }
    
}
