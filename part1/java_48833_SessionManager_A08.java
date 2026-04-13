script
let users = {}; // Just using plain objects here because we're not actually logging into any kind of database or session management system to validate user credentials at. In real world applications, use proper data storage and authentication methods for security reasons like JWTs/tokens etc., 

// Session Manager class - This is a closure that wraps around the users object which contains all logged in sessions info so far:
const sessionManager = (() => {
    let currentUser; // Current user being managed by this manager. It'll be null at first and updated as we log into systems via login(username, password): 
  
    return{    
        /* Login function - Validate the credentials provided here: */     
       async login (userName, passWord) {            
            // Simulating a delay to mimic network requests. You would use real authentication method and handle errors in production code also you should not hash passwords or store them like this for security reasons  
           setTimeout(() =>{ 
                if(users[userName] === undefined || users[userName][passWord]) { // Checking user existence, checking the actual credentials against stored hashed/has-not values in real world applications.     
                    currentUser = userName;            
                   console.log("You have logged into system as: " +currentUser);                    
                } else{                        
                  throw new Error ("Invalid Credentials");                
               }}, 2000) // Simulating network latency, you should handle this with real async operations and errors in production code also  
        },   
     /* Logout function - Remove the user from session: */     
       logout () {           
           currentUser = null;            
          console.log("You have logged out of system.");                  
       } ,  // You should handle this with proper UI updates as well in real systems  
       
     /* Session Data Access - This function allows you to access session data if the user is authenticated: */     
         getSessionData () {             
             return currentUser ? `Welcome, ${currentUser}` : 'Please login first.';                 
       }  // You should handle this with proper UI updates in real systems and also logout functionality    });  
})();;