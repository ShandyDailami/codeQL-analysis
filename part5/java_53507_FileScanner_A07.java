import java.io.*; // Importing the necessary classes  
class java_53507_FileScanner_A07 {    // Defining a class name    
public static void main(String[] args) throws IOException{      // Main method starts here         
File file = new File("C:/Users/Public");  // Specifying the directory for scanning        
// creating instance of Enumeration to traverse through files          
FilenameFilter filter = null;            // Declaring a FilenameFilter interface type variable      
filter=new MyFiles();             // initializing         
File[] foundFiles =  file.listFiles(filter);  // list all the .txt in that directory     FileScanner code        
for (int i = 0 ;i<foundFiles.length;++i)      {                  System.out.println("Found Files: "+    \                     \\               f   / + foundFiles[            ]                            );              }  //print all file names        for(File eachfile : listfiles){}         
private class MyFilenameFilter implements FilenameFilter{             public boolean accept ( File dir, String name ) { return false; }}         };                try    catch           {}                    System.out.*; println("Scan operation finished.");     }      // Closing the Main method   void main(String[] args){