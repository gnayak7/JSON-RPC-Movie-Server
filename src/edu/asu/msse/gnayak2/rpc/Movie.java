package edu.asu.msse.gnayak2.rpc;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

/**
 * Copyright 2016 Gowtham Ganesh Nayak,
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Purpose:The purpose of this application is to demonstrate expandable list view adapter. Data is stored ina
 * a json file in raw folder. Additionally the applicaiton demonstrates use of picker.
 * <p/>
 * SER598 Mobile Applications
 * see http://pooh.poly.asu.edu/Mobile
 *
 * @author Gowtham Ganesh Nayak mailto:gnayak2@asu.edu
 * @version February 15 2016
 */
/*
This class extracts all the fields from the json string and
 * store in member variables. It is then used to populate the infromation
 * on the screen. Additonally it converts a json string.
 */

public interface Movie{

    public String getTitle();
    public String getYear();
    public String getRated(); 
    public String getReleased();
    public String getRunTime();
    public String getGenre();
    public String getActors();
    public String getPlot();
    public void setTitle(String title);
    public void setYear(String year);
    public void setRated(String rated);
    public void setReleased(String released);
    public void setRunTime(String runTime) ;
    public void setGenre(String genre) ;
    public void setActors(String actors);
    public void setPlot(String plot);
    public String toJsonString();
}