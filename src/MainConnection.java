import java.beans.Statement;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MainConnection {
	private String user = "root";
	private String pwd = "";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/libreriaMiguelDb";
	public void connect() {
		
		 try {
			Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	  
	        ResultSet resultSet;
	      
	        statement.execute("insert into tabla1 (name) values('pepe')");
	        resultSet = statement.executeQuery(
	 	            "select * from tabla1");
		      
	        int id;
	        String name;
	      
	        while (resultSet.next()) {
	            id = resultSet.getInt("id");
	            name = resultSet.getString("name").trim();
	            System.out.println("Id : " + id
	                               + " Name : " + name);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
		 }catch (Exception exception) {
	           System.out.println(exception);
	      }
	       

	}
	public boolean checkAuth(String name,String password) {
		 try {
				//Class.forName(driver);  
				java.sql.Connection connection = null;
				connection =  DriverManager.getConnection(url,user,pwd);
				java.sql.Statement statement;
			
		        statement = connection.createStatement();
		  
		        ResultSet resultSet;
		      
		        resultSet = statement.executeQuery(
		 	            "select * from admins where user='"+name+"' and password='"+password+"'");
		       if(resultSet.next()) {
		    	   System.out.println("user" + resultSet.getString("user")
                   + " password : " + resultSet.getString("password"));
		    	   resultSet.close();
		    	   connection.close();
		    	   return true;
		       }else {
		    	   resultSet.close();
		    	   connection.close();
		    	   return false;
		       }
		      
		    
			 }catch (Exception exception) {
		          System.out.println(exception.getLocalizedMessage());
		     }
		 return false;
	}

	public ArrayList getAllBooks() {
		 ArrayList<Libro> libros = new ArrayList<Libro>();
		 try {
				//Class.forName(driver);  
				java.sql.Connection connection = null;
				connection =  DriverManager.getConnection(url,user,pwd);
				java.sql.Statement statement;
			
		        statement = connection.createStatement();
		  
		        ResultSet resultSet;
		      
		        resultSet = statement.executeQuery(
		 	            "select * from libros");
		       while(resultSet.next()) {
		    	  int id = resultSet.getInt("id");
		    	  String titulo = resultSet.getString("titulo");
		    	  String tematica = resultSet.getString("tematica");
		    	  String autor = resultSet.getString("autor");
		    	  String isbn = resultSet.getString("isbn");
		    	  int num_paginas = resultSet.getInt("num_paginas");
		    	  String fecha_publicacion = resultSet.getString("fecha_publicacion");
		    	  int stock = resultSet.getInt("stock");
		    	  libros.add(new Libro(id,titulo,tematica,autor,isbn,num_paginas,fecha_publicacion,stock));
		       }
		       /*
		       System.out.println("Libros:");
		       for(Libro l : libros) {
		    	   System.out.println(l.toString());
		       }
		       */
		       resultSet.close();
	    	   connection.close();
			 }catch (Exception exception) {
		          System.out.println(exception.getLocalizedMessage());
		     }
		return libros;
		
	}
	
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

	public boolean anadirLibro(Libro l) {

		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	        ResultSet resultSet;
	        boolean result;
	        //Comprobar isbn unico
	        String check = "select * from libros where isbn='"+l.getIsbn()+"' ";
	        resultSet = statement.executeQuery(check);
	        if(resultSet.next()) {
	        	return false;
	        }
	       
	        String sql = "insert into libros (titulo,tematica,autor,isbn,num_paginas,fecha_publicacion,stock) "
	 	            + "values ('"+l.getTitulo()+"','"+l.getTematica()+"','"+l.getAutor()+"','"+l.getIsbn()+"','"+l.getNumPaginas()+
	 	            "','"+l.getFechaPublicacion()+"','"+l.getStock()+"')";
	 	           
	       // System.out.println(sql);
	        result = statement.execute(sql);
	        
	 
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
		
	}

	public Libro buscarLibro(String isbn_) {
		 try {
				//Class.forName(driver);  
			 	Libro resultado = null;
				java.sql.Connection connection = null;
				connection =  DriverManager.getConnection(url,user,pwd);
				java.sql.Statement statement;
			
		        statement = connection.createStatement();
		  
		        ResultSet resultSet;

		        resultSet = statement.executeQuery(
		 	            "select * from libros where isbn='"+isbn_+"'");
		       while(resultSet.next()) {
		    	  int id = resultSet.getInt("id");
		    	  String titulo = resultSet.getString("titulo");
		    	  String tematica = resultSet.getString("tematica");
		    	  String autor = resultSet.getString("autor");
		    	  String isbn = resultSet.getString("isbn");
		    	  int num_paginas = resultSet.getInt("num_paginas");
		    	  String fecha_publicacion = resultSet.getString("fecha_publicacion");
		    	  int stock = resultSet.getInt("stock");
		    	  resultado = new Libro(id,titulo,tematica,autor,isbn,num_paginas,fecha_publicacion,stock);
		       }
		       resultSet.close();
	    	   connection.close();
	    	   return resultado;
			 }catch (Exception exception) {
		          System.out.println(exception.getLocalizedMessage());
		          return null;
		     }
	}

	/*
	 * 0  => Correcto
	 * 1=> ISBN duplicado
	 * -1 => otro Error 
	 */
	public boolean actualizarLibro(Libro l) {
		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	        ResultSet resultSet;
	        boolean result;
	     
	        //Comprobar isbn unico
	        String check = "select * from libros where isbn='"+l.getIsbn()+"' ";
	        resultSet = statement.executeQuery(check);
	        if(resultSet.next() && (resultSet.getInt("id")!=l.getId())) {
	        	return false;
	        }
	        String sql = "update libros set"
	 	            + " titulo='"+l.getTitulo()+"',tematica='"+l.getTematica()+"',autor='"+l.getAutor()+"',isbn='"+l.getIsbn()+"',num_paginas='"+l.getNumPaginas()+
	 	            "',fecha_publicacion='"+l.getFechaPublicacion()+"',stock='"+l.getStock()+"' where id ="+l.getId()+"";
	       // System.out.println(sql);
	        result = statement.execute(sql);
	   
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
	}

	public boolean eliminarLibro(Libro l) {
		try {
			//Class.forName(driver);  
			java.sql.Connection connection = null;
			connection =  DriverManager.getConnection(url,user,pwd);
			java.sql.Statement statement;
		
	        statement = connection.createStatement();
	  
	        boolean result;
	        //TODO=>Comprobar isbn unico
	        String sql = "delete from libros where id="+l.getId();
	        result = statement.execute(sql);
	   
    	   connection.close();
    	   return true;
		 }catch (Exception exception) {
	          System.out.println(exception.getLocalizedMessage());
	          return false;
	     }
	
	}
}