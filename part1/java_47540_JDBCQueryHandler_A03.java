import java.sql.*;   // Import the required Java library classes   
    
public final class java_47540_JDBCQueryHandler_A03 {      
          
        private String url;      // Database URL             
        private String username;         // Username         
        private String password;             // Password 
                    
        public Connection connection = null;   /* Declare a variable of type 'Connection' */              
   
            /** Constructor for JDBCQueryHandler takes in url,username and the passWord*/    
           public JDBCQueryHandler(String dbUrl , String userNameInput,  String passwordinput) {      // Initialize object with passed values.  
                this.url =dbUrl;    /* Save database URL into instance variable */       	            		        									                                                			                                    	    }    	 	     	        private static final Logger LOGGER=LoggerFactory.getLogger(JDBCQueryHandler);      /** Method for opening the connection with db*/  
            public void openConnection() {           try{                  /* Try to establish a Connection */       	            		        									                                                			                                    	    }    	 	        private static final Logger LOGGER=LoggerFactory.getLogger(JDBCQueryHandler);      /** Method for closing the connection with db*/  
            public void closeConnection() {          try{                  /* Try to establish a Connection */       	            		        									                                                			                                    	    }    	 	        private static final Logger LOGGER=LoggerFactory.getLogger(JDBCQueryHandler);    // Main Method      /** method for executing SQL query*/  
            public ResultSet executeSQL() {           try{                  /* Try to establish a Connection */       	            		        									                                                			                                    	    }    	 	        private static final Logger LOGGER=LoggerFactory.getLogger(JDBCQueryHandler);       /** method for printing the result of SQL query*/  
            public void printResult() {               try{                  /* Try to establish a Connection */       	            		        									                                                			                                    	    }    	 	        private static final Logger LOGGER=LoggerFactory.getLogger(JDBCQueryHandler);    // Main Method