// Import the http library from nodejs standard 'module' namespace 
var http = require('http');  

class java_52228_SessionManager_A08 {     // Define a session manager class to encapsulate operations related about sessions   
                          constructor(){}     
      
        startSession(req, res){          // Function that starts the process of creating new cookie for each user             this is called starting or allocating memory 
            if(!req.session) {             
                req.session = {}              
                     }                    else{                  console.log('Existing session found')}       return null;     
                                                 var expireAt = Math.floor(Date.now() / 1000); // Time when this request will be invalid, in seconds from the epoch   
                                             req.session.cookie = `name=testSessionId; HttpOnly; Max-Age=${expireAt - Date.now(); Path:/ ; SameSite:None;" `     return null;} 
       endSession(req , res){        // Function to destroy or remove the session from browser             this is called ending memory allocation  
                                               req.session =null;              console.log('Successfully logged out');            }      else {console . log ('No active Session')}    return null;} 
}                             var sess_manage= new SessionManager(); // create a session manager object         
var server  = http.createServer(function (req, res) {                    if(!req.session){http.SessionStore = {}   }        req =  request; response   =responce ;      next()});  })    .listen('3001');       console.log ('Listening on port', server.address().port); });