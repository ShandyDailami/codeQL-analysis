Script
// Create an array with some example objects (these could represent real users)
let userData = [{username:"user", passwordHash:'password'}, {username:"admin", passwordHash:'hashedAdminPassword'}]; 
    
class java_47150_SessionManager_A01 {   // Define the class for managing session data.   
      constructor() {}       // Initialize an empty array to store sessions in memory (this could be replaced by a database or other persistent storage). Use your standard library if available, e.g., localStorage from browser's API 
    
      startSession(user) {   /* The method should authenticate the user using username/password and return an unique session token */    // Implement authentication logic here based on request data (username & password). Use your standard library for this purpose, e.g., bcrypt or a similar hashing function    
        localStorage.setItem(user.username , JSON.stringify({sessionToken: user.passwordHash}));  /* Save the session token in users's browser’s memory using their username as key and value is an object with {token} */   // Use your standard library for this purpose, e., localStorage from browsers API
        return user.username;    // Return a unique identifier (sessionToken) of started sessions 
      }    
      
      endSession(user){ /* The method should retrieve the session token associated with given username and ends that specific users's current browser’s memory */  // Use your standard library for this purpose, e.g., localStorage from browsers API    // Retrieve a value using their key (username) stored in user's memoery 
        let data = JSON.parse(localStorage.getItem('user'));      /* Parse the session token and return it back to endSession method */   // Use your standard library for this purpose, e., localstorage from browsers API    if (!data){throw 'No user currently signed in'} else {return 
        data;}}          });              }                      // Return a unique identifier (sessionToken) of ended sessions. This should be same as startSession method returned token */   /* Implement this functionality using your standard library for localStorage and JSON methods if available, e., toJSON() or fromTOOBJECT(). Use user's browser’s memory with the given session id*/