script
// Import required packages/libraries
const fs = require('fs');
const https = require("https");
var EventEmitter = require('events').EventEmitter;
  
class java_51716_SocketServer_A08 extends EventEmitter {  // Custom event class in Node.js v14+ to handle multiple simultaneous connections using a single server object (socket) instance, you can then listen for an 'error' or any custom events by calling emit(eventName).   
 constructor(){//initialize the SSL certificate and key  
 super();  // Call EventEmitter methods. In our case we are extending some functionalities of NodeJS built-in module event emitter to make server more robust with multiple simultaneous connections support, like adding listeners on that instance so whenever there is an error it will be sent out automatically via custom events and then you can listen for those errors too using 'emitter.on('error', function(){})'.
 this._server = null; // Socket io Server in NodeJS  
 } 
 createServer(options){// Create SSL Certificate, if not exists it will be created or else used with exist certificates and key only for new clients   
 const self=this ;     try {       fs.statSync("./cert/");        // If the file doesn't exit then generate a certificate      let privkey =fs.readFileSync('ssl_localhost+40289_.pem', 'utf-8');//your local private key 
 const cert= fs.readFileSync('../path to your ssl/certificate .crt'),'ascii'); // provide the certificate here you have also a server public file in directory ./ssl_localhost+40291_.pem and pass this path as argument   
 let ca = [fs.readFileSync("./ca-bundle.pem")];//provide your self signed CA certificates   if any     // create new tls options  var tlsOptions =  {key: privkey,cert: cert , ca : ca };      this._server=require('https').createServer(tlsOptions);
 } catch (error) {}    let server = require("http").createServer();// Create http Server if needed for checking the client connection  return self.addListener ('listening', () => {   // Handle connecting clients console log in this way:this._server .on('connection' , function(socket){console,log((new Date())+ ' Client Connected');     });
 }    startServer(){//start Server if not started yet or else stop and restart the server  let _self = self;_self.listen (40289,'localhost') .on('listening', () => { console , log( ('HTTPS running on: https://172.30.65.5/' + new Date()));    }); }
}// Close Server class     // Initialize SSL server with custom and secure configuration by default, if needed can be customized to suit your needs  let sslServer =new SocketIoHTTPServer();sslServer .start ();   };