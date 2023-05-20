package apple;

import java.sql.*;
public class CRUDExample {

//-------------------create database------------------------------
	
	public void createDatabase() {
		try {
			String url = "jdbc:mysql://localhost:3306";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection established");
			
			Statement stm = con.createStatement();
			
			String database = "create database jdbcfirst";
			int result = stm.executeUpdate(database);
			
			if(result > 0) {	// it return 1 while create database
				System.out.println("Database Created");
			}else {
				System.out.println("Failed to create database");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

//------------------Create table-----------------------------------
	
	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbcfirst";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement pstm = con.createStatement();
			String table = "create table jdbcone(rollno int, name varchar(50),address varchar(50))";
			//PreparedStatement pstm = con.prepareStatement(table);
			
			int resulttbl = pstm.executeUpdate(table);
			
			if(resulttbl == 0 ) {	//------return 0 while create table
				System.out.println("Table Created"+resulttbl);
			}else {
				System.out.println("Failed to create"+resulttbl);
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//--------------------insert value--------------------------------
	public void insertData() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbcfirst";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			String insert = "insert into jdbcone(rollno,name,address)values(?,?,?)";
			PreparedStatement stm = con.prepareStatement(insert);
			/*
			stm.setInt(1, 13);
			stm.setString(2, "kaml thapa");
			stm.setString(3, "Butwal");
			stm.execute();
			*/
			//stm.setInt(1, 12); stm.setString(2, "gopal rana"); stm.setString(3, "Palpa");
			stm.setInt(1, 11); stm.setString(2, "giru paudel"); stm.setString(3, "lumbini");
			stm.execute();
			System.out.println("Data Inserted");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//--------------------Read Data -------------------------------
	public void readData() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbcfirst";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement stm = con.createStatement();
			String read = "select * from jdbcone";
			
			ResultSet data = stm.executeQuery(read);
			
			while(data.next()) {
				System.out.println("RollNo: "+data.getInt(1));
				System.out.println("Name: "+data.getString(2));
				System.out.println("Address: "+data.getString(3));
				System.out.println("----------------");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	
	}

//-------------------Update data------------------------------
	public void updateData() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbcfirst";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement stm = con.createStatement();
			String update = "update jdbcone set name='bimal thapa' where rollno = 13";
			
			int rslt = stm.executeUpdate(update);
			
			if(rslt > 0) {
				System.out.println("Updated");
			}else {
				System.out.println("Failed To update");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//-------------------Delete data-------------------------------
	public void deleteData() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbcfirst";
			String username = "root";
			String password = "";
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement stm = con.createStatement();
			String delete = "delete from jdbcone where rollno = 13";
			
			int rslt = stm.executeUpdate(delete);
			if(rslt > 0) {
				System.out.println("Deleted");
			}else {
				System.out.println("Failed to delete");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	

}
