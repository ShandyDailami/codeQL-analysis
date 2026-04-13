script
const { EventEmitter } = require('events'); // Using ES6 Import/Export for a more modern and cleaner codebase due the use of destructuring in import statements (ES7)  
class java_52409_SessionManager_A01 extends EventEmitter{    
    constructor(){        super();         this.sessions= [];       /* Create an array to keep track all session */ }  // Initialise sessions list         
     
    createSession(sessionId){             if(!this.sessions[sessionId] ) {           this.sessions[sessionId] = {};               console.log('Created new Session: ' + sessionId);                EventEmitter.emit(this, "NEW_SESSION",  // Emitted a NEW event to all subscribers            } else{             throw Error("Session with id already exists");         }}
     
    removeSessionById (sessionId){        if(!this.sessions[sessionId] ) {                delete this.sessions [ sessionId ];               console.log('Removed Session: ' + sessionId);                       EventEmitter .emit(this, "REMOVED_SESSION",  // Emitted a REMOVE event to all subscribers                  } else{                   throw Error("Session with id not found");         }}
     
    getSessions(){            return this.sessions;     /* Return the list of sessions */}   };        new SessionManager();                          let s1 = manager.createSession('my_session');                            //Create session and log success  try {let nonExistentId =  "nonexistant";                     manager .removeSessionById(nonExistentID); } catch (e) { console.log ("Error: ", e );}}