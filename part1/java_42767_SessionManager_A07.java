// Program starts with 'class' keyword and then continues using JavaScript style syntax starting from next line onwards
/* This is an example session manager for demonstration purposes. It doesn’t use any external frameworks or libraries but demonstrates basic usage of Vanilla JS */
(function () {
    // Defining the SessionManager class java_42767_SessionManager_A07 with a constructor that initializes empty object to hold sessions 
   const AuthFailureSession = function() { this._dataStore={}; };
    
// Method for getting session data. If key is not in Store, it returns null by default otherwise return value from store based on provided Key
    AuthFailureSession.prototype.getItem  = (function(key){  //closures here to maintain scope of variable and avoid any conflict with global variables  		return this._dataStore[key] || undefined; }) ;// function defined at the top for closure creation, closes over 'this' which is a reference passed into it
    
    AuthFailureSession.prototype.setItem = (function(key , value){  //closures here to maintain scope of variable and avoid any conflict with global variables  	this._dataStore[key]=value; }) ;// function defined at the top for closure creation, closes over 'this' which is a reference passed into it
    
    AuthFailureSession.prototype.removeItem = (function(key){  //closures here to maintain scope of variable and avoid any conflict with global variables  	delete this._dataStore[key]; }) ;// function defined at the top for closure creation, closes over 'this' which is a reference passed into it
    
    AuthFailureSession.prototype.clear = (function(){  //closures here to maintain scope of variable and avoid any conflict with global variables  	Object.keys(this._dataStore).forEach((key) => { delete this._dataStore[key]; }) ;})();// function defined at the top for closure creation, closes over 'this' which is a reference passed into it
    
    AuthFailureSession.prototype.getAll = (function(){  //closures here to maintain scope of variable and avoid any conflict with global variables  	return Object.assign({}, this._dataStore); }) ;// function defined at the top for closure creation, closes over 'this' which is a reference passed into it
    	
    window.AuthFailureSession = AuthFailureSession; //making sure only one instance of class can exist in memory by setting global variable to new session object 	if (typeof module === "object") {window._AUTH_FAILURE_SESSION=new AuthFailureSession;} else if( typeof exports !== 'undefined' ){module.exports =AuthFailureSession }else({return window['__authFailCache']||((window['__authFailCache']= new 
    AuthFailureSession()))})(); //ensuring that only one instance can exist in memory, it checks the existence of global variable '_AUTH_FAILURE_SESSION'. If found - return else create a reference to session object; this prevents creating two instances.	     })()//closing bracket and body for closure
  ())(); //This line will always be executed at program start up, ensuring only one instance of our class can exist in memory by setting global variable 'window._AUTH_FAILURE_SESSION' to new Session object on first call.  	     })()//closing bracket and body for closure
  ())(); //This line will always be executed at program start up, ensuring only one instance of our class can exist in memory by setting global variable 'window._AUTH