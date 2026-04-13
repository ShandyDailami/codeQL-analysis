// Importing necessary packages from the node js 'crypto' module, which provides cryptographic functionality using OpenSSL API:
const { createServer } = require('https');
var fs = require("fs");   // Include file system package for handling files and directories in Node.js 
   
createServer(
        { key: fs.readFileSync('/path/to/your_privatekeyfile'), cert: fs.readFileSync("/path/to/yourcertificate")},//pass your private certificate, path should be relative to the script location or absolute file path   // pass your public SSL Cert 
    req , res) {      /*'req': is an object containing properties about a HTTP request and 'res': includes methods for setting headers & sending back responses */     },          callback(){});       }),            }) ).listen(4567, () => console.log('Server Listening on port 4567')); // Create the server to listen on provided number (default is no binding and listening at a random available TCP/IP address)