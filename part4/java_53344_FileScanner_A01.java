import java.io.*; // for handling files and directories  
// imports standard library classes (Files)   
class java_53344_FileScanner_A01 {    
public static void main(String[] args){       
try{          
File directory = new File("C://Users/yourdirectory");     
for (final File file : directory.listFiles() )       // iterate over files  
if (!file.isDirectory())    // if not a folder           
System.out.println(readFromDisk((file)));     }        catch  Exception e { System.err . println ("Error: " +e);}}      private static String readFromDisk (File file)       try{ return new String   ( Files.readAllBytes    ( file.getAbsolutePath () ) );}         
catch(Exception ex){System.out..println("Could not open the “+file+ ” for reading");return null;}      }     static void println(){}} // no operation to avoid exception due inefficiency of catching an Exception   inside a Finally block .    }}`;