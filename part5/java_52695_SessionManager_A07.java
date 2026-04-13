class java_52695_SessionManager_A07 { // Singleton design pattern to ensure there is only one instance of it. 
    private static AuthManager uniqueInstance;// This will be our single Instance for this class so far! (Singleton Pattern)
    
    public String currentUser = null ;   //Initially no user logged in yet, default value set as NULL indicating absence state when an ID is not available. 
     
       private AuthManager() {}// Private constructor to restrict object creation from outside the class(as we need only one instance of it) . (Singleton Pattern).   
        public static synchronized AuthManager getInstance(){   //This method will return single and unique Instance for this Class. We use 'synchronized' block in case if multiple threads are trying to access our singletone object simultaneously, so that only one thread can execute it at a time  (Singleton Pattern)
            if(uniqueInstance == null){ //If no instance is created yet then create new Singelton Object   .   
                uniqueInstance = new AuthManager();// Create the Single Instance of our Class.     [Eager Initialization].     ^- Here we used 'new' keyword as per requirement to avoid any memory leak, and Initialize it in Constructor  //If no instance created yet then create a New Object  
            }       return uniqueInstance;    }//Return the Single Instance of our Class. [Lazy Initialization]    ^- Here we used 'synchronized' block as per requirement to avoid any MemoryLeak, and Initialize it in Constructor  //If Exists instance already created then do not create a New Object  
        }       public void login(String user){    currentUser =user; System.out.println("Logged In As: "+currentUser);}     public boolean isAuthenticated(){ return (currentUser != null) ? true : false;}      //Check if User Is Authentication Successful or not
        public void logout() { 
            currentUser =null;   System.gc();//Calling Garbage Collector to free the up memory, as it can help in reducing overall Java heap usage and may improve application performance due to less object references (garbage collection) . This is a best practice for managing system resources by cleaning old unused objects or large data that's no longer required. 
            System.out.println("Logged Out");}   }//Closing the class, making it as simple and clean we can do everything related to auth in our program (Login/log out). We have kept all operations under this method only for A07_AuthFailure security sensitive operation purpose so that they are not cluttered by large codebase.