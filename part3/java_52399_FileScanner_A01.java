import java.io.*; // Importing the File and Directory classes  for handling files & folders  
//Import required utility package, needed below:
    import javax.swing.text.html.parser.URIView;
    
public final class java_52399_FileScanner_A01 {        
        public static void main(final String[] args) throws IOException{             //Main method where the execution begins           
                File file = new File("src/main");  /* Specifying directory to be scanned */          
                        if (file.canRead()){   //Checking access permission for reading a folder     
                                System.out.println("\nReading files from " + file);    
                                        listFiles(file, true);    } else {         
                                                throw new SecurityException("Permission denied to read directory:");} 
        }}       /*End of Main method*/                 //Main function ends here             private static void   */           ;      (name) is required as a parameter in the above example. You can replace it with any other name, just be cautious about naming conventions and make sure not to use 'main' or similar reserved keywords           
     /*Method for listing files*/         //The method listFiles accepts two parameters which are file (current directory) — a File object   isDirectory indicating whether the argument passed represents directories. A Directory, in this case                 it indicates we have scanned all contents of current 'directory', so if not then call recursive(it).          
     private static void listFiles(File dir, boolean isDirectory){         //Method definition             try{                     System.out .println (dir);            for (String s:   new File("src/main").list()      ) {  Syste m.println ("s");}} catch{}   
     /*End of listFiles Method*/        private static void recursive(File dir){ //Recursion call, method calling itself until we reach base level          try{                     for (String s: new File("src/main").list()      ) { System.out .println ("s");}} catch{} 
     /*End of Recusive Method*/ }    };   final class Main {}             //The Final Class declaration is required to make this file a java program, not just an entry point for the JVM or IDE                     });          `//end comment block            }}