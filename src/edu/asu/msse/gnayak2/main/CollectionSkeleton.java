package edu.asu.msse.gnayak2.main;

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;

import edu.asu.msse.gnayak2.impl.MovieImpl;
import edu.asu.msse.gnayak2.impl.MovieLibraryImpl;
import edu.asu.msse.gnayak2.rpc.Movie;


/**
 * Copyright (c) 2016 Tim Lindquist,
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Purpose: This class is part of an example developed for the mobile
 * computing class at ASU Poly. The application provides a jsonrpc student service.
 *
 * @author Tim Lindquist
 * @version 12/18/2016
 **/

public class CollectionSkeleton extends Object {

   MovieLibraryImpl mLib;

   public CollectionSkeleton (MovieLibraryImpl mLib){
      this.mLib = mLib;
   }

   public String callMethod(String request){
      JSONObject result = new JSONObject();
      try{
         JSONObject theCall = new JSONObject(request);
         System.out.println(request);
         String method = theCall.getString("method");
         int id = theCall.getInt("id");
         JSONArray params = null;
         if(!theCall.isNull("params")){
            params = theCall.getJSONArray("params");
            System.out.println(params);
         }
         result.put("id",id);
         result.put("jsonrpc","2.0");
         if(method.equals("resetFromJsonFile")){
            mLib.resetFromJsonFile();
            result.put("result",true);
            System.out.println("resetFromJsonCalled");
         } else if(method.equals("remove")){
            String sName = params.getString(0);
            boolean removed = mLib.remove(sName);
            System.out.println(sName + " deleted");
            result.put("result",removed);
         } else if(method.equals("add")){
        	 MovieImpl movie = new MovieImpl(params.getString(0));
            boolean added = mLib.add(movie);
            result.put("result",added);
         }else if(method.equals("get")){
            String sName = params.getString(0);
            MovieImpl movie = mLib.get(sName);
            result.put("result",movie.toJson());
         }else if(method.equals("getNames")){
            String[] names = mLib.getNames();
            JSONArray resArr = new JSONArray();
            for (int i=0; i<names.length; i++){
               resArr.put(names[i]);
            }
            result.put("result",resArr);
         }else if(method.equals("saveToJsonFile")){
           boolean saved = mLib.saveToJsonFile();
           result.put("result",saved);
        } else if (method.equals("getModelInformation")) {
        	//mLib.resetFromJsonFile();
        	result.put("result", mLib.getModelInformation());
        } else if (method.equals("update")) {
        	String movieJSONString = params.getString(0);
        	Movie mo = new MovieImpl(movieJSONString);
        	mLib.updateMovie(mo);
        } else if(method.equals("deleteAndAdd")) {
        	String oldMovieJSONString = params.getString(0);
        	String editedMovieJSONString = params.getString(1);
        	boolean deletionSuccessful = false;
        	boolean additionSuccessful = false;
        	MovieImpl oldMovie = new MovieImpl(oldMovieJSONString);
        	MovieImpl newMovie = new MovieImpl(editedMovieJSONString);
        	deletionSuccessful = mLib.deleteMovie(oldMovie);
        	additionSuccessful = mLib.add(newMovie);
        	result.put("result", deletionSuccessful & additionSuccessful);
        }
      }catch(Exception ex){
         System.out.println("exception in callMethod: "+ex.getMessage());
      }
      System.out.println("returning: "+result.toString());
      return "HTTP/1.0 200 Data follows\nServer:localhost:8080\nContent-Type:text/plain\nContent-Length:"+(result.toString()).length()+"\n\n"+result.toString();
   }
}


