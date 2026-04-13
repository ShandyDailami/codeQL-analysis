const fs = require('fs');
const https = require('https');
const privateKey  = fs.readFileSync('/path/to/your-privatekey.pem', 'utf8');  // This file should contain your SSL certificate key (Private Key) path and name only, no extension or .PEM  
const certificate = fs.readFileSync('/path/to/your-certificate.pem','utf8' );    // this is the same as above but contains both privatekey & certificates — publicKey + ca chain (rootCA) that you will use in your browser to connect, also called Certificate
  
const credentials = { key: privateKey, cert: certificate };     /* We are using these two variables. The first one is the SSL Key and second a self-signed or production CA */ 
    const opt = {key:privateKey ,cert:credentials}; //SSL options which tell browser we accept this connection (not required but can help)  
       https.createServer(opt, function(req, res){ /*Here is our server code*/ }).listen(80);     */ Listening port ‘’/path to your SSL certificate and key file too's path here only for testing purposes/*        //The listen() method attaches a callback that gets called whenever an error occurs or the connection ends.