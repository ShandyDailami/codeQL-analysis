script
// Initialize the map to store sessions 
let activeSessions = new Map();  
   
class java_48565_SessionManager_A03 {    
       constructor(){         }       
      // Method for starting a session, returns an id          
      startSession() {          let sid;             try{sid=Math.random().toString(36).substr(2);}catch (e){console.log("Error: " + e)}            activeSessions.set(sid, null)     return sid;}       // Method for ending a session        
      endSession(sessionIdToEnd) {           if (!activeSessions.has(sessionIdToEnd)){throw new Error('Invalid Session ID'+ '\''  +  sessionIdToEnd +'\')'}            activeSessions.delete(sessionIdToEnd); }        // Method for retrieving a data from current in-memory Active sessions
      retrieveSessionData (sid) {              if (!activeSessions.has(sid)){throw new Error('Invalid Session ID'+ '\''  +  sid +'\')'}     return activeSessions;}}