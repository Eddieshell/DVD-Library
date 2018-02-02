/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdliberary.dao;

import com.sg.dvdliberary.dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Eddie
 */
public interface LiberaryDao {
    
    /**
    *Allows user to add a DVD into the Liberary 
    * by title. If title is already in the liberary 
    * returns the DVD object, otherwise returns null.
     * @param dvdTitle String dvdTitle by which the DVD is to be associated
     * @param dvd DVD dvd to be added to the liberary.
     * @return the DVD object previously assoc with the title     
    * if it exists, null otherwise
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
    */
    
    DVD addDVD(String dvdTitle, DVD dvd)
    throws LiberaryDaoException;
    
    /**
     *Removes a DVD from the Liberary by title name
     * Returns the DVD object that is being removed
     * or null if title does not exist.
     * 
     * @param  movieTitle title to be removed
     * @return DVD object that was returned or null
     * if movie does not exist
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD removeDVD(String movieTitle)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newReleaseDate
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDReleaseDate(String movieTitle, LocalDate newReleaseDate)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newMaap
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDMaap(String movieTitle, String newMaap)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newDirecter
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDDirector(String movieTitle, String newDirecter)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newStudio
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDStudio(String movieTitle, String newStudio)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newUserComments
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDUserComments(String movieTitle, String newUserComments)
    throws LiberaryDaoException;
    
    /**
     Allows user to update the DVD in the Liberary - search is by 
     * title.Returns the DVD object, or null it title is not found.
     * @param movieTitle to be edited
     * @param newMovieTitle
     * @return DVD object previously associated with title, or 
     * null if not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    
    DVD editDVDTitle(String movieTitle, String newMovieTitle)
    throws LiberaryDaoException;
    
    
    
    /**
    *Returns an String Array of all DVD's in Liberary
    *@return String list of all DVD titles
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
    */
    
    List<DVD> getAllDVDS()
    throws LiberaryDaoException;
    
    /**
     *Returns the DVD object associated with the title
     * Returns null if none found.
     * @param movieTitle in which DVD has been associated
     * @return returns DVD object or null if movieTitle is
     * not found
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
     */
    DVD getDVDInfo(String movieTitle)
    throws LiberaryDaoException;
    
    /**
 *Returns a list of all movies in the library that match the keyword.
 * returns null if movie is not found.
 * 
     * @param keyword in which user wants to search for available movies
     * @return String list of all DVD titles
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
 */

List<String> getMoviesByKeyword(String keyword)
throws LiberaryDaoException;

public DVD nullChecker(String movieTitle) 
    throws LiberaryDaoException;
    
    
    


/*





Find the average age of the movies in the collection
Find the newest movie in your collection
Find the oldest movie in your collection
Find the average number of notes associated with movies in your collection
*/

/**
    *Returns an String Array of all DVD's in Liberary
    *@return String list of all DVD titles
     * @throws com.sg.dvdliberary.dao.LiberaryDaoException
    */
    
    List<DVD> findAllMoviewByReleaseDate(String releaseDate)
    throws LiberaryDaoException;
    
    List<DVD> findMoviesByRating(String rating)
    throws LiberaryDaoException;
    
    
    //When searching by director, the movies should be sorted into separate data structures by MPAA rating.
    List<DVD> findAllMoviesByDirector(String Director)
            throws LiberaryDaoException;
    
    List<DVD> findAllMoviesByStudio(String studio)
            throws LiberaryDaoException;
    
    int findAvgAgeOfCollection()
            throws LiberaryDaoException;
    
    DVD findNewestMovieInCollection()
    
            throws LiberaryDaoException;
    
    DVD findOldestMovieInCollection()
            throws LiberaryDaoException;
    
    float findAvgLengthOfComment()
            throws LiberaryDaoException;
}
