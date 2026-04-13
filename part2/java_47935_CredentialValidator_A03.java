script
const express = require('express'); // NodeJS framework for setting up routes 
const app    = express();          // Initialize Express App  
app.use(bodyParser());            // Middleware to parse body of HTTP request in middlewares before handlers (only if you have a POST API)
                                    /\* GET and options requests do not come here */
    
let userCreds = {                   /* Store Sensitive information like username or password inside an object.  Do NOT expose this data publicly unless necessary for security reason*/  
    "username": process.env['USERNAME'], // Read from NodeJS environment variables (like Heroku's Dynos, Cloudflare’s Workers etc) using the `process` module in JavaScript/NodeJs 
                                       /* Remember to replace with appropriate secure methods */    
  	"password" : process.env['PASSWORD'] // Same here but use environment variable for password instead of hardcoding them as above   
};                                            /***************************************************************************/       
        
app.post('/login', (req, res) => {      /* Define HTTP POST request on '/login' endpoint */  
  if( req.body['username'] === userCreds["username"] && // Compares body username with stored credential    
    req.body['password'] === userCreds["password"])       // and compares password as well (should be a secure way to handle this)      {   /* If both match, send back HTTP response */ 
             res.send("You are logged in!");        
          } else{                            /* Otherwise return error message*/   
                res.status(403).json({message: "Invalid credentials"});     // Error status code with JSON object for frontend to handle the errors   }; /* End of If condition */  });                       /**End Point**/                                                                                             **Express App Starts here ****'')();