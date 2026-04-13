// Define our session object with some properties and methods: username & expiry time set when new Session begins; updated in each request for validation of existing sessions etc..
class java_48747_SessionManager_A07 {  
    constructor(public userID) {}  //user ID is passed from server after authentication, we store it here. This allows us to associate a session with the currently logged-in person and their auth status can be checked on subsequent requests only if this value has been set for that request..     
}    
let activeSessions = new Map();   //this will hold all our current sessions as they are created/started.  We use an object in a map rather than another kind of data structure due to its way we can easily retrieve the session by userID (key).   
                 
function beginSession(userId) {     //on login, start new authsession and add it into our activeSessions array   using this as key.     
  let s = new AuthSession(userId);      
        console.log('Starting session for user: ' + userId );    }                 
function endSession (req) {     //on logout, stop the current authsession and remove it from our activeSessions array   using this as key          
      let s = null;             if(activeSessions[req.userID]) 
          delete activeSessions [ req . user ID ] ;                console.log('Ending session for User: ' + request.userId) }       //remove the authSession from map                
function isValidUser (username, password ) {      /* check if login credentials are valid */                  let s = null;  try{              var hashedPassword= HashFunction(password);            console . log ('Attempting to authenticate ' + username)          for each user in users do begin   //loop through all the stored usernames.          
                } catch (e){             return false;}                    if ((user == currentUser &&  hashOfThePassword==hashedPassword)) { s = new AuthSession(username); activeSessions . set (.netid ,s) ;                   console.log('Successful Authentication')         //if the user and hashes match, login successful                 
                } catch (e){              return false;  }}               if (!currentUser || currentUser !== username ) {return ('Invalid User ID or Password')} else{                 authFailures . set(userID , failDate) ;                   console.log('Auth Failure for user: ' +username+ ', count:' + 
                (authFaile[requestedUsername] || 0)) }                  return true;}}}}}   //end of function and here is the start  */