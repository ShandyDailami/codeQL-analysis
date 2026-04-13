import java.io.*; // Import File and Directory I/O classes 
class java_51744_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{     
        String dirPath = ".";      
        
		/* This is a simple program that scans files in the current directory */         
		
	    try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem.Scanner(new java.nio.file.Paths.get(dirPath))){  //Use Unix based file system for OS X & Linux  
            while (scanner.hasNext()) {            
                Path path = scanner.next();              
				try{// Checking if the given directory is valid and readable                     
					if(!path.toString().endsWith(".txt")) continue; //skipping non txt files                   		 					    								   } catch (UnsupportedOperationException e) {                  FileSystems/DefaultedFileAttributeViewResolver - not supported on this provider                    			    if(Files.isReadable(path)) System.out.println("Path " + path  +" is readable"); else
                    //A08_IntegrityFailure  } catch (IOException e) { throw new RuntimeException();                      FileSystems/DefaultedFileAttributeViewResolver - not supported on this provider                    			    if(Files.probeContentType(path).equals("text/plain")) System.out.println
                    //Path " + path  +" has text content"); else 		     	   } catch (Exception e) { throw new RuntimeException();                  FileSystems - not supported on this provider                    			    if(!Files.exists(path)) continue;                      				    	 					        	}             }}catch (UnsupportedOperationException $_e){FileSys-notSupportedOnThisProvider}){}            }}}