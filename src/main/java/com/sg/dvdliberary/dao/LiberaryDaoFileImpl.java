/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.dao;

import com.sg.dvdliberary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Eddie
 */
public class LiberaryDaoFileImpl implements LiberaryDao {

    public static final String DVDLIBERARY_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String dvdTitle, DVD dvd)
            throws LiberaryDaoException {
        loadLiberary();
        DVD newDVD = dvds.put(dvdTitle, dvd);
        writeLiberary();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String movieTitle)
            throws LiberaryDaoException {
        loadLiberary();
        DVD dvdRemoved = dvds.remove(movieTitle);
        writeLiberary();
        return dvdRemoved;
    }

    @Override
    public List<DVD> getAllDVDS()
            throws LiberaryDaoException {
        loadLiberary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVDInfo(String movieTitle)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentDVD = dvds.get(movieTitle);
        return currentDVD;
    }

    @Override
    public List<String> getMoviesByKeyword(String keyword)
            throws LiberaryDaoException {
        loadLiberary();
        Set<String> movieTitles = dvds.keySet();
        ArrayList<String> titles = new ArrayList<>();

        for (String movie : movieTitles) {
            if (movie.contains(keyword)) {
                titles.add(movie);
            }
        }
        return titles;
    }

    @Override
    public DVD editDVDReleaseDate(String movieTitle, LocalDate newReleaseDate)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        currentMovie.setReleaseDate(newReleaseDate);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD editDVDMaap(String movieTitle, String newMaap)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        currentMovie.setMpaaRating(newMaap);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD editDVDDirector(String movieTitle, String newDirecter)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);

        currentMovie.setDirector(newDirecter);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD editDVDStudio(String movieTitle, String newStudio)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        currentMovie.setStudio(newStudio);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD editDVDUserComments(String movieTitle, String newUserComments)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        currentMovie.setUserNotes(newUserComments);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD editDVDTitle(String movieTitle, String newMovieTitle)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        dvds.remove(movieTitle);
        currentMovie.setTitle(newMovieTitle);
        dvds.put(newMovieTitle, currentMovie);
        writeLiberary();
        return currentMovie;
    }

    @Override
    public DVD nullChecker(String movieTitle)
            throws LiberaryDaoException {
        loadLiberary();
        DVD currentMovie = dvds.get(movieTitle);
        return currentMovie;

    }

    private void loadLiberary() throws LiberaryDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVDLIBERARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new LiberaryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setReleaseDate(LocalDate.parse(currentTokens[1], DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirector(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setUserNotes(currentTokens[5]);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();

    }

    public void writeLiberary() throws LiberaryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVDLIBERARY_FILE));
        } catch (IOException e) {
            throw new LiberaryDaoException(
                    "Could not save student data.", e);
        }

        List<DVD> dvdList = this.getAllDVDS();
        for (DVD currentDVD : dvdList) {

            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMpaaRating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserNotes());

            out.flush();
        }
        out.close();

    }
    
    // The following methods are for the Search Feature
    // being implemented in version 2.

    @Override
    public List<DVD> findAllMoviewByReleaseDate(String releaseDate) throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> findMoviesByRating(String rating) throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> findAllMoviesByDirector(String Director) throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> findAllMoviesByStudio(String studio) throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findAvgAgeOfCollection() throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD findNewestMovieInCollection() throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD findOldestMovieInCollection() throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float findAvgLengthOfComment() throws LiberaryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
