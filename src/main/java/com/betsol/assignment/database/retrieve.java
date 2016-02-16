package com.betsol.assignment.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Path("retrieve")
public class retrieve {
	 @POST
	   // @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	    public Response getIt( ) {
		 
	   	JSONObject jsonObject = null;
	   	String  user_name1= null;
	   	String 	password= null ;
	    String 	phone_number= null ;
	    	String  address= null ;
	    	String  first_name= null ;
	    	String   last_name= null ;
			
	    
	
Connection dbcon;
			 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			 String DB_URL = "jdbc:mysql://localhost:3306/user";

			   //  Database credentials
			   
			   String USER = "root";
			   String PASS = "";
	   Connection conn = null;
	   Statement stmt = null ;
	  
	      //STEP 2: Register JDBC driver
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println("Connected database successfully...");
	    
	      String sql = "SELECT * FROM user_info WHERE user_name='vibha'";
	      ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //STEP 5: Extract data from result set
	      try {
			while(rs.next()){
			     //Retrieve by column name
			       user_name1= rs.getString("user_name");
			   		password= rs.getString("password") ;
			     	phone_number= rs.getString("password") ;
			    	 address= rs.getString("address") ;
			    	  first_name= rs.getString("first_name") ;
			    	   last_name= rs.getString("last_name") ;
			     //Display values
			//     System.out.print("name: " + name);
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      rs.close();
	  
	      System.out.println("Inserted records into the table...");
	      return Response.ok(jsonObject.toString()).build();
	   }
	 }


