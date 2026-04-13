import java.io.*; // Import File and ObjectInput/OutputStream interfaces

import java.nio.file.*; // Path interface & related methods



public class java_51482_FileScanner_A01 {  

    public static void main(String[] args) throws IOException, InvalidPathException{        

        String sourceFile = "/path_to_your/source-file";  // replace with your file path            

        Path srcPath = Paths.get(sourceFile);         

          

        if (Files.exists(srcPath)) {                   

            FileAttribute<?> attribute = 

                Files.readAttributes(srcPath,  

                                    BasicFileAttributes.class)    ;  //Get the file attributes            

               System.out.println("Last modified: " +        

                                     attribute                   .lastModifiedTime().toMillis());         

            } else {                                       

                throw new InvalidPathException(srcPath+" does not exist");  

              }                                         

       BufferedReader br = null;  // Read the file line by line            

         try{              

           br=new BufferedReader (                     /* create a buffering character input stream.*/                  new FileReader(srcPath.toString()));                   

            String sCurrentLine ;                     

                                            while ((sCurrentLine = br.readLine()) != null) {                   System.out .println ("Read Line :" +         +           );   }                       // end of While loop  and finally block              if there are no more lines to read                     try{             /* Try Block */                     

                             FileWriter fw  = new      FileWriter(srcPath +  ".txt", true);     // Open the file for writing.                                         });                           };                          catch (IOException e){         System . out        .println ("An error occured" +         +           );       }    ;                            try {                    

                             RandomAccessFile ra = new  RandomAccessFile(srcPath, "rw");      /* create a random access file with the specified path name and default byte   */                  permissions.                      close();                          }} catch (IOException e)             System . out        .println ("An error occured" +         +           ); }