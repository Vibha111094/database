package com.betsol.assignment.database;
import java.io.StringReader;



import java.sql.DriverManager;
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

@Path("myresource")
public class MyResource {
	 @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	 //  @Produces(MediaType.APPLICATION_JSON)
	    public void getIt( String obj) {
		 
	    	JSONObject jsonObject = null;
	    	String  user_name= null;
	    	String 	password= null ;
	    	String 	phone_number= null ;
	    	String  address= null ;
	    	String  first_name= null ;
	    	String   last_name= null ;
			try {
				jsonObject = new JSONObject(obj);
				user_name = jsonObject.getString("user_name");
				password=jsonObject.getString("password");
				phone_number =jsonObject.getString("phone_number");
		    	address =jsonObject.getString("address");
		        first_name =jsonObject.getString("first_name");
		    	last_name =jsonObject.getString("last_name");
	
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				
			}
			
	    
	
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
	     
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //System.out.println(name);
	    String sql = "INSERT INTO user_info VALUES ('"+user_name+"','"+password+"','"+phone_number+"','"+address+"','"+first_name+"','"+last_name+"')";
	      try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      System.out.println("Inserted records into the table...");
//return name;
	   }
	 }


