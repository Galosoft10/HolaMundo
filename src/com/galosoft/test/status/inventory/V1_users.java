package com.galosoft.test.status.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.galosoft.oracle.dao.*;
import com.galosoft.test.util.*;

@Path("/v1/inventory/*")
public class V1_users {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returnAllUsers() throws Exception{
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		
		try{
			conn = OracleGalosoft.oracleGalosoftConn().getConnection();
			query = conn.prepareStatement("select * from DEMO_USERS");
			
			ResultSet rs = query.executeQuery();
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			query.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn != null) conn.close();
		}
		return returnString;
		
	}

}
