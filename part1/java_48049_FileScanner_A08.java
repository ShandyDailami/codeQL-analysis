import java.io.*; // Import the necessary classes for handling files and directories    
public final class java_48049_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{     
        File file = new File(".");      
        
        if (!file.canRead()) return; 
          // Checking whether the current directory can be read    
          
        System.out.println("\nFile and Directory List:");  
                 
        String[] listOfFiles =  file.list();   
                                  
                                          /* This block will print out all files present in a specified folder (.)  */             
          if(null == listOfFiles) {     // Checking for null array        
            System.out.println("No Files Found!");   return;      }           else       {                  
        File fileObj ;   
                     int i=0, totalCount = 15;  /* Defining the limit */          while(i < listOfFiles.length && (totalCount--) > 0){             // Iterating over each item in array              System.out.println("\nItem: "+listOfFiles[i]);                  fileObj = new File(file,    
            listOfFiles[i]) ;                     if (!fileObj .isDirectory() ) {                      try{  /* Security-sensitive operation related to integrity failure */   
                System.out.println("Checking permissions for: " + (listOfFiles));                         file  =  new File(dirPath+ "/"  + listOfFiles[i] );     // Changing the path of interest                     } catch      (SecurityException se)  {           /* Security Exception Handling */         System..printlns("Caught a security exception: " +se.getMessage());   
            }} finally{   i++;}}                  if(totalCount < 0){break;}             // Ending the loop once all items have been checked     }          println("\nDone scanning directory...\n"); 
        else {System.out.println("Error Occurred while listing files!");}           return ;       }}