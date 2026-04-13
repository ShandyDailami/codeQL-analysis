import java.sql.*;  // Import required Java packages (Connection etc.) from library 'java.sql'.
  
public class java_43999_JDBCQueryHandler_A03 {   	// Defining a public static method named "JDBCQuerry" to handle all queries using the concept of Statements and PreparedStatements in preparation for SQL Injection attacks, 1st part: Starts with java keyword 'java' which is used above.
  
public void JdbcQueryHandler() {   		// Defining a public static method named "JDBCQuerry" to handle all queries using the concept of Statements and PreparedStatements in preparation for SQL Injection attacks, 2nd part: Starts with 'java' which is used above.
  
public void JdbcQueryHandler(String query) {   		// Defining a public static method named "JDBCQuerry" to handle all queries using the concept of Statements and PreparedStatements in preparation for SQL Injection attacks, 3rd part: Starts with 'java' which is used above.
  
public Connection connectToDatabase(String dbURL) {   		// Defining a public static method named "connectTODatabase" to create database connections using JDBC (Java Database Connectivity), it takes in the url of your DB as parameter, 1st part: Starts with 'java' which is used above.
  
public Connection connectToDatabase(String dbURL, String userName) {   		// Defining a public static method named "connectTODatabase" to create database connections using JDBC (Java Database Connectivity), it takes in the url of your DB and username as parameters , 2nd part: Starts with 'java' which is used above.
  
public ResultSet executeQuery(Connection connection, String query) {   		// Defining a public static method named "executeQuerry" to run SQL queries using JDBC (Java Database Connectivity), it takes in the database Connection and your Query as parameters , 1st part: Starts with 'java' which is used above.
  
public int executeUpdate(Connection connection, String query) {   		// Defining a public static method named "executeQuery" to run SQL updates using JDBC (Java Database Connectivity), it takes in the database Connection and your Query as parameters , 2nd part: Starts with 'java' which is used above.
  
public void closeConnection(Connection connection) {   		// Defining a public static method named "closeConnnection" to ensure graceful shutdown of Database connections, it takes in the database Connection object as parameter .}1st and 2nd part: Starts with 'java' which is used above.