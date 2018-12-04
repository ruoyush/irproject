/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indeed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Search.Tool;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;


/**
 *
 * @author Ruoyu
 */
public class SearchController extends HttpServlet {
    private static final long serialVersionUID =1;

    // connect the database
    MongoClient mongo = new MongoClient( "localhost" , 27017 );
    MongoDatabase database = mongo.getDatabase("indeed_broker");
    MongoCollection<Document> collection = database.getCollection("indeed_test_copy");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters and check if parameters are null
        String query ="";
        String location = "";
        String skills = "";
        int page = 1;

//        response.setContentType("application/json");
//        response.setHeader("Cache-Control", "no-cache");


        if(!request.getParameter("postion").isEmpty()){
            location = request.getParameter("postion");
        }

//        if(!request.getParameter("skills").isEmpty()){
//            skills = request.getParameter("skills");
//        }

        if(!request.getParameter("query").isEmpty()){
            query = request.getParameter("query");
            query = query +" "+ skills;
        }

        if(!request.getParameter("page").isEmpty()){
            page = Integer.parseInt(request.getParameter("page"));
        }

        // parse and split the location parameter
        String[] location2 = location.toLowerCase().split("\\s*(=>|,|\\s)\\s*");
        String city = location2[0];
        String state = location2[1];

        // store the result from the backend search engine
        ArrayList<String> middle = new ArrayList<String>();

        // store the result of specific page
        ArrayList<String> result = new ArrayList<String>();

        Map<String,Integer> hs = new HashMap<>();

//        Tool.PseudoRFRetrievalSearch("Graph Designer");

        // get the document id of the result from the backend search engine
        try {
//            middle = getResult(query);
            middle = Tool.PseudoRFRetrievalSearch(query);
//          hs = Tool.DirectSearch("C# Designer");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get and store the all the result
        ArrayList<String> al = new ArrayList<>();

        try {

            for (String element: middle) {
                Document myDoc = collection.find(Filters.eq("docid", element.toString())).first();
                String[] tempLocation = myDoc.getString("location").toLowerCase().split("\\s*(=>|,|\\s)\\s*");
                if(state.equals(tempLocation[1]) && city.equals(tempLocation[0])){
                    al.add(myDoc.toJson());

                }
            }
        }catch (NullPointerException e){
            request.setAttribute("query",query);
            request.setAttribute("size", 0);
            request.setAttribute("location", location);
            request.setAttribute("page", 0 );
            request.setAttribute("totalPage", 0 );
            request.setAttribute("documents", "{'msg': 'No Result. Please try differnet query'}" );
            RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request,response);
        }


        // seperate page

        int actualPage = (al.size()-1)/10+1;


        // if the page parameter in the query larger than available page
        if(actualPage < page){
            page = actualPage;
        }

        int startPage = (page-1)*10;
        int endPage = (page-1)*10+9;

        if(endPage < al.size()){
            for(int i =startPage;i<=endPage;i++) {
                result.add(al.get(i));
            }
        }else{
            for(int i =startPage;i<=al.size()-1;i++) {
                result.add(al.get(i));
            }
        }


        String json = new Gson().toJson(result);

        // set the result to request and send response
        request.setAttribute("query",query);
        request.setAttribute("size", al.size());
        request.setAttribute("location", location);
        request.setAttribute("page", page );
        request.setAttribute("totalPage", actualPage );
        request.setAttribute("documents", result );

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request,response);

    }


    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

    }

    // dummy function
    private ArrayList<String> getResult(String param)
            throws Exception {
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0;i<2000;i++){
            temp.add(Integer.toString(i));
        }

//        temp.add("15555555");
        return(temp);

    }


}