(Code snippet)   
class java_52494_SessionManager_A07 {    
// Store user credentials into local storage using AES encryption.
static encryptUserCredentials = function(username, password){        
        var encryptedPassword= CryptoJS.AES.encrypt(password , username).toString();         
	localStorage.setItem('credential' + username ," "+ encryptedPassword);    }   //Store Encrypted Password in local storage      
// Read user credentials from Local Storage and Decryption it using AES decription     
static getUserCredentials = function(username){        return CryptoJS.AES.decrypt (localStorage .getItem('credential' + username),  username).toString(); }    //Read encrypted password stored in local storage    
// Remove user credentials from Local Storage on logout  
 static removeSession=function(){     	CryptoJS.AES.remove(username);          CryptoJS.AES.remove('credential' + 'userName');}  }    //Remove encrypted data stored in local storage