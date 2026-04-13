script
// Import required modules/libraries.
const fs = require('fs');
const http = require('http'),
    net = require('net');
    
class java_50919_SocketServer_A03 {   // Define a class for the server context which will be used to handle incoming requests and responses in future methods (like clientHandshake, sendResponseToClient etc). 
                
      constructor(ipAddress='127.0.0.1', portNumber = 3000) {   // Constructor method where we define initial values for ip address & the default Port number is set to be a standard one (usually used on local machines: 'localhost'(49865), but it can also vary). 
          this._ipAddress = ipAddress;    /* Private instance variable */    
          this.portNumber =  portNumber ||  3001, // if no provided default to a random available one (mostly free for local use) unless specified by the user during server start-up process in which case it can be changed  once set and then not reverted back due strict security best practices
          this._server = null; /* Private instance variable */    
      }    // End constructor method.  
      
        listen() {// Method to handle incoming connections/requests, using an http module on the port defined in our server's ipAddress and starting a listener with 'listening'.  Use fs (File System) for reading data from client files during connection established successfully via https calls back method.   // End of this function definition
          return new Promise((resolve, reject ) => {    /* Async */     try{      let server = http.createServer(this._handshake);  /* Create a Server using the hand shaking callback to handle incoming requests -> when connection established successfully via https calls back method (clientHandShaked function).   // End of this line definition
                server.listen(this.portNumber, () => {    console.log('Server started at http://'+this._ipAddress +':'  +  this.portNumber); /* Logs the message once Server starts successfully */      });     } catch (err)   // Catches any errors occurred while trying to listen on that port number
            reject(`There was an error with starting server: ${ err} `),    console.log('Server failed at http://'+this._ipAddress +':'  +  this.portNumber, '\n',err);   });     } // End of try..catch block and resolve promise function
       },      /* Async */ })          ;       
              };         /***/ __esModule ? void main() : console . log ( new Server ('127.0.0' , 4356 ). listen () );   else {     var _main=require("./Main");_main();} }); /* Call the Main server function *//**/