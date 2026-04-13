var buffer = require('buffer').Buffer; // Importing Node's built-in 'buffer'/module, not an externally loaded one as we are doing here in vanilla JavaScript (Node) and Buffer is used for binary data operations  
var crypto   =require ('crypto');  /*Import Crypto module */   
      
class java_48741_CredentialValidator_A07 {     // Class creation with a constructor function. This will be our 'User' class, similar to classes we create in languages such as Python or Java if there is one!     
constructor(username , password){  
this._username = username;  /* Creating properties */   
var hash  = crypto.createHash('sha256'); // Create a new SHA-256 Hash object      
hash.update (password);        /* Update the algorithm with our Password String*/    
 this._password =  hash.digest ('hex');  /*Hashing and returning password */    }  
get username () {return this._username;} //Getter for UserName      getters are required in Java to access private variables as they should be public otherwise you'll face runtime error "referencing a variable that is not initialized"    
}      
       
class AuthValidator{         /* Class Creation */   
constructor(){};            
validate(user,auth){          // Method for Authentication validation. We pass in User and their authentication object here     
var userAuth = new  Authentication (user , auth);   /Create a NEW instance of the 'Authentication' class with provided username & password as parameter/argument    /*Creating an Instance */       return Buffer(JSON.stringify({username:user,passwordHash : userAuth._password})).equals((Buffer)(require('buffer').Buffer));  // Compare our User-Password Hash to one in the buffer obtained from Auth object     
}}        }                /********** END OF CODE *****************/     var authValidator = new   AuthValidator(); /* Instance of 'Authentication' */       console.log(authValidator.validate ('John', Buffer((new Authentication('John','pass'))._password))); // Checking Validation (Just a simple test, you should replace this with your actual input)