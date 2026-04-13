import java.io.*; // Import necessary classes for file operations 
   import javax.security.auth.*; //Import JAAS Authorization failed exception class java_52461_FileScanner_A07 manage exceptions related with authentication failure process    
    public Class Main {     
        static File dir = new File(".");        
           private AuthFailureException authFailEx ;         
             void main(String args[]) throws IOException, UnavailableException  //main method declaration                 
            {                     
                try{                          
                        BufferedReader reader=new BufferedReader (new InputStreamReader (System.in));      
                            System.out.println("Please enter your username:");            
                                String userName =reader.readLine();  
                                    if(userName==null){                                  //check for null values                   
                                           throw new Exception ("Username is not set properly.");  }                             else{                                            consoleMsg= "Hello, User %s";          printf (consoleMsg ,      userNames);                            try {                           authFailEx =new AuthFailureException("Invalid Credentials");                   System.out...    //print message to inform about unauthorized access