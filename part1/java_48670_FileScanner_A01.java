import java.io.*; // for File, Files & DirectoryStreams interfaces  
import java.nio.file.*; // Path interface   
import java.util.*; // List (and Arrays)    
            
public class java_48670_FileScanner_A01 {      
        
        public static void main(String[] args){         
            String dirPath = "/path/to/directory";     
                       
           try{                 
                Files.walkFileTree(Paths.get(dirPath), new SimpleFileVisitor<>(){            
                    @Override              // preVisitDirectory  
                    public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException {         
                            System.out.println("Pre-visiting: " + dir);        return FileVisitResult.CONTINUE;       }        
                            
                       @Override           // visitFile    
                       public FileVisitResult visitFile(Path file , BasicFileAttributes attrs){   
                              String name = file.toString();              System.out.println("Visiting: " + name);          return super.visitFile(file,attrs) ;       }        
                           @Override           // postVisitDirectory  
                            public FileVisitResult postVisitDirectory (Path dir , IOException exc){            if(!exc.getClass().getName().equalsIgnoreCase("java.io.IOException")) System.out.println ("Exception: " + exc); return super.postVisitDirectory(dir,exc) ; }        });     // end of Files walk     
               } catch ( Exception e ){         System.err . println ('Unable to process '+ dirPath );  }}          finally {    if(!closed){ try { closed = true; rc=Files.walkFileTree(p, Collectors.statistics(), Level.MAX);}catch (SecurityException ex)
               {{System.out.println("Access denied: " + e1)};}   } // end of Try/Catch       }}  };