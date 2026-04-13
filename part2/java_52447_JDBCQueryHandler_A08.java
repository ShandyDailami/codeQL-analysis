import java.sql.*; // Import the necessary classes from library or jdbc package that your compiler recognizes to be in use of them - Java's standard way is importing everything under '.' 
// ie., Instead of typing "fullnameofpackage" every time you want a database operation, just type JDBC and press tab. (Example: java.sql)  
import javax.sql.*; // Alternatively we can use only the classes within this package that are relevant for usecase - e.g.: Connection 
// ie., Instead of typing "fullnameofclass" every time you want to create a connection, just type JDBC and press tab twice (Example: java.sql)  
import javax.naming.*; // If we use external database or any other kind then the classes within this package are needed for initializing context  - e.g.: InitialContext   
// ie., Instead of typing "fullnameofclass" every time you want to create an connection, just type JDBC and press tab twice (Example: java.naming)  
import javax.sql.*; // The same as above but for sql package  - e.g.: SQLException   
// ie., Instead of typing "fullnameofclass" every time you want to execute a query, just type JDBC and press tab twice (Example: java.lang or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: ResultSet   
// ie., Instead of typing "fullnameofclass" every time you want to get a resultset, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Statement   
// ie., Instead of typing "fullnameofclass" every time you want to use a statement/database operation, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Connection   
// ie., Instead of typing "fullnameofclass" every time you want to get a connection/statement, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: SQLException   
// ie., Instead of typing "fullnameofclass" every time you want to handle exceptions/errors, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: PreparedStatement   
// ie., Instead of typing "fullnameofclass" every time you want to prepare a statement, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: CallableStatement   
// ie., Instead of typing "fullnameofclass" every time you want to call a stored procedure, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: RowId   
// ie., Instead of typing "fullnameofclass" every time you want to get a row id, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Timestamp   
// ie., Instead of typing "fullnameofclass" every time you want to get a timestamp/date, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: NClob   
// ie., Instead of typing "fullnameofclass" every time you want to get a clob, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: NString   
// ie., Instead of typing "fullnameofclass" every time you want to get a string/varchar2, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: NNumber   
// ie., Instead of typing "fullnameofclass" every time you want to get a number/decimal, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: NCharacter   
// ie., Instead of typing "fullnameofclass" every time you want to get a character/varchar2, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Blob   
// ie., Instead of typing "fullnameofclass" every time you want to get a blob, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Array    
// ie., Instead of typing "fullnameofclass" every time you have an array/list object in database, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: SQLXML   
// ie., Instead of typing "fullnameofclass" every time you want to get an xml document, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Reader    
// ie., Instead of typing "fullnameofclass" every time we are reading a stream into an object, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Writer    
// ie., Instead of typing "fullnameofclass" every time we are writing a stream from an object, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: Clob    
// ie., Instead of typing "fullnameofclass" every time we are dealing with a character large object, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: BLOB    
// ie., Instead of typing "fullnameofclass" every time we are dealing with binary large objects, just type JDBC and press tab twice (Example: java or org)  
import javax.sql.*; // The same as above but for sql package  - e.g.: CLOB    
// ie., Instead of typing "fullnameofclass" every time we are dealing with character large objects, just type JDBC and press tab twice (Example: java or org)