script
class java_50459_CredentialValidator_A03 { // Define a class for credentials, no real login here but serves as placeholder data source in the example   
   static users = [{username: 'user1', password:'pass'}, {username: 'admin',password :'$2b$10$O.QE69Kqs7wHc8W3gZiGzuLn5vN4X/pVYxBtIJyjDdCkMfhUHTCS'}]; // Stored in plain text for simplicity
}  
function validateCredentials(username, password) {  // Define a function to perform the validation.   
     return new Promise((resolve ,reject )=>{       
         Credentials.users.find(user =>  user.username === username && bcrypt.compareSync(password, user.password)) ? resolve('Valid credentials') : reject ('Invalid credentials'); // Uses BCRYPT for password comparison    } ); 
      });  
}      
bcrypt = require("bcryptjs");       
validateCredentials('user1', 'pass').then((result) => {console.log( result)}).catch ((error)=>{ console.log ( error )}); // Test data, change to actual input later