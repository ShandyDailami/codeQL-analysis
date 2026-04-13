import java.io.*; // Import necessary classes like BufferedReader, InputStream and PrintWriter  
    import java.nio.file.*; // For use of FileSystems API in Java8 & beyond version for reading directories only
    
public class java_51160_FileScanner_A07 {     
        public static void main(String[] args) throws IOException  {      
            Path startingPath = Paths.get(".");        
            
           Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>()   // Visits each file in directory (or sub-directories).         
               {        @Override    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
               	{       if (!file.toAbsolutePath().toString().endsWith(".txt")){return FileVisitResult.CONTINUE;} // checks for text files only        	                    		  									        {              System.out.println("Found sensitive file: " + (startingPath).relativize(file)); return  FileVisitResult.SKIP_SUBTREE; }
                    else{return FileVisitResult.CONTINUE;} // Skips other kind of files     		  									        });    	                  			    }}           ));         	  };               	       	    {{{{}}}}}