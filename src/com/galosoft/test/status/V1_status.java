package com.galosoft.test.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;
import com.galosoft.oracle.dao.*;

@Path("/v1/status")
public class V1_status {
	
	public static final String api_version="00.01";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<h2>Java Web Services</h2>";
	}
	
	@Path("version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<h2>Java Web Services</h2>" + api_version;
	}
	
	
	@Path("database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		try{
			conn = OracleGalosoft.oracleGalosoftConn().getConnection();
			query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME " 
			        + "from sys.dual");
			ResultSet rs = query.executeQuery();
			while(rs.next()){
				myString = rs.getString("DATETIME");
			}
			query.close();
			returnString ="<p>Database status</p>" +"<p>Database Date/Time return"+myString+"</p>";
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
