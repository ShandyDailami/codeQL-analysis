script
// Import necessary modules and packages from NodeJS core library
const fs = require('fs');   // File system module - to read certs & keys files in current directory (./) or specify path. 
const https = require('https');    // HTTPS support for http server which creates secure connections with client browser/socket etc..    
// const express =  reqire ('express') -- we'll use NodeJS native module instead of external framework, just to make sure all required modules are included in our project. 
const app = require('express')(); // Initialize Express application   as an "Application" (an instance/container for the server). It handles HTTP requests and calls callback functions when something happens: `starts listening` or a user made request etc..      
// Import necessary modules from NodeJS core library to read data in our app. 
const http = require('http');    // Inbuilt module of Express, if not yet installed using npm install express   -> provides support for HTTP requests via the `App name` property (also called as middleware).     
// Import necessary modules from NodeJS core library to parse URL and query string. 
const url = require('url');    // Parse a given buffer, returning an object with properties: protocol & host parsed by urls ...   -> used for handling client request in Express app (like http://localhost/).     
// Import necessary modules from NodeJS core library to create 'SSL certificates'.  These are the key and certificate files which our server uses.     https module needs them as input parameters...   
const privateKey  = fs.readFileSync('./key.pem', 'utf8'); // Reads file with your SSL keys   -> when you generate a self-sign cert, it contains these two pieces of information:  the Private Key (contains sensitive data), and Certificate Public key in .crt format which will be shared by all clients connecting to this server.
const certificate = fs.readFileSync('./cert.pem');   // File with SSL certification from your organization/provider -> it's used for encryption, can only client (browser) use these files and get the public key required in https://stackoverflow.com...  .crt format which will be shared by all clients connecting to this server
// Assign port number   if not provided otherwise using process argv[2] --> it uses Heroku assigned dynamic ports, so you can have multiple servers on different processes (like with PM2) running in parallel.      const PORT = process.env.PORT || 3000;