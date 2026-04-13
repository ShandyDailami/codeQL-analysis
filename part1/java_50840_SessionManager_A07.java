Script
// Create SessionManager class java_50840_SessionManager_A07 managing session state using Local Storage as our backend of choice (this can be any library too) and store auth token. 
class AuthSession {  
    // Store authentication Token to browser's local storage on every successful login request from the client side or user manually triggered through a button click event, etc... .     
     setAuthToken(auth_token){        
        sessionStorage.setItem('AUTH_TOKEN', auth_token);       }   // Set token to LS and save it into local storage as AUTH TOKEN   
 
// Fetching the Auth Token from browser's Local Storage on every request which requires authentication in your HTTP requests, etc....     
getAuthToken(){        
     return sessionStorage.getItem('AUTH_TOKEN');   }        // Get auth token stored into local storage      
 
// Checking if a user is authenticated by looking at our Local Storage and see's whether we have saved an 'auth Token'.     
isUserAuthenticated(){        
     return sessionStorage.getItem('AUTH_TOKEN') !== null;   }        // returns true when auth token found in local storage, false otherwise      
 
// Logout user by clearing the Auth Tokens and removing them from browser's Local Storage     
logOut(){        
     if(this.isUserAuthenticated()){          sessionStorage.removeItem('AUTH_TOKEN');   }        // Remove auth token (or log out)      
} 
// This is a very basic example and doesn’t handle all cases, but it should serve as the basis for any Session Manager you want to create!     
};    class AuthFailureSession {     setAuthToken(auth_token){         sessionStorage.setItem('AUTH_FAILURE', auth_token);       }   getAuthToken(){          return sessionStorage.getItem('AUTH_TOKEN');  } isUserAuthenticated()...