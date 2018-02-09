
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.ui;

import com.sg.dvdliberary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Eddie
 */
public class LiberaryView {

    //UserIO io = new UserIOConsoleImpl();
    UserIO io;
    
    public LiberaryView(UserIO io) {
    this.io = io;
}

    public int printMenuAndGetSelection() {

        io.print("MAIN MENU");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List All DVD's");
        io.print("5. Information about DVD");
        io.print("6. Search for DVD by keyword.");
        io.print("7. EXIT");

        return io.readInt("Please make a selection from the options above.", 1, 7);

    }

    public DVD getNewDVDInfo() {
        String movieTitle = io.readString("Enter the movie's title.");
        String releaseDate = io.readString("Enter the movie's release date.");
        String mpaaRating = io.readString("Enter the movie's rating.");
        String director = io.readString("Enter the movie's Director.");
        String studio = io.readString("Enter the movie's production studio.");
        String userNotes = io.readString("Enter comments.");
        DVD currentDVD = new DVD(movieTitle);
        currentDVD.setReleaseDate(LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        return currentDVD;

    }

    public void displayCreateDVD() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateDVDSuccess() {
        io.readString("DVD successfully created. Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentMovie : dvdList) {
            io.print(currentMovie.getTitle());

        }
        io.readString("Hit enter to continue.");
    }

    public void displayDisplayGetAll() {
        io.print("=== Display All DVD's  ===");
    }

    public String getDVDInfoTitle() {
        String movieSearchedFor = io.readString("Enter the movie title "
                + "you want information on.");
        return movieSearchedFor;
    }

    public void displayDVDInfo(DVD currentDVD) {
        if (currentDVD != null) {
            io.print("Here is the information on the movie " + currentDVD.getTitle());
            io.print("Movie Title: " + currentDVD.getTitle());
            io.print("Movie Release Date: " + currentDVD.getReleaseDate());
            io.print("Movie MPAA Rating: " + currentDVD.getMpaaRating());
            io.print("Movie Director: " + currentDVD.getDirector());
            io.print("Movie Production Studio: " + currentDVD.getStudio());
            io.print("Movie Comments: " + currentDVD.getUserNotes());

        } else {
            io.print("No Such Movie");
        }
        io.readString("Please press enter to continue.");
    }

    public void displayDisplayDVDInfoBanner() {
        io.print("=== Movie Information ===");
    }

    public String getRemovedTitle() {
        String selectedTitle = io.readString("What DVD title would you like removed?");
        return selectedTitle;
    }

    public void displayGetRemovedTitleBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveTitleSuccess() {
        io.print("Title has been successfully removed.");
        io.readString("Please press enter to continue.");
    }

    public String getSearchKeyword() {
        String searchKeyword = io.readString("Enter search keywords.");
        return searchKeyword;
    }

    public void displayKeywordSearchBanner() {
        io.print("=== Search By Keyword ===");
    }

    public void displaySearchKeyword(List<String> results) {
        io.print("=== Search Results");
        for (String result : results) {
            io.print(result.toString());
        }
        io.readString("Please press enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayTitleNotFound(){
        io.print("Can not find requested title.");
        io.readString("Please press enter to continue");
                
    }

    // The following cod is for the Edit Menu
    // and the Edit methods.
    public int getUserEditChoice() {
        int editField;
        io.print("=== EDIT MENU ===");
        io.print("1. Movie Title");
        io.print("2. Movie Release Date");
        io.print("3. MAAP Rating");
        io.print("4. Movie's Directer");
        io.print("5. Movie's Production Studio");
        io.print("6. Comments");
        io.print("7. EXIT");
        editField = io.readInt("Choose a field to edit from Menu", 1, 7);
        return editField;
    }

    public String getEditTitle() {
        String titleToEdit = io.readString("What DVD would you like to edit?");
        return titleToEdit;
    }

    public String editTitle() {
        String newTitle = io.readString("Enter new Title.");
        return newTitle;
    }

    public String editReleaseDate() {
        String newReleaseDate = io.readString("Enter new Release Date.");
        return newReleaseDate;
    }

    public String editMaap() {
        String newMaap = io.readString("Enter new Rating.");
        return newMaap;
    }

    public String editDirecter() {
        String newDirecter = io.readString("Enter new Directer.");
        return newDirecter;
    }

    public String editStudio() {
        String newStudio = io.readString("Enter new Studio.");
        return newStudio;
    }

    public String editUserComment() {
        String newUserComment = io.readString("Enter new Comment.");
        return newUserComment;
    }

    public void editSuccess() {

        io.print("DVD has been edited successfully.");
    }
    
    public void exitEditMenuMessage() {
        io.readString("Leaving the Editing Menu \nPleae"
                + " press ENTER to return to MAIN MENU");
    }
    
    public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}

}
