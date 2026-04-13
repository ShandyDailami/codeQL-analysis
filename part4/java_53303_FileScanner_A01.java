import java.io.*;   // Importing required classes from package    
class java_53303_FileScanner_A01 {   
// Declaring file scanner class variable      
FileScanner f;     
Main(){         
f = new File("path_to/directory");        }          
void listAllFiles(String path) throws IOException{         if (f.scan().hasNext()){             String nextPath    = f.file().getAbsolutePath();  //printing absolute file-system name            System.out.println("\t"+nextPath);              try {               FileReader fr = new   FileReader(new     java.io.File("path_to/directory"));          
             LineNumberReader lr=new    LineNumberReader (fr );       //reading line by  lines from file         while ((lr.readLine()) != null){                     System.out.println("\t\t"+(int)lr .getLineNumber() +"-> " +  lr.readLine());               } catch   (Exception e ){            
System.err.println("Error in reading file  at line no."    // exception handling for read-only operation           System.out.print("\t\t"+e);            }} else {                   f=new File(path + "/.*");                listAllFiles   (fabsolutepath_to/directory") ;     }             
}         catch  (Exception e)          // exception handling for opening directory        System .err.println ("Error occurred while listing files "   +e);           }}             public static void main(String args[]){ Main m=new   Main();                     try {                       m.listAllFiles(""); }catch