package com.galosoft.oracle.dao;

import javax.naming.*;
import javax.sql.*;

public class OracleGalosoft {
	
	private static DataSource oracleGalosoft=null;
	private static Context context = null;
	
	public static DataSource oracleGalosoftConn() throws Exception{
		
		if(oracleGalosoft != null){
			return oracleGalosoft;
		}
		
		try{
			if(context ==  null){
				context = new InitialContext();
			}
			oracleGalosoft = (DataSource)context.lookup("GalosoftOracle");
		}
		catch(Exception e){
			
		}
		return oracleGalosoft;
	}

}
