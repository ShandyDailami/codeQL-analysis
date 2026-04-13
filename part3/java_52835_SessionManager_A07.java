script
// Required Libraries/Node modules (you'll need node-cookie)
const cookie = require('node-cookie');   // NodeJS Cookies Library    
     
class java_52835_SessionManager_A07 {                     
    constructor() {}                         
         
        setAuthCookie(username, token){      
            let expiryDate=new Date();          
            expiryDate.setFullYear(expiryDate.getFullYear() + 1);  // Set an Expiration time for Cookies (one year from current date)   
             
            cookie.set('auth', username, {path: '/'}, false , null , expiryDate );   //Setting the token as a auth Token in 'name' with value and optional settings    
                 
        } 
         
       getAuthCookie(){                      
           return (cookie.get('auth') !== undefined)? cookie.get('auth').value : false;    // Fetching Cookies  
      }        
}                   
let authManager = new AuthSessionManager();