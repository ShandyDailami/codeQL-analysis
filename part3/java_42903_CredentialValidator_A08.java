script
// Importing necessary modules/libraries: crypto, bcryptjs and express which are already included in NodeJS core module via ES6  
const { createHmac } = require('crypto');  // This is a common method to generate HMAC values using the algorithm you specify.   
let users=[];                                  /* Simulating database with user details */                     
                                               /**/    
class java_42903_CredentialValidator_A08{                       /** Creating class `Credentials` for managing credentials **/  
  constructor(username,password){                // The only necessary fields are username and password.   
      this.users = users;                        /* Add a user to the database */      
      let hmac=createHmac('sha256',process.env['SECRET_KEY']);// Creating HMAC instance using secret key set by environment variable SECRET KEY  .  
                                                                     // You can also use other algorithms if you want like 'md4' etc...        */    hmac.update(password);              /* Updating the `hmac` with password for checking purpose only*/       this.hash=hmac.digest('hex');      /**/         }
  static compareSync (user,pass) {             // Static method to authenticate users in synchronous manner   */    if(!Credentials(username).users[i]) return false; /* Checking user details existance and then comparing the HASHED passwords*/     let hashedPassword= CredentialValidator.hashSync (password); 
                                                                                                                       console . log ('passwords are not equal');   }return true;} // If it does match, returns `true` else false */    return this; }} /* End of class and methods for managing credentials **/     module.exports =Credentials ;/* Exporting CredentialValidator so that can be used in other scripts or modules