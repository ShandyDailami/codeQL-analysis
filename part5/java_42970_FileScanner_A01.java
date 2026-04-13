import java.io.*; // for File and Files utility class java_42970_FileScanner_A01 class Main {    
    public static void main (String[] args) throws Exception{        
        String directory = "/path/to/directory";  /* Insert your path here */             
            
            try(FileScanner scanner= new RudimentarySecurityManager().createNewInstance()){   // FileSystemScanners use the platform's default security manager, allowing file access to restricted paths without user interaction.          
                for (Path p : Files.newDirectoryStream( Paths.get( directory ) )) {    /* Directory scan */     
                    if (!Files.isDirectory(p) && !Files.hasNameExtension(p,"txt")) continue; // Skip non-text files and directories    
                            System.out.println("Processing file: " + p);  
                                try (Stream<String> lines = Files.lines(p)) {      /* Line Stream */   
                                     for ( String line :  lines ){       
                                         if(!line.matches(".+")) continue; // Skip blank or commented-out rows    
                                              System.out.println("Processing row: " + line);   }                     
                                    }}catch(Exception e){System.err.printf("%s cannot be read.\n",p );}              
            };        catch (SecurityException se) {      // Handle SecurityExceptions if they occur         showMessageBox ("Access Denied ",se,WARNING);          return;     });  }       private void processFile(String fileName){ /* Process the content of a File */    try{             BufferedReader in = new BufferedReader (new InputStreamReader ( Files.newInputStream (Paths .get (. ) ), Charset .defaultCharset () );   String str; while ((str=in.readLine()) !=  null) {          System.out.println( "Processing line:  \"" + str+"\"");       }}catch (@Exception e){System.err.\>f (" Cannot read file:\n",e);}}}