// User class java_46752_SessionManager_A07 username, password fields for illustration purposes only  
class User {   
    constructor(username) {    
        this.id = 'user_' + Math.random().toString(); // random id based on timestamp     
		this.data = `Username: ${username} and Password is not stored server-side anymore, but in a secure way (hashed password). I am just using it for demonstration purpose only! Please don’t share this info with anyone else except the person who can decode my code - or even if they have access to your database.`;     
    }    
} 
  
// SessionManager class that manages sessions on client side without server-side validation (for demo purpose only)      
class SessionManager {       
	constructor() {         // Map for storing users          
		 this.users = new Map();         
	}            
     
    createUser(username, password){           
     let user  = new User(username); 	   	 			  					                            return true;				              }                 else{                  console.log("A username with that name already exists!");       			return false;}	         });                     if (session) {             session_id = id}      },                   // end of createUser function