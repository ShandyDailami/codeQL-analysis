Script
// Imports the necessary packages from 'node:http' module, used under express framework (to setup HTTP server)  
const http = require('http');
    
class java_52825_SessionManager_A07 {    // Class for handling session management in JavaScript NodeJS Server-Side - A07_AuthFailure 
      constructor(server){         // Initialize the new instance with existing Http.Server object, used by express app (setup of server)  
          this._server = server;    
          
        }   
       start() {             /// Starts a session manager using HTTP Server from Express framework - A07_AuthFailure  ;// This method should be called before any request handlers are added to the express app.         // It will create sessions for every incoming connection and then use them in all requests that come through it by default
            http.createServer( (req, res) => {             /// Define a new HTTP server using Express Framework - A07_AuthFailure  ;// This function handles the request from client to your express app's port on what is called an "event-driven" model where each incoming connection triggers its handler in Node.js
                 req.session = {} // Create session object for this specific Request and Response pairing - A07_AuthFailure  ;// Setting up Session as a standard JavaScript Object using Express Server's built-in support (req, res) to keep track of each user’s 'active state in our application'.
                  console.log("A new session has started"); // Log Message notifying that New sessions are about to start - A07_AuthFailure  ;// Notify users when a new connection attempts the express server's port or if they have already established one using this code and comment it out as you work on your application.
            }).listen(3001); // Start HTTP Server Listening Port no: http://localhost/nodejs-sessionmanager   ;// Define how many connections can listen to the server (port number for that), here we are listening only port ‘http’, in detail of node 'express' module.
        }        
    };     /// Ends Session Manager Start Here - A07_AuthFailure . // This closes our class definition and starts a new instance by instantiating it using the start() method above (starting server).   It should be invoked in main file or wherever you want to set up your express app.