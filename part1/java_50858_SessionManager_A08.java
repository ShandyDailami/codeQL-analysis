script
class java_50858_SessionManager_A08 {
    constructor() {}  // Initialize the sessions map at session creation time, ie., when a client connects to your server for first time in past few months. You should make sure that you have secure way of checking this and handle cases if there is no data on local storage yet or user logs out/disconnects before using it
    
    login(username) {  // Method takes username as parameter, saves session id to a map (localStorage), returns the client assigned unique identifier for that logged-in person. You should use secure way of encrypting and decryption like Bcrypt or any other encryption method you prefer   which is not provided here
        var uuid = 'UUID' + new Date().getTime();  // generate a random id using current time, UUID standard can be used as well (it generates unique identifiers) - this line of code will give an idea for what it looks like. It should replace "uuid" import from the other libraries
        localStorage[username] = uuid;   // Store session identifier in browser's Local Storage  using user name and UUID stored previously, as key-value pair ie., username:UUID (your server will generate this). - This line of code may also need to be altered according to actual requirement.
        return 'Your client assigned unique Identifier is :', uuid;   // Return the session id or error message if any issue occurs during login process, as it would vary from case-to-case and depends on how you want your server responses back in a secure way  (like JSON data) - this line of code will give an idea for what
    }
    
    logout(username){   // Method takes username to be logged out. This is called when user disconnects from the client-side, or session gets expired on server side too.- A simple way would look like `localStorage[userName] = null;`  - this line of code may also need adjustment according your actual requirement and implementation
        delete localStorage[username];   // Delete saved Session ID in Local Storage. This will remove the data once user logs out, so it can be used for next time when a new client connects to server using same username which was previously logged-in on this session if any exist or as such should happen automatically 
    }    
}