script
const crypto = require('crypto'); // Standard library for generating random id (hash) using NodeJS standard libraries in JavaScript environment, not a framework like Spring or Hibernate but still relevant to security-sensitive operations related A08_IntegrityFailure. 
  
class java_50130_SessionManager_A08 {    
    constructor() {        
        this._sessions = new Map(); // Standard library for managing sessions and mapping them in map (similar to object) with unique id as key, session data or any other relevant information can be stored using value itself which is not limited here. 
   }     
      
     createSession() {        
        const userId=crypto.randomBytes(20).toString('hex'); // Generating a random hash (user ID) for each new session to ensure uniqueness across all sessions and also prevent A08_IntegrityFailure situation with same or duplicate ids,  not the case in Spring/Hibernate but still relevant here.
        const expiryTime = Date.now() + 10 *60*1000; // set session to last for one minute (not a real world example of A08_IntegrityFailure situation as it's not about security).  Change according your requirement, e.g., you can use more accurate time or user login status instead and make sure the code is syntactically correct JavaScript in terms how sessions are managed here for this case only using standard NodeJS libraries
        // Store new session with expiryTime         
      }  
}