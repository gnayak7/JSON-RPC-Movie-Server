package edu.asu.msse.gnayak2.rpc;

/**
 * Copyright 2016 Gowtham Ganesh Nayak,
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Purpose:The purpose of this application is to demonstrate expandable list view adapter. Data is stored ina
 * a json file in raw folder. Additionally the applicaiton demonstrates use of picker.
 * <p>
 * SER598 Mobile Applications
 * see http://pooh.poly.asu.edu/Mobile
 *
 * @author Gowtham Ganesh Nayak mailto:gnayak2@asu.edu
 * @version February 15 2016
 */

// Library which holds all the movie information.
public interface MovieLibrary {
    public int getGenreCount(); 
    public int getMoviesCount(String genre); 
    public String getGenreAt(int groupPosition); 
    public String getMovieNameAt(int groupPosition, int position); 
    public Movie getMovie(String movieName);
    public void updateMovie(Movie movie) ;
    public void addMovie(Movie movie) ;
    public void updateModel(Movie movie);
    public boolean deleteMovie(Movie movie);
    public String getMovieGenre(String movieName); 
    public String getMovieReleasedDate(String movieName); 
}
