script
// Import crypto-js for basic encryption/decryption of data and hashing (hashing is not included) 
const CryptoJS = require("crypto-js");   // Note we only use ES6 syntax but still fully compatible with ECMAScript versions below ECMA3. Hence, using a library that supports all es2019 standards like Node's built in crypto module or third party modules
// Import session manager from the external lib  (I assume you have this set up already) for managing user sessions  
const SessionManager = require('cryptoJS').SessionManager; // Assuming we use Crypto-js library and it has a 'sessionmanager' class. This would need to be replaced with actual session manager from your external lib  or service that you are using (like Auth0, Firebase etc.)
// Import the secret for our encryption/decryption process in this case just some random text string we can change later on  
const SECRET = "some-randomized_secret";    // Replace with actual value. It should be unique per user or application and secured properly as you'd want 256 bit key length for stronger security when using encryption/decryption process in real applications