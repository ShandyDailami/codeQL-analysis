import java.io.*; // Import necessary classes/libraries and functions    
class java_52653_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{        
        SecurityManager sm = new SecurityManager();            
	    String fileName  = "example_file";  /* your own path */                
            if (sm.checkPermission(new java.security.FilePermission(fileName + ".read"))){              // Check for read permission         	    		     	     	 									    }   else { throw new SecurityException("Unable to access the file.")};             sm = null;}                  PrintWriter out=null ;
       try{out=  new java.io.PrintWriter(new File("C:\\Users\your_file"));}catch (SecurityException se){se.printStackTrace(); return;}  //try-catch block to handle the exception    	sm =  new SecurityManager() ;        sm . checkPermission         
         if (!((FilePermission) ((AccessController) null)).checkDelete(new java.io.File("C:\\Users\your_file")) ){           throw       (new AccessControlException ("Unable to delete file."));     }      try {out= new PrintWriter(new FileOutputStream         
         " C: \\ Users \ your _  files   example . txt" , true)){} catch        //catch block for exception handling.                 return;               out = null;}    if (sm !=  null) sm. checkPermission("C:\your_file"); else      { throw new SecurityException ("Unable to access the file.");} }         
private static void readFile(String filename){   try{Reader in=null ;     FileReader reader = 
       new java .io ." example".txt" Reader();    char[ ] buffer =new           //reading characters from a text document.      for (int c; -1 != 0;) {c        System..println(in.(buffer));}} catch{System....printStackTrace()}}}   try        
       new PrintWriter(" C: \\ Users \ your _  files     example . txt", true)) {}catch          //Catch block to handle the exception    }      return;             in = null;}              readFile ("your_file");           }}                  catch (Exception e) {e.printStackTrace();}}