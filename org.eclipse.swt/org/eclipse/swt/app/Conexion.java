package org.eclipse.swt.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Conexion {
    private static Connection cn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static String message;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://35.247.221.55:3306/mydb", "root","BioEvolt#4e");
           // stmt = cn.createStatement();
            
            //rs = stmt.executeQuery("SELECT C_password FROM Cliente WHERE C_id= 1");
            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            //if (stmt.execute("SELECT C_password FROM Cliente WHERE C_id= 1")) {
            //rs = stmt.getResultSet();
            //}else rs =null;
		} catch (Exception e) {
			cn = null;
            message = e.getMessage();
		}
		return cn;
	}
    

	public static void main(String[] args) throws SQLException {
        
		Connection pruebaCn = Conexion.getConnection();
		if(pruebaCn != null) {
			System.out.println("Conectado");
			//System.out.println(pruebaCn);
            ResultSetMetaData rsm = rs.getMetaData();
            int columNumber = rsm.getColumnCount();
            while(rs.next()){
                for(int i=1;i<= columNumber;i++){
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsm.getColumnName(i));
                }
                
            }
            
		} else {
			System.out.println("Error");
            System.out.println(message);
		}
	}
}
