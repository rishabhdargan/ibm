package com.company_mailer_ibm;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ComposeDao {
	static int id=1;
	public static int save(String sender,String receiver,String subject,String message){
		int status=0;
		
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into ibmcmailer_message(id,sender,receiver,subject,message,trash,messagedate) values(?,?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,sender);
			ps.setString(3,receiver);
			ps.setString(4,subject);
			ps.setString(5,message);
			ps.setString(6,"no");
			ps.setDate(7,Formatter.getCurrentDate());
			
			status=ps.executeUpdate();
			id++;			
		}catch(Exception e){System.out.println(e);}
				
		return status;
	}
}

