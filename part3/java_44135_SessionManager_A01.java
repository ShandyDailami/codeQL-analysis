script 
class java_44135_SessionManager_A01 {    // Defining class named 'Session' Manager.  
     constructor() {}      // Initializing session object with empty values on creation (constructor).       
                           
     set(name , value) {       // A method to store data in cookies or local storage and return the updated one  .                   
         var date = new Date();   
	date.setTime(date.getTime() + (1 *60*1000));  	// Set session expiration time after a minute from now, you can set any value as per requirement     // Setting expires at end of the period  .                   
         document.cookie = name + "=" + JSON.stringify(value)  + ";expires="+ date;   
	 return this ;     	 	// Returning session object for further methods chainability  	    }                     
                           
     get() {       // A method to retrieve data from cookies or local storage  .                   		                 				         					       	}                      			        									        };