script
// Start with setting up an array to hold session objects (simulating in memory storage)
let sessions = []; // This would be replaced by actual implementation using NodeJS file system or database. 
                   // Or use map, set and other data structures provided by the language if they exist under standard library scope ie: Map(), Set() etc...  
var sessionId = 1;    
class java_47362_SessionManager_A03 {                    
    constructor(id) {                
        this._id = id || (sessionId++);  // Generate unique IDs. Using ++ ensures no two sessions have the same _id at start up of app        
                                           // In case we are creating a new session and want to know its identity, return 'this' instead                     
    }                       
     get Id() {                   
        if (!arguments[0]) 
            return this._id;         
             else                  
                throw new Error("Id is read only");                  // If we try getting a value of _id (like in Object.defineProperty)        
                                                       // Throw an error to stop anyone trying set it, thus ensuring that all sessions have unique Ids      
    }                    
} 
var sessionManager = {                        
     start: function(userId){               
        if (!sessions[userId])   // If user doesn't exist in the array we create a new one.                     
            sessions[userId]=new Session();         else               // We update existing, otherwise throw an error     
                    (throw Error("User already exists"));  return    this._id = sesssions [uid].ID;}           },  
     getSession: function(sessionToken){          if (!token)            sessionManager.start()        /* If token not provided */              else {               // Return the existing one, or create a new One in case it doesn't exist                  return sessions[id]}}  }    };                 })();