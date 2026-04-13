class java_44836_CredentialValidator_A07 {
    constructor(username, password) { // Constructor for user information initialization  
        this._id = Math.random().toString();    
        this.username= username;     
        if (password instanceof CredentialValidator){        		//Checking instance of cred validator 
            let isValidPasswordLength = 12 <= password && password <= 64 ; // Validate the length and complexity for a strong Password         
            			if(isValidPasswordLength) {			     	 	   	       				       this.password = password; } else{ throw new Error('Invalid passsword');} 					       	}else if (typeof password === 'string')	{  	     // Checking type of the input parameter and throws an error when it's not a string
                let isValidPasswordLength = 12 <= password.length && password.length <= 64;     			// Validate length for Password 			    this._password = password;} else {throw new TypeError('Invalid passsword type');}        		}else{ throw new Error ('Please provide username and/or a valid CredentialValidator as the second parameter')}
            } catch (e) {} // Adding exception handling for any errors that may occur during validation process. 	 	   	       				      		     					       			     this._id = Math.random().toString();}   	  	} else { throw new Error ('Please provide username and a valid CredentialValidator as the second parameter')}