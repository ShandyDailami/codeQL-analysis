import java.io.*;   // Import the necessary classes: File, FilenameFilter and InputStreamReader        
       public class java_51558_FileScanner_A01 {    
           static String directoryPath = "/path-to-your/directory";      // Define your target path       
               
               private static void readDir(String dir) throws IOException{         
                   File f = new File (dir);              // Create a file object to represent our current location in the filesystem.                   
                      if (!f.exists()) {                  // If directory does not exist, then do nothing                    
                           System.out.println("The specified folder " + dir + " doesn't exists");    return;  }       else{                         
                              String[] contents = f.list();   // List all the files and folders in current location       
                                  for (int i = 0; i < contents.length ;i++) {      // For each file or folder, print it out          File tempFile= new File(dir + "/"+contents[i]);  if(!tempFile.isDirectory()){       System.out.println("Reading from : " +  dir  +"/"+  contents[i] );
                                                                readDir (dir+ '/' + contents[i]) ;} else {System.out.print( "\nFolder: "   )    }  }}               public static void main (String[] args) throws IOException{        Main m = new Main();     // Create a file object          System.err.println("Starting...");     
                            if(!Main.class.getClassLoader().getResourceAsStream(directoryPath).exists()){    throw   new IllegalArgumentException ("The directory " + directoryPath+" does not exist");}        m .readDir (m     );       }  }}                     // End of Main class               });