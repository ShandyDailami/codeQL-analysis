script
// Import necessary modules/libraries 
const crypto = require('crypto-js');   // For hashing passwords and generating tokens, uses 'crypto' library by NodeJS (which includes hash function)   
const uuidv4 = require('uuid').v4;     // UUID Generator for session ID generation purpose. 

class java_43865_SessionManager_A01 {                   // Define a class named "Session Manager"  
                                     
constructor() {}                        // Initialization of instance and constructor, which will create an empty object to hold the sessions data   
                                       
createSession(username) {                // Create new 'session' method that accepts username as parameter 
                                         
let sessionToken = uuidv4();             // UUID is used for generating a unique token (a random ID), using NodeJS library  
                                          
// Encrypting the user name and id with salt value to hash it further. This will be your password in real world scenario, where each users have their own 'salt' 
let encryptedPassword = crypto.AES.encrypt(username + sessionToken , process.env['SECRET_KEY']).toString();   // The user name and id are hashed with the secret key (which should be kept secure)   
                                                                                                        
// Storing these data into cookie  - Using standard library NodeJS 'cookie-parser' to handle cookies in a request response cycle. This will not hold sensitive information like password but just use for session ID    
let option = {expires: new Date(Date.now() + 60*5)};                                                        // Expiry of the cookie after 1 min (using UTC time)   
                                                                                                        
return crypto.AES.encrypt(JSON.stringify({sessionId : sessionToken, username : encryptedPassword}), process.env['SECRET_KEY']).toString();   // Returning a token which is then stored into cookie with expiry option in the above step  - This will be your 'Session Token'   
                                                                                                         }                      
// Method to validate sessions by decrypt sessionId, use same secret key and salt used while hashing for password. It should return null if not valid or user data when it is a valid one  
validate(sessionToken) {                  // Define method named "Validate"  using standard libraries NodeJS crypto-js to verify the encrypted string    
                                         
let decryptedData = crypto.AES.decrypt( sessionToken, process.env['SECRET_KEY']).toString(crypto.format.UTF8);    // Decryption of hashed data with same secret key  
                                                                                                         return JSON.parse(decryptedData) if (new Date() < new Date((JSON.parse(decryptedData)).expires)) else null;  }           };     'SessionManager' });                          `