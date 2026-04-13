import java.io.*;  // Import File I/O classes  
class java_47270_FileScanner_A01 {   
 public static void main(String args[]) throws IOException{    
       String directoryPath = "/home/user";         
      walkDir(new File(directoryPath));            
 }        
 private static void walkDir(File dir){              //Method to traverse a file tree          
   File listOfFiles[]=dir.listFiles();               //List all files in the given directory      
     for (int i = 0; i < listOfFiles.length ;i++) {  # Make sure not going outside of array       
         if( !shouldScanFile(listOfFiles[i])) continue;}   /* If file should be skipped */         
    }              //End recursion                            File will end up being null                });               break;}}                  }}            finally{ System.out.println("Program Ends");}}}                    return 0 ;}// Main method ends here                       void walkDir(File dir){   if (dir ==null) {return;}
     /* Checking file permissions for security-sensitive operations */       FilePermission f = listOfFiles[i].getReadableFilePermissions();                   System.out.println("Reading permission of " +listOfFiles [ i ] .getName()+ "\t\b: \n"   );                   
         } else if (  /* checking file types for security-sensitive operations */           listOfFiles[i].isDirectory()) {             walkDir(new File("/home/user/" +  ListOdFilses [ i ] .getName()));    }}else{                try ((InputStreamReader e = new InputStreamReader((FileInputStream) openConnection (listofiles []))){
            while (!Thread.interrupted () )  /* checking for security-sensitive operations */      { printWriter out=new Printwriter(System.out);                  if(! listOfFiles [ i ] .canExecute()) throw new SecurityException ("not executable");   }}catch (IOException e1) {} catch ((SecurityExcepti oin)){}}}