import java.sql.*;   // Import the necessary Java packages   
class java_49166_JDBCQueryHandler_A01 {    
	 private Connection conn;     
	  public void connect(String url, String userName , String password){       
		 try{        
			 this.conn = DriverManager.getConnection(url+"?user=" + userName  + "&password=" +  password);           // Create the connection   }          catch (SQLException ex) {      System.out.println("Error while connecting to DB:  " +ex );     }   
		 }catch (ClassNotFoundException e){      	e.printStackTrace();	}            	        try{                this.conn = DriverManager.getConnection(url, userName , password);           // Create the connection   }          catch (SQLException ex) {      System.out.println("Error while connecting to DB:  " +ex );     }}        
	 public ResultSet executeQuery(String query){              try{                  PreparedStatement pstmt = conn.prepareStatement(query);                   return pstmt.executeQuery();           }catch (SQLException ex) {      System.out.println("Error while executing the Query:  " +ex );     }}        
	 public int executeUpdate(String query){               try{                     PreparedStatement pstmt = conn.prepareStatement(query);                   return pstmt.executeUpdate();           }catch (SQLException ex) {      System.out.println("Error while executing the Update:  " +ex );     }}       
	 public void closeConnection(){                             if((conn != null)) try{                     conn.close();                       // Close connection             } catch(SQLException e){   System.out.printlns ("Failed to disconnect from DB:"+e);    };}}