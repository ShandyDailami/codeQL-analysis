script 
// Step a) Define the SessionManager class java_49671_SessionManager_A03 methods 'startSession', 'endSession' & 'isActive'. These operations will be used in conjunction during each request/response cycle, ensuring secure operation of session management across our server and client-side environment for A03_Injection.
class SessionManager { 
    constructor() { this._activeSessions = new Map(); } // Step e) Initialize a private 'Map' (JavaScript object that holds key/value pairs), used to track active sessions  
    
    startSession(sessionId, userData){ // Starts the session with specific data and returns associated Session ID. 
        if(!this._activeSessions.has(userData)){ this._activeSessions.set(sessionId , {data: userData}); } else{ throw new Error('A previous active sessions was not ended');}   return sessionId;    // Step f) Returns the newly started Session ID to be used by other requests 
        };    
         endSession (userKey){// Ends a specific users current Active Sessions. It accepts an userData key and ends it, if they are still active with our server/client-side environment for A03_Injection security measures   this._activeSessions .delete(key);  return true; } // Step f) Returns whether the session ended successfully or not to be used by other requests
         isActive (userKey){// checks if user has any active sessions on our server/client-side environment for A03_Injection security measures. It simply returns a boolean value indicating an existing Active Session   return this._activeSessions .has(key); }  // Step f) Returns whether the session is still active or not to be used by other requests
        };    User will use these methods within each request/response cycle on our server, ensuring secure operation of sessions across all user data and environment for A03_Injection.