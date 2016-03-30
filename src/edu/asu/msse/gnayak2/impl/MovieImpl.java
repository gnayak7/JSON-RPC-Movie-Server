package edu.asu.msse.gnayak2.impl;
import org.json.JSONException;
import org.json.JSONObject;

import edu.asu.msse.gnayak2.rpc.*;

public class MovieImpl implements Movie {

	private String title;
    private String year;
    private String rated;
    private String released;
    private String runTime;
    private String genre;
    private String actors;
    private String plot;

    public MovieImpl (String jsonString) {
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            this.title = jsonObj.getString("Title");
            System.out.println("No Error in converting Title");
            this.year = jsonObj.getString("Year");
            System.out.println("No Error in converting and storing Year");
            this.rated = jsonObj.getString("Rated");
            System.out.println("No Error in converting and storing the Rated");
            this.released = jsonObj.getString("Released");
            System.out.println("No Error in converting and storing the Released");
            this.actors = jsonObj.getString("Actors");
            System.out.println("No Error in converting and storing the json Actors");
            this.plot = jsonObj.getString("Plot");
            System.out.println("No Error in converting and storing the json Plot");
            this.genre = jsonObj.getString("Genre");
            System.out.println("No Error in converting and storing the json Genre");
            this.runTime = jsonObj.getString("Runtime");
            System.out.println("No Error in converting and storing the json Runtime");
            
        } catch (JSONException e) {
            System.out.println("-------------------Error in converting and storing the json----------------------");
        }
    }

    public MovieImpl (String title, String year, String rated, String released, String runtime, String genre, String actors, String plot) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runTime = runtime;
        this.genre = genre;
        this.actors = actors;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getGenre() {
        return genre;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String toJsonString() {
        String ret = "";
        try{
            JSONObject jo = new JSONObject();
            jo.put("Title",this.title);
            jo.put("Year",this.year);
            jo.put("Rated",this.rated);
            jo.put("Released",this.released);
            jo.put("Runtime",this.runTime);
            jo.put("Actors",this.actors);
            jo.put("Genre",this.genre);
            jo.put("Plot",this.plot);
            ret = jo.toString();
        }catch (Exception ex){
//            android.util.Log.w(this.getClass().getSimpleName(),
//                    "error converting to/from json");
        }
        return ret;
    }
    
    public JSONObject toJson(){
        JSONObject jo = new JSONObject();
        
        try{
           jo.put("Title", this.title);
           jo.put("Year",this.year);
           jo.put("Rated",this.rated);
           jo.put("Released",this.released);
           jo.put("Runtime",this.runTime);
           jo.put("Actors",this.actors);
           jo.put("Genre",this.genre);
           jo.put("Plot",this.plot);
        }catch (Exception ex){
           System.out.println(this.getClass().getSimpleName()+
                              ": error converting to json");
        }
        return jo;
     }

}
