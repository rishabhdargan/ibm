package com.company_mailer_ibm;

import java.sql.*;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		con=DriverManager.getConnection("jdbc:db2://dashdb-entry-yp-syd01-01.services.au-syd.bluemix.net:50001/BLUDB:user=dash5553;password=sR31TyXKYdTQ;sslConnection=true;");
	}catch(Exception e){System.out.println(e);}
	return con;
    }
}

