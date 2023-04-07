import java.beans.Statement;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdminController extends Connection{

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
}
