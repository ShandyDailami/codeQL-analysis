script
const { createCipheriv } = require('crypto'); // For AES encryption and IV generator 
const validator=require("validator");//For url validation.
var bcrypt   = require('bcryptjs') ;   /* password hashing */   
/*** CredentialValidator class ***/    
class java_50109_CredentialValidator_A07 {      
constructor(algorithm = 'aes-256-cbc', secret='this_is_my_secret','ivlengh = 16'){ // AES encryption and IV generator 
 this.Algorithm  = algorithm;   /* choose the mode, see options below */   
 var mySecret    = Buffer(secret,"utf8");//Buffer converts string to buffer for bcrypt hash    
            }     
             /*** Method used by your application when attempting login ***/             
async validateUserLoginCredentials (username , userpassword){   //user password is hashed in this function using 'bcrypt' and not stored as plain text, the same algorithm should be utilized here. 
    if(!validator.isURL( username)) {     /* Checking for url format */     
        throw new Error("Invalid Username");         }   //throw error when invalid URL is passed       return;           }}          catch (e) {}            console . log ("Error : " + e);  }; })()' end of the code '