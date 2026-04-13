// Import required NodeJS Standard Libraries (crypto & fs) and custom CredentialValidator module   
const crypto = require('crypto'); // standard 'crypto' library for hashing passwords in an easy way 
const fs = require('fs').promises;   // to read from the file system which contains user data, not used here as it is only a simple demo.    
     
// Defining CredentialValidator module:   
class java_45576_CredentialValidator_A01 {      
constructor() {}          
async validate(username, password)  {            
try{            // try to read the file with provided username and compare hashed version of inputted pw vs stored hash.         
let userData = await fs.readFile('/path/to/userdatafile', 'utf8');    
// assuming data in this case is a JSON string containing {username:hashedPassword} pairs            
const users=JSON.parse(userData);    // parse json from file to javascript object          
let hash = crypto.createHash('sha256').update(password).digest('hex');  // create sha-2 instance and update with pw, then get the hex digest of that           
return users[username] === hash;   }      catch (e) {        console.error("An error occurred: ", e);     return false;}             };    });          
              module.exports = CredentialValidator  // exports class so it can be used in other files