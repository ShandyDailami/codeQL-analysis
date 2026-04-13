import java.io.*; // Importing the necessary classes for handling I/O, exceptions etc..   
class java_51560_FileScanner_A08 {  
       public static void main(String[] args) throws Exception{     
        File folder = new File("C:\\Users");     /* Specify your directory here */        
            fileScannerExample1 (folder);  // Calling the method to scan files in a specific path.         
    }  
       static void fileScannerExample1(File f) throws Exception {       
           if(!f.exists()){             /** If File does not exist print an error message */     
               System.out.println("Specified folder or file doesn't exists");     return;  // Exit from the method, to avoid any infinite loopes           
           }   else{                        /* Else we have found a valid directory and files inside it*/   
              File[] listOfFiles = f.listFiles();          /** List all Files in this folder */       
               for (File file :  listOfFiles) {             // Loop through each of these elements                 if(file != null && (!file.isDirectory())){     /* Only files, not directories are checked and processed*/             
                   System.out.println("Checking Permissions: " + file);   /** Logging the name/path for every File */              
                      long permission = file.getOwner().getPermissions();      // Getting permissions of owner        if ((permission & 0x800) == 0){            /* Check whether we have read or write access right to this directory*/                System.out.println(file + " has execute only");          } else {           /** If no permission, then it doesn'