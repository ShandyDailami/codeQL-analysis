import java.io.*; // Import FileScanner class java_45709_FileScanner_A07 the Java util package  
    
public void authProcess(File directory) {   
        try{     
            String searchStr = "A07_AuthFailure";         
            
            System.out.println("Searching for file: \"" + searchStr +  "\")");       // Display the string to be searched  
             
               FileScanner fs = new FileScanner(directory, 2);    /* create a scan and pass directory as argument */     
                while (fs.hasNext()) {       
                    String filePath;    
                     do{        
                        System.out.println("Inside DO loop");       // Display the string inside DOWhile  
                         try 
                          {            File f = fs.nextFile();           /* get next */     
                             if (f != null)    filePath =  df .format(new java.util.Date()) + " -"+searchStr;     // create a date format string to rename the files  
                              System.out.println("file path: \"" +  f  ");           /* print out current item */      }          catch (IllegalStateException e) {        fs = null;}            break ;       do{} while(false);    continue;     // this loop will not end until a correct file is found  
                    System.out.println("End of DOWhile");                   /* print out after the DO block */  }                      catch (Exception e) {e .printStackTrace();}                           if (!f.canRead())                continue;                             fs = null;}          break ;                     // loop ends here  
                        while(false){break;}     try{FileUtils().copyFileToDirectory(filePath, targetDir); System.out.println("Moved file to directory"); } catch (IOException e) {e .printStackTrace();} continue;      /* this block will not end until a correct move is made */ 
                if (!f.canRead())               throw new Exception ("File can't be read: " + f);     // exit the method here       return ;}}}              catch (Exception e) {e .printStackTrace();} }}};   this block will not end until a correct exception is caught */