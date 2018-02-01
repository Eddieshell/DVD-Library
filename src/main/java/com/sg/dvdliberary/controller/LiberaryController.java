/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.controller;

import com.sg.dvdliberary.dao.LiberaryDao;
import com.sg.dvdliberary.dao.LiberaryDaoException;

import com.sg.dvdliberary.dao.LiberaryDaoFileImpl;
import com.sg.dvdliberary.dto.DVD;
import com.sg.dvdliberary.ui.LiberaryView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

/**
 *
 * @author Eddie
 */
public class LiberaryController {

    //LiberaryView view = new LiberaryView();
    //LiberaryDao dao = new LiberaryDaoFileImpl();
    LiberaryView view;
    LiberaryDao dao;

    public LiberaryController(LiberaryDao dao, LiberaryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {

        boolean keepRunning = true;
        int menuSelect;
        try {
            while (keepRunning) {

                menuSelect = getMenuSelection();

                switch (menuSelect) {
                    case 1:
                        createDVD();
                        break;

                    case 2:
                        removeDVDTitle();
                        break;

                    case 3:
                        makeEdits();
                        break;

                    case 4:
                        getAllDVDs();
                        break;

                    case 5:
                        getDVDInfo();
                        break;

                    case 6:
                        searchByKeyword();
                        break;

                    case 7:
                        keepRunning = false;
                        break;

                    default:
                        unknownCommand();

                }

            }

            exitMessage();
        } catch (LiberaryDaoException e) {
            view.displayErrorMessage(e.getMessage());

        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws LiberaryDaoException {
        view.displayCreateDVD();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateDVDSuccess();
    }

    private void getAllDVDs() throws LiberaryDaoException {
        view.displayDisplayGetAll();
        List<DVD> dvdList = dao.getAllDVDS();
        view.displayDVDList(dvdList);
    }

    private void getDVDInfo() throws LiberaryDaoException {
        view.displayDisplayDVDInfoBanner();
        String selectedDVD = view.getDVDInfoTitle();
        DVD currentDVD = dao.getDVDInfo(selectedDVD);
        view.displayDVDInfo(currentDVD);
    }

    private void removeDVDTitle() throws LiberaryDaoException {
        view.displayGetRemovedTitleBanner();
        String currentDVD = view.getRemovedTitle();
        DVD nullCheck = dao.removeDVD(currentDVD);
        if (nullCheck != null) {
            view.displayRemoveTitleSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void searchByKeyword() throws LiberaryDaoException {
        view.displayKeywordSearchBanner();
        String searchPhase = view.getSearchKeyword();
        List<String> results = dao.getMoviesByKeyword(searchPhase);
        view.displaySearchKeyword(results);

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    // The following code is for the Edit Methods
    private void makeEdits() {
        boolean runMeathod = true;
        int editChoice;

        try {
            while (runMeathod) {
                
                editChoice = getEditChoice();
                

                
                    switch (editChoice) {
                        case 1:
                            editTitle();
                            break;

                        case 2:
                            editReleaseDate();
                            break;

                        case 3:
                            editRating();
                            break;

                        case 4:
                            editDirecter();
                            break;

                        case 5:
                            editStudio();
                            break;

                        case 6:
                            edituserComment();
                            break;

                        case 7:
                            runMeathod = false;
                            break;

                        default:
                            unknownCommand();
                    }

                

            }
            exitEditMenu();
        } catch (LiberaryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getEditChoice() {
        return view.getUserEditChoice();
    }

    private void editTitle() throws LiberaryDaoException {
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String newTitle = view.editTitle();
        dao.editDVDTitle(titleToEdit, newTitle);
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void editReleaseDate() throws LiberaryDaoException {
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String date = view.editReleaseDate();
        dao.editDVDReleaseDate(titleToEdit, LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void editRating() throws LiberaryDaoException {
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String rating = view.editMaap();
        dao.editDVDMaap(titleToEdit, rating);
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void editDirecter() throws LiberaryDaoException {
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String directer = view.editDirecter();
        dao.editDVDDirector(titleToEdit, directer);
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void editStudio() throws LiberaryDaoException {
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String studio = view.editStudio();
        dao.editDVDStudio(titleToEdit, studio);
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }
    }

    private void edituserComment() throws LiberaryDaoException {
        
        String titleToEdit = view.getEditTitle();
        boolean movieExists = checkForNull(titleToEdit);
        if(movieExists){
        String comment = view.editUserComment();
        dao.editDVDUserComments(titleToEdit, comment);
        view.editSuccess();
        } else {
            view.displayTitleNotFound();
        }

    }

    private void exitEditMenu() {
        view.exitEditMenuMessage();
    }

    private boolean checkForNull(String movieTitle)
            throws LiberaryDaoException {
        DVD currentMovie = dao.nullChecker(movieTitle);
        if (currentMovie != null) {
            return true;
        } else {
            return false;

        }

    }

}
