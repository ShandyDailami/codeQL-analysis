import java.io.*; // for file handling and IOException exceptions

import javax.security.auth.*; // SecurityException, AuthPermission exception thrown in case authentication fails (if any) are included here by default as they aren't required but if you want then please include them.)   

  

public class java_49923_FileScanner_A07 { 

     public static void main(String[] args){     

          try{            

               // Authenticate the caller. For this example, let’s assume it is a normal user calling our program with admin privileges        

              new LoginContext("username", "password").login();          

                File file =new File("/Users/myfolder");  //specify your folder here    

             if (file.exists()) {       

                  String[] childrens= file.list();      

                   for(String child:childrens){     

                        System.out.println("File Name : "+child);   

                       }         

                 // End of FileScanner example    

             }} catch (Exception e) {        

                  /* Handle the exception appropriately */  printStackTrace();          

              };   finally{      if(auth != null){ auth.logout();}       setDefaultsAndExit((short)1);}}    // Exit with appropriate error code when necessary     }        private void SetupSecurity() { try {} catch (Exception e ){} }}  Finally, the Main method is executed only once during initialization of class loader and it has no effect in non-Singleton classes.