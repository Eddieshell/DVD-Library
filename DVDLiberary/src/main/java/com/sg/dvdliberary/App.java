/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary;

import com.sg.dvdliberary.controller.LiberaryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Eddie
 */
public class App {

    public static void main(String[] args) {
        //UserIO myIo = new UserIOConsoleImpl();
        //LiberaryView myView = new LiberaryView(myIo);
        //LiberaryDao myDao = new LiberaryDaoFileImpl();
//        


        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        LiberaryController controller = ctx.getBean("controller", LiberaryController.class);
        controller.run();
    }

}
