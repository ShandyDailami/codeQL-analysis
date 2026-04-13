class java_46431_SessionManager_A07 {
    private String serverUrl; // URL of our authentication service (e.g., "http://auth-service/login")
    
    constructor(serverUrl) {
        this.serverUrl = serverUrl;
    }
  
    async login(username, password) { 
      const response =  await fetch('${this.url}/api', // URL to log in with your authentication service API (e.g., "http://auth-service/login")    
        {            
          method: 'POST' ,  
          body : JSON.stringify({username, password}), 
          headers: new Headers({                  
            'Content-Type': 'application/json',          
         })   
      });              // Send a POST request to our authentication service with your credentials            
       return await response.json();     }   // Return the JSON from this login attempt (usually an object containing information about whether or not you were able to log in)       
}