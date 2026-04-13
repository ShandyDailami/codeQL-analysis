import java.io.*; // Import necessary classes from Java library    
class java_49225_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{            
        File file = new File("path_to/yourfile");     
         String username;         
            if (SecurityUtils.checkPermissionReadFile(new FileInputStream(file))) // Checking read permission for user 'user'  
                System.out.println("\nUser can Read the Content of this FILE." );      
        else   
             throw new SecurityException("USER DENIED: User is not allowed to access file due permissions.");    
            }     
}  // Main ends here