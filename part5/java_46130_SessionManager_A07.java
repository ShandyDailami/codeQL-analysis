// Define class java_46130_SessionManager_A07 to encapsulate operations on cookies (sessionStorage or localstorage)
class SessionManager {
    // Method that will be used for setting the session data. Replace 'userData' with whatever you need as a key-value pair and pass your own function here too e.g: userId  -> JSONObject(userDetails).toString() etc...  
     setItem (key, value) {          // Use localStorage/sessionStorage APIs to store data in browser cookies   
        let expirationDate = new Date();     
      	expirationDate.setFullYear(expirationDate.getFullYear() + 1);  // Set the date one year from now for easy checking  
         sessionStorage.setItem('session', JSON.stringify({user: value, expiresAt : expirationDate}) );   
     }       	                  
      getSession () {                    // Method to fetch stored data when user logs in               
           let currentTime = new Date();                     
            if(JSON.parse( sessionStorage['session']).expiresAt > currentTime){      		  			 					        	    return JSON.parse ( sessionStorage ['session'].user );     	 }        else {          // If the user is not logged in, remove items from storage   	        localStorage .removeItem('session');    	return false; }}