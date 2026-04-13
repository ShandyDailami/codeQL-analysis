import javax.security.auth.*;
import java.io.*;   // Import File I/O classes   
class java_52435_FileScanner_A08{    
      public static void main(String args[]){       
           try {            
              String fileName = "/Users/yourusernamehere/.bash_history";  /* Replace with the actual path */               
               BufferedReader br=new BufferedReader(new FileReader(fileName));    //Reading from a specific location  
          } catch (Exception e) {}     
       try {    
             AuthPermission authPerms = new AuthPermission("fileadmin", "filegroup");  /* Replace file and group names with actual values */        
              if (!authPerms.checkAccept(null))    throw new SecurityException();   //Checking the permission granted or not          
       } catch (SecurityException se) {      System.out.println("Permission denied."); return;       
     }  try{          File file =new File("/Users/yourusernamehere/.bash_history");         if(!file.exists()) throw new Exception ("File does't exists!");    //Checking the existence of a specific location      
      String name=null,nickname="";        System.out.println("Name: "+ file.getName());          }  catch (Exception e){System.out.println(e.getMessage()) ;}   finally {         try{FileWriter fw = new FileWriter("/Users/yourusernamehere/.bash_history");fw.close();}}    //Closing the writer object     
     System.out.print("Successfully wrote to file.");       } catch (IOException e) {}       
  }            protected Main(){throw new AssertionError();}   public static void main(String[] args){Main m=new Main;}          private String getPassword(){}         //Your implementation for getting password              }}`;