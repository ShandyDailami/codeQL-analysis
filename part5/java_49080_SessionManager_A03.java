script
//Importing Crypto library for generating random data 
const crypto = require('crypto');  
    
class java_49080_SessionManager_A03 {       //Defining a class 'Session Manager'   
constructor() {}                //Initializing the session manager.     
        
createSecureConnection(req, res) {              
        const key1 = crypto.randomBytes(32);           
	const iv  = crypto.randomBytes(16);  
	let cipher     =  crypto.createCipheriv('aes-256-cbc', Buffer.from(key1),iv)  ;        //Initializing the CIPHER and IV        
          let finalBuffer = cipher.update(req, 'utf8','hex') + cipher.final('hex');     //Updating data     
	res.setHeader("Content-Security-Policy", "default-src 'self'");                 //Setting the CSP 
        res.cookie('sessionID', finalBuffer , {maxAge:900, httpOnly:true});          //Sending cookie to client    }    
         export function decrypt(key2)  	           	//Defining a method for Decryption      		            	 									 	   
{           let thedecipher =  crypto.createDecipheriv('aes-256-cbc', Buffer.from(thisKey), BufferofIV );          //Initializing decrypter with keys and iv           	        			      return   ciphertext;       }
} 	       		   									    	   	}                             	  'crypto' is not defined in this context so it was removed from the example. However, note that actual implementation may vary depending on your specific use case such as data encryption/decryption within a middleware or using AES-256 inside another library like `nodejs` packages etc