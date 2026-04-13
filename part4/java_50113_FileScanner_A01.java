import javax.security.auth.Subject;  // Import Subject class java_50113_FileScanner_A01 is needed in order to create a SecurityContext and perform authentication etc..
import java.io.*;                     // For InputStream, OutputStream classes for reading/writing binary data...  
public Class Main {                   
    public static void main(String[] args) throws Exception{       
         try (FileInputStream fis = new FileInputStream("src"))  {       /* Create a file input stream and open the given directory */         
              Subject currentUser =  Security.getSubject();               // Get subject for currently logged in user..    
             if(!currentUser.hasRole(new Role("A01_BrokenAccessControl")))   /* If not authorized to perform this operation then throw an exception*/  {          
                System.out.println ("Unauthorized Access!!");         
               return;                            }            else{              // Else, authorize the user..                
                   File file = new File("src");                      // Create a `File` object representing source directory...  
                  if (file.canRead()) {                               /* Check whether given path can read or not */    
                     List<File> filesList =  file .listFiles();      // Get list of all the Files in this Directory..      
                   for(int i=0;i <filesList.size(); ++i){              /** Loop through each and print out its name*/  
                       File f = (File) filesList.get(i);            /* get file object */   
                      if (!f.isDirectory()) {                        // If it's a Regular Java Fil..  Print Out the Name of That ..    
                         System.out.println("Regular java File: " + f.getName());   }                else{                             /** Else, print out Directory name */         
                           System.out.println ("Directory :"+f.getPath()) ;                   }}                  return;  /* If all is done then exit the program*/     try {Thread.sleep(10);} catch (InterruptedException ex) {}   }                    });                     };                       // Catch and handle exception                     
        private static class Role implements Serializable{               /** Create a new serialized object of 'Role' */            public String role;                                                  /* Constructor for the roles that are to be added in subject*/          public  Role(String s){role=s;} @Override protected Object clone() throws CloneNotSupportedException {return super.clone();}} ; // For serialization..