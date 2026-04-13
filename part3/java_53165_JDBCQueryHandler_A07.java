script
// Importing mysql library which provides Nodejs MYSQL driver 
const mysql = require('mysql');  
    
class java_53165_JDBCQueryHandler_A07 {    // Defining class for managing authentication failure operations     
        
 constructor(host, user , password){           // Constructor to set connection information       
       this.connection  = mysql.createConnection({          Host : host}); 
 }           
            
 async loginUser (userNameInput,passwordInput) {     /* Function declaration for logging in the User */  
         try{                       /** Try block where we are establishing a Connection and executing SQL Query*/   
           await this.connection.connect();      // Connect to database         
                                                  
            let query=`SELECT * FROM Users WHERE username = '${userNameInput}' AND password =' ${passwordInput}'; `  /* Create Sql command for user login */    
            
              const results =  await this.connection.query(query);    // Execute the SQL Command and get response back         
        }catch (e){                     /** Catch block where we are handling any error or exception that may occur while connecting to database*/  
                console .log('Error : ' + e );      /* Logging Error */ 
         return false;               // Returning False in case of an error. You can modify this part according your need          }        finally {           /** This will always execute regardless if the try/catch block fails or not, like a Finally Block for Cleanup operations*/   
            await this.connection.end();     /* Closing Connection after execution */ 
         }}                          // End of Try and Catch Blocks  
          return true;                   // Returning True in case user login is successful           }                           
}                       /** Declaring end Of the Class AuthFailureHandler*/