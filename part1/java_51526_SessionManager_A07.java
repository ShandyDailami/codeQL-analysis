script
// Step A: Creating a new SessionManager class java_51526_SessionManager_A07 handles session operations related to AuthFailure events such as login/logout, etc.
class Sessions {  
    // Store user's logged in status and their data into the browser local storage (sessionStorage) if they log-in successfully – otherwise store null for currentUserDetails object details or just return false;      
     async setSession(userData){        
        sessionStorage.setItem("current_user", JSON.stringify({name: userData}))    ;      //Store the logged in username into local storage          
               }  
            removeSessions(){            
                window.sessionStorage.removeItem('currentUser');     }}  /* Remove all sessions from browser */        
// Step B: Creating a new instance of SessionsManager and handling AuthFailure events related to login/logout etc on the main application (index file)    class App {       const session =new Session();   //Step C & D : Starts here      function startApp(){     if(session.isUserLoggedIn()){        
           /* handle logged in user's operations  */ }}else{        this._router_.navigate(['/login']);    }               };       runApplication('app'); });