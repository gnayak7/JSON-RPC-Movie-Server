package edu.asu.msse.gnayak2.impl;

import edu.asu.msse.gnayak2.main.JSONFileReader;
import edu.asu.msse.gnayak2.rpc.Movie;
import edu.asu.msse.gnayak2.rpc.MovieLibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MovieLibraryImpl implements MovieLibrary {
	private LinkedHashMap<String, ArrayList<String>> model; // <engre, title of all the movies belonging to this genre>
	private LinkedHashMap<String, MovieImpl> movies;

	public MovieLibraryImpl() {
		reset();
	}

	public void reset() {
		JSONFileReader jsonFileReader = new JSONFileReader();
		JSONArray jsonArray = jsonFileReader.getJSONArray();
		int length = jsonArray.size();
		model = new LinkedHashMap<String, ArrayList<String>>();
		movies = new LinkedHashMap<String, MovieImpl>();
		try {
			for (int i = 0; i < length; i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				MovieImpl movie = new MovieImpl(jsonObject.toString());
				if (movie != null) {
					this.movies.put(movie.getTitle(), movie);
				}
				if (this.model.containsKey(movie.getGenre())) {
					(this.model.get(movie.getGenre())).add(movie.getTitle());
				} else {
					ArrayList<String> s = new ArrayList<String>();
					s.add(movie.getTitle());
					this.model.put(movie.getGenre(), s);
				}
			}
		} catch (Exception e) {
			System.out.println("Some Error");
		}
	}

	public int getGenreCount() {
		return model.size();
	}

	public int getMoviesCount(String genre) {
		return (model.get(genre)).size();
	}

	public String getGenreAt(int groupPosition) {
		String[] keys = model.keySet().toArray(new String[]{});
		return keys[groupPosition];
	}

	public String getMovieNameAt(int groupPosition, int position) {
		String genre = getGenreAt(groupPosition);
		ArrayList<String> moviesList = model.get(genre);
		return moviesList.get(position);
	}

	public MovieImpl getMovie(String movieName) {
		return movies.get(movieName);
	}

	public void updateMovie(Movie movie) {
		MovieImpl movieImpl = (MovieImpl) movie;
		movies.put(movieImpl.getTitle(), movieImpl);
	}

	public void addMovie(Movie movie) {
		MovieImpl movieImpl = (MovieImpl) movie;
		updateModel(movieImpl);
		movies.put(movieImpl.getTitle(), movieImpl);
	}

	public void updateModel(Movie movie) {
		MovieImpl movieImpl = (MovieImpl) movie;
		if (model.containsKey(movieImpl.getGenre())) {
			model.get(movieImpl.getGenre()).add(movieImpl.getTitle());
		} else {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(movieImpl.getTitle());
			model.put(movieImpl.getGenre(), arrayList);
		}
	}

	public boolean deleteMovie(Movie movie) {
		MovieImpl moiveImpl = (MovieImpl) movie;
		String genre = moiveImpl.getGenre();
		boolean deleted = false;
		if (model.containsKey(genre)) {
			ArrayList<String> arrayList = model.get(moiveImpl.getGenre());
			arrayList.remove(moiveImpl.getTitle());
			deleted = true;
			if (arrayList.size() == 0) {
				model.remove(genre);
			}
		}
		movies.remove(movie.getTitle());
		return deleted;
	}

	public String getMovieGenre(String movieName) {
		return movies.get(movieName).getGenre();
	}

	public String getMovieReleasedDate(String movieName) {
		return movies.get(movieName).getReleased();
	}

	public boolean remove(String movieName) {
		return deleteMovie(movies.get(movieName));
	}

	public boolean add(Movie movie) {
		addMovie(movie);
		return true;
	}

	public void resetFromJsonFile() {
		reset();
	}

	public MovieImpl get(String sName) {
		return movies.get(sName);
	}

	public String[] getNames() {
		String[] keys = movies.keySet().toArray(new String[]{});
		return keys;
	}

	public boolean saveToJsonFile() {
		// TODO Auto-generated method stub
		return false;
	}

	public LinkedHashMap<String, ArrayList<String>> getModelInformation() {
		return this.model;
	}
}
