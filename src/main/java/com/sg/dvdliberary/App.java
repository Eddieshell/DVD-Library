/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary;

import com.sg.dvdliberary.controller.LiberaryController;
import com.sg.dvdliberary.dao.LiberaryDao;
import com.sg.dvdliberary.dao.LiberaryDaoFileImpl;
import com.sg.dvdliberary.ui.LiberaryView;
import com.sg.dvdliberary.ui.UserIO;
import com.sg.dvdliberary.ui.UserIOConsoleImpl;

/**
 *
 * @author Eddie
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        LiberaryView myView = new LiberaryView(myIo);
        LiberaryDao myDao = new LiberaryDaoFileImpl();
        LiberaryController controller = 
            new LiberaryController(myDao, myView);        
        controller.run();
    }

}
