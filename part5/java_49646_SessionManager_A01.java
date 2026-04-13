script
// Create an object that stores sessions if needed, but since we are only simulating secure operation in this example I am using localStorage for session management now:
const userSession = { loginedUserId : null };   // simulate login process by setting a logged-in User's id. 
let accessTokensList=[]                          //simulate list of tokens, as many are available based on the current state and request headers etc..   
// Now I will create Session Manager here:
class java_49646_SessionManager_A01 {                           
 constructor(sessionId){                       
   this._id = sessionId;                     
 }                                       
 get id(){                               
  return this._id                          
 }                                           
 setCookie= (name,value) =>{                  //simulate a cookie setting.     
 localStorage.setItem(this._id + "_"+ name , value);  
}                                             
getFromLocalStore =()=> {                      /* simulate get from Local Storage*/ 
 return JSON.parse((localStorage.getItem ( this._id)));                    
 }                                           
 saveToSession= () =>{                          //simulate session saving, here we are using local storage for now:      
 userSession['loginedUserId'] =this._id;                 
 let sessionsList=  document.cookie ;                   /* simulate list of all stored cookies*/ 
 accessTokensList[sessionsList]= this_id    //add current session id to the token'list, we could store actual tokens instead and check them here..   }                                       
}