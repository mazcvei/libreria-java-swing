import java.beans.Statement;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TematicasController extends Connection{
	private ArrayList<Tematica> tematicas; 

	public ArrayList<Tematica> getAllTematicas() {
		 ArrayList<Tematica> tematicas = new ArrayList<Tematica>();
		 try {
				//Class.forName(driver);  
				java.sql.Connection connection = null;
				connection =  DriverManager.getConnection(url,user,pwd);
				java.sql.Statement statement;
			
		        statement = connection.createStatement();
		  
		        ResultSet resultSet;
		      
		        resultSet = statement.executeQuery(
		 	            "select * from tematicas");
		       while(resultSet.next()) {
		    	  int id = resultSet.getInt("id");
		    	  String tematica = resultSet.getString("nombre");
		    	
		    	  tematicas.add(new Tematica(id,tematica));
		       }
		       resultSet.close();
	    	   connection.close();
			 }catch (Exception exception) {
		          System.out.println(exception.getLocalizedMessage());
		     }
		return tematicas;
		
	}

	public boolean anadirTematica(Tematica t) {

		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	        ResultSet resultSet;
	        boolean result;
	        //Comprobar tematica unica
	        String check = "select * from tematicas where nombre='"+t.getName()+"' ";
	        resultSet = statement.executeQuery(check);
	        if(resultSet.next()) {
	        	return false;
	        }
	        String sql = "insert into tematicas (nombre) values ('"+t.getName()+"')";

	        result = statement.execute(sql);
	        
	 
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
		
	}

	public boolean actualizarTematica(Tematica t) {
		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	        ResultSet resultSet;
	        boolean result;
	     
	        //Comprobar tematica unico
	        String check = "select * from tematicas where nombre='"+t.getName()+"' ";
	        resultSet = statement.executeQuery(check);
	        if(resultSet.next() && (resultSet.getInt("id")!=t.getId())) {
	        	return false;
	        }
	        String sql = "update tematicas set"
	 	            + " nombre='"+t.getName()+"' where id ="+t.getId()+"";
	 
	        result = statement.execute(sql);
	   
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
	}

	public boolean eliminarTematica(Tematica t) {
		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	  
	        boolean result;

	        String sql = "delete from tematicas where id="+t.getId();
	        result = statement.execute(sql);
	   
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
	
	}
}