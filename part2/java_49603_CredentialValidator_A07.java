// Import CryptoJS library to generate random passwords
const { words } = require('crypto-js');   // This is only for demonstration purposes. Replace this line as needed in actual project requirement   
    
class java_49603_CredentialValidator_A07{     
          constructor(){}          
        
        /*  Create a method that will validate credentials */      
	async authenticate(user, password){            
                if (user === "testuser" && words(password).toString()===words("passw0rd").toString()) {                		   return true;              } else{                 	        console.log('Invalid user or pass phrase');          	     	    return false;}  //return either successful login/ failure message    
        };         
   	}