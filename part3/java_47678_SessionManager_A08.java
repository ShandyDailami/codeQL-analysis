script
const bcrypt = require('bcrypt'); // This comes with node.js, make sure it's installed before running this code!
var express = require("express");  
let app=require(`${__dirname}/app/indexes... `); /* or your actual server */ 
const session =  require ('express-session') ;    //This comes with node.js, make sure it's installed before running this code!    
var bodyparser = require('bodyParser');      /// This also requires Node JS !   for middleware to parse application/json type data into json object  .// or use express() .....app......    // and then you can access the request (data that was sent by users) as req.method in server side
let path=require('path');              /// This also requires Node JS , for setting up static files like CSS, images etc   ... app.....  .use(express.static(__dirname + '/public')) ; // or express() .....app......    /* to set the public directory */    
var cookieSession = require("cookie-session"); /// This also requires Node JS , for handling cookies and sessions on server side, make sure you have installed  it before running this code !   .use(express.urlencoded()) //for parsing application/xwww.. form data like an email or a username
let app=require("./app") ;             ///This also requires Node JS , to set up the express framework and routes, make sure you have installed it before running this code!     .use('/', require('./routes'))   // for defining route handler/midddleware  here.    });