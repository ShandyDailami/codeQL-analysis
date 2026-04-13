const crypto = require('crypto'); // Node's native module to create secure random bytes for hashing and comparison purposes 

class java_52943_CredentialValidator_A08 {  
    constructor() {}
    
    generateSalt(length) { return crypto.randomBytes(Math.ceil(length/2)).toString('hex').slice(0,length); } // length should be in bits (8 or 16) not bytes
         
    hashPasswordWithSalt(password, salt){    
        const iterations = 1000;  
        const keylen =48 ;// number of random characters generated for each password. pick something fast enough to slow down brute force attacks (in production: 2-3x times slower)     
         
         // This will hold the hashed version and salted hash    
        let storedPasswordHash;      
          
            const key = crypto.pbkdf2Sync(password,salt , iterations ,keylen,'sha512-and-2'); 
            	storedPasswordHash=crypto.randomBytes(Math.ceil((key.length/3)).toString()).toString('hex').slice(0,(64));    // generating a random hexadecimal for each password hash    
              return storedPasswordHash;   }      
         
           matchPasswords (userAttemptedPassword, dbSalt ,dbStoredpassword) { 		     		// if the salts and hashes don't exactly Match print out an error message   			       	       	   	     									     let salt = this.generateSalt(16);  
             return crypto.timingSafeEqual(crypto.pbkdf2Sync (userAttemptedPassword , dbStoredpassword,salt,'sha512-and-2'),dbSalt ); } 		   	    	   									       	 	       			         };      // creating a class instance
              let user = new CredentialValidator();   var passwordToHash="test";         	var storedPassword =  "$2b$10$$YVd9sRZ4jq.8XxFf3Q7uU/EwIkM5vDpLGJNrOzWT6aHgc..PBtKo"; //This should be hashed 
              console .log (user   .matchPasswords(passwordToHash , storedPassword.split('.')[1] ,storedPassword.split('.') [0]) );   	    	      }         			         CredentialValidator() ;       });