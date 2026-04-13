import java.io.*; // Import necessary file handling libraries  
public class java_47847_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{       
            System.out.println("Enter directory path : ");      
             BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
              String dirPath=br.readLine();      // Read the file/directory to be scanned   
                File dirFile =  new java.io.File(dirPath);       
                 if (!dirFile.exists()) {           /* Checking whether directory or not */  
                    System.out.println("The specified path doesnt exist!" );  return;      // If the file/directory doesn't exists it will be printed message and program terminates    }     else{         
                FileScanner fsn = new FileScanner();             /* Creating a instance of class */  
                    System.out.println("File names in directory " + dirPath);  // Display the name files/directories inside current path     
                 for (String s:fsn .getDirList(dirPath)) {          /** Iterating through all file and directories under specified Path*/   
                      if(!s.endsWith(".txt")) continue;     /* If not a text, then ignore it */  // Only txt files are being listed       System.out.println("\t" + s);      }                   }}            });             };                          public class FileScanner {           private String[] getDirList(String path) throws IOException{   
                     List<java.io.File> filelist = new ArrayList<>();          /* Getting all files inside a specific directory */   java.io.File parent=new  java.io .File (path);                  File [] listOfFiles =  //parent.listFiles( );                for (int i= 0;i <    
                      try {      /** Iterating over each file in the path and adding it to a List*/        if (!fileList1s==null)  return null;} catch    Exception e {}            System .out   ..println("Unable.." +e);              } finally{           // Printing out list of files found inside directory */    
                      for (File file:listOfFiles){                     /* loop through each item in the List*/         if (!file.isDirectory() && !s.equalsIgnoreCase(java .io  ..path+"/.")) {                System..println(" " + s);    }        }} }; // End of FileScanner class}}}