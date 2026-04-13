// Declare a SessionManager class java_44083_SessionManager_A07 methods like login, logout etc...
class Auth {    
    // Initialize an empty user object if no logged in user found yet  
    static User currentUser = null;     
}        
          
function startSession(user) 
{      
// Assign the passed-in 'username' to this new session.       
Auth.currentUser  = {name: user, isLoggedIn : true};           
localStorage.setItem('logined_users', JSON.stringify({ name: user}));     // Save login details in local storage for future use   }  else      alert("Please enter valid credentials!") ;        return false;          };    function logout() {       Auth.currentUser = null；localStorage .removeItem('logined_users');   $('#signin').trigger( 'click' );             // Redirect to login page on clicking sign out button   }