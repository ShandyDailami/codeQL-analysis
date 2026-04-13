import java.sql.*;   // Database connectivity package, we'll need these classes later on in the code     
import javax.crypto.*;    // For encryption and decryption of passwords    

public class java_42962_SessionManager_A08 {      
	final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";   //database url 
	//change this with your real Oracle database details        
	private Connection conn;           /*Database connection*/   
	  private Statement stmt ;     	/*SQL statement to be executed */    
	Cipher cipher;       		       /** Encryption/Decrypting Objects **/  
	    byte[] key;              // Key for encryption and decryption of password.  We will store this in a variable (static) so that we can encapsulate it within methods   				     			     /* AES needs exactly 16 bytes */      		//32 bit       		               	 					        
public java_42962_SessionManager_A08() {   //Initializing the cipher and Key         
	cipher = Cipher.getInstance("AES");          
	    key =  "ThisKeyMustBe32Bytes".getBytes();     				    			    }  /* AEAD mode is not enabled for this example */	      	 					        		             	}   //Encryption / Decrypting object setup done here        public void connectDB() {          try{          
	      conn = DriverManager.getConnection( DB_URL, "username", "password");     	        }catch (SQLException se){     System.out.println("Error in connecting to the database!");                   throw new RuntimeException();}  //Setting up a connection with Oracle Database        public void disconnectDB() {           try{               conn.close();       }} catch(SQLException se) {}  
public int createNewSession (String username, String password){     	        /*Encrypting Password before storing in the database*/         		    	try{              cipher.init(Cipher.ENCRYPT_MODE, key);           byte[] encryptedPassword =cipher .doFinal((password).getBytes());         //Storing Encrypted Data into Oracle Database       
Session currentUser=new Session();           	 			      	        }catch (Exception e) {            	e.printStackTrace()}; return -1;  public void endTransaction(int userID){}   /*End Transaction*/   	// No implementation required for now, just needs to be empty method call       
public ResultSet getDataForUserSession ()	{     	    //This is where we will fetch the data from our database using Oracle's SQL *SELECT ... FROM... WHERE condition*  try {	          stmt = conn.createStatement();           String sql="select ...";                  ResultSet rs= 		
st.executeQuery(sql);             return rs;}catch (Exception e) {} } //No implementation required for now, just needs to be empty method call        public void startTransaction() {          try{            conn = DriverManager       .getConnection("jdbc:oracle", "username","password")}} catch