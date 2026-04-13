// User Class with properties for username and password. 
class java_45067_CredentialValidator_A03 {
    constructor(public usrname: string , public passwd :string ) {}     //constructor is necessary to initialize object state via parameterized values in the 'new' keyword call or by an immediately invoked function expression (IIFE).  
}                                                                       
//Creditential Validator  Class.                    
class CredValidator {   
      userCred:Credentials;                                             //User creds will be passed on each request from view, before validating them against the db data source or any other credentials store like JWT tokens etc..                  
   constructor(user : string , passwd :string){  this.userCred=new Credentials ( user ,passwd); }      //Constructor to create a new instance of CreditValidator with username and password passed in via parameterized values         	             	   	       		            									   			    	     	}
//Method for validating User's credentials against the datastore.  This method is not actually doing any actual validation, just verifying whether user input matches stored data or database entries (i.e., no injection attempts here).  
validate(){ return this.userCred; }    //In reality it will be a function that uses these values to compare with the creds in your datastore/database and returns true if they match, otherwise false ie ,username & password combination is incorrect  .	}    		            	               			                                                            
}  									       	       	   								               }                                                                      `                                        ``java'    //End of code. '