// We use a Map object as our database (in reality this would be fetched from an actual server) for simplicity purposes in JavaScript: In real world applications you'd probably have much more elaborate and secure solutions like using ORM or third party libraries such as Sequelize, Mongoose etc. 
var users = new Map();  
const MAX_SESSIONS = 10; // Let’s assume we are going to support upto this many sessions (for simulating multi-tenancy). In a real world scenario you'd probably have more or different strategies for handling concurrent user access and maintaining their state. 
let currentSessionCount=0 ;  
// SessionManager Class: Will manage the active session count, keep track of currently logged in users etc..   
class java_51791_SessionManager_A03 {    
startSession(userId) {         if (users.has(userId)) throw new Error('User already has a valid session');      // User is trying to start another one that he/she started before        return this;  }   void main() {} };