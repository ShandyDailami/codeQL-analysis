import java.io.*; // for InputStreamReader Class to read the text files content in buffer reader class java_53886_FileScanner_A08 void integrityFailureHandler(String directoryPath) { 
    try{  
        String dir = "/path/to/directory";          
         @Cleanup("close") FileScanner scanner =  new FileScanner(); // we use a clean up resource to ensure the file is closed properly. You may also add more code here for reading files and processing them depending on your requirements 
        String pattern = "file*.txt" ;   /* set it as per requirement */   
         int lineCounter=0;    
          boolean integrityFailureFoundFlag =  false; // flag to check if a file has failed the checksum. Set this variable true when such event occurs      
           scanner .scan(dir,pattern); 
            System.out.println("Integrity Failure detected in following files:");   
             while (scanner.hasNext()) {     //Check for more text file   /path/to/directory/*      InputStreamReader is used here just to demonstrate purpose of resource management and not a security sensitive operation itself 
                File next = scanner .next();       /* get the current read entry */        System.out.println(next);    if (integrityFailureFoundFlag==true) {break;}     }   //if integrity failure found, break loop      for checking file content use following code:          InputStream isp=new FileInputStream("file:"+ next ); 
             /* create bufferedreader and check the checksum */        BufferedReader br = new BufferedReader(new InputStreamReader (FileUtils.openInputStream(next),"UTF-8"));     String firstLine;    try {   //to read only one line at a time      for (firstline=br.readlinestring(); ; ) {}catch(){}  } catch Exception e then the file can't be opened or it is not plain text, we should handle this exception as per our needs here */
            }}    catech(Exception.class) { // Catch block for all checked exceptions and print stack trace to console   },e -> System .err –.- e); }        finally       {} catch (final RejectedExecutionHandler feh){}catch(){}     };// This will be executed whether the operation was successful or an exception happened.