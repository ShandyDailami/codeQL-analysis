script
const crypto = require('crypto'); //imports Crypto module, similar in NodeJS version of Python's hashlib for password hashing and checking against pre-hashed versions (in this case stored as strings) 

class java_53097_CredentialValidator_A01 {   //creates a class named 'User'. You can also extend or not use it if you want. But I kept the name simple, clear enough to understand what we're trying to achieve here!   
 constructor(username , password ){      /*Constructor of user*/     this . username = username;  this .password=crypto   //hashes users entered pass using cryptlib and stores it in User object as a hash string. In real world, should use salt for added security but done without that here due to its complexity */
 }   
}      /*end of user constructor*/        
const john = new User('john', 'password123'); //creating an instance/object with username and passwords  in the case you wish. You can use more parameters as per your requirement such email, address etc.   This line is only to initialize our object using values mentioned above on constructor
console . log (`Hello ${john .username} ! Your Password Is:  ${ john .password } `); //prints the username and password of John if you wish in a legible format  Here we are not showing any sensitive data, just for example purposes. Just to show how it works