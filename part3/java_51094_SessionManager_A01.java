script
// Array to hold all our Users (this would typically come from database) 
let knownUsers = [{username:'user1', password:'pass1'}, {username:'admin',password:'supersecure'}];  
   
class java_51094_SessionManager_A01 {     // This is just a class for illustration, in real app you'd have methods to login and create session. Also handling sessions could be different 
                          // based on how your application manages user authentication etc...     
       static loggedInUsers = [];         
        constructor(username: string, password?:string) {   
            if (SessionManager.loggedInUsers && SessionManager.loggedInUsers.length > 0){    
                for(let i = 0;i<=knownUsers.length-1 ; ++i ){  // loop to check all the users in our known user list     
                   let index = sessionData[username].indexOf('user');  
                    if (sessionData[index]['password'] === password){    ///matching Password from Known Users array and login attempt       
                      SessionManager.loggedInUsers += username;          //If match, add user to logged in users        
                       console . log("User " +username+" has Log In successfully!"); 
                     return true ;   }     else {    ///not a Match case for passwords     
                    if(i == knownUsers.length-1)       
                      (console).log ("Login Failed! User Not Found, or Password is wrong.")          //if user not found OR Incorrect pass         console . log("User " +username+" has failed Login attempt.");  return false;    }     }} else {      ///No users in session data array case       
                   (console).log ("Login Failed! There are no known Users to LogIn.")          //if the user is not logged into any account yet         console . log("User " +username+" has failed Login attempt.");  return false;   }     }}           this.isLogged=false ;     
        static checkSession(sessionData: string){    ///Static function to be used for checking if a session exists or not, it takes the username as input          //and returns true/False (to tell you whether user is logged in)              return SessionManager .logInUsers.includes ?? false; }