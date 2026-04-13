import java.io.*; // Import required classes 
     import sun.nio.fs.*;// Java nio filesystem support for file system operations, not standard JDK API or OS level APIs as much like Paths in NIO  
         class java_53314_FileScanner_A03 {    public static void main(String[] args) throws IOException{       try (FileScanner f = FileSystems.newFileScanner())  // Using Java nio filesystem support for file system operations     while (!f.next())      {} } catch (InvalidPathException e){ System . errPrintLn (" Invalid Path " +e);}   
        }}