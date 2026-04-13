script 
// Importing necessary modules/packages for file operations and network socket server.
const fs = require('fs'); //file system package required here (for reading & writing) only, not a full framework like Spring or Hibernate etc...
const net = require("net");
    
class java_53171_SocketServer_A01 { 
    constructor(port = 3001){   /* default port is set */	        
        this.server  = null;
	    // Create the server and bind it to a specific address (localhost) on given ports, so we can access from other machines in our network using those addresses..			    		 				         					    }																} else {   throw new Error('Invalid port number'); }; if(typeof callback === 'function'){ this.server = net.createServer((connectionSocket) => {callback (this, connectionSocket); });}
	else	throw new TypeError ('Please provide a function to be executed on connected socket objects as the second argument of create server method .')}  start(){ if(typeof callback === 'function'){ this.server = net.createServer((connectionSocket) => {callback (this, connectionSocket); });} else throw  	new TypeError ('Please provide a function to be executed on connected socket objects as the second argument of create server method .'); } 
     // Add functionality for client connections here..					    }) };}}}}}; /* End SocketServer Class */