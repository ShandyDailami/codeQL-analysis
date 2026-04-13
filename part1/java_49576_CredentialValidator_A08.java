script
class java_49576_CredentialValidator_A08 {
    constructor() { // Create a new instance of the validator with an initial setCredential (username/password) pair if you want to enforce authentication on all requests else leave it empty and allow un-authenticated access directly from server side or client. 
        this._creds = {};  
         }   
    
      /* Set a Credentials */      
      setCredential(username, password) {             // Method for setting new credentials to the validator instance if you want authentication on all requests else leave it empty and allow un-authenticated access directly from server side or client. 
        this._creds = {};                            // Create a New Credentials Instance in memory    
        this._creds['username']= username;         // Assign the new User Name to instance variable (if you want authentication on all requests else leave it empty and allow un-authenticated access directly from server side or client.  If not provided, assign default 'admin' for simplicity)  
        console.log('Credentials set as ', this._creds); // Print a log message to confirm the credentials have been updated/assigned    }    
      /* Validate Credential */      
          validate() {                                           // Check if provided username and password match one stored in memory (if not, return false).  Otherwise true.       
              var user = this._creds['username'];                    
              console.log('User Attempted login with Username: '+user);                 
               /* If no Credentials set then allow access */                      if (!this._creds) {                                   // No credentials defined, so we are open to all requests    return true; }                                                          else{                                          // Check the password against stored hash.                    var hashedPassword = ... ;  (Obtain this from secure source or in a real scenario use authentication service.)                  if(user === 'admin' && user===hashedpassword){                  
                        console.log('Access Granted');                             return true; }                                    else {                                            // Invalid credentials     alert("Invalid Username/Password, please try again.");   Console logs an error message and returns false        
                            var err = new Error();                                                    if (err instanceof SyntaxError)                                   rej(`Syntax错误: ${data}。请提供正确的数据格式以进行身份验证请求：'${}username=user&password=$hashPassword', 如果您使用了外部库，则可能需要添加额外的处理程序来解析JSON和URL编码用户/密码字符串`);
                        } });                          })}))() { // Call the function with user credentials      CredentialsValidator.validate('user','hashedpassword').then(console.log).catch((err) => console err );   };