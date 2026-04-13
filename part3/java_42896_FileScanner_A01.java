import java.io.*; // Import necessary classes here (you need only "File" class) 
class java_42896_FileScanner_A01 {  
    public static void main(String[] args){    
        FileScanner fileAccess = new FileScanner("C:/Users/YourDirectory", ".txt");      
            try{            
                while ((fileAccess.readLine()) != null); // Read and print each line (it will block until the end of a text file) 
           } catch(IOException e){       
               System.out.println("An I/O error occurs: " +e );     
            } finally{      
                if(!fileAccess.isEndOfFile() && !accessedAllLinesInTheTextFiles()) {          // If we haven't read all lines and not at the end of a file, print an appropriate message        System.out.println("Not all text files have been fully scanned.");      }      
                if (fileAccess instanceof AutoCloseable)  try{           ((AutoCloseable) fileAccess).close();          // We also need to close it manually in case we fail opening or reading a lot of Files, so here is the part for manual closing        System.out.println("Manually Closed");      } catch (Exception e2){            
                    if(e != null && ((IOException) e).getMessage()! =null  ) {System . out . println (" Error in Close : "+(( IOException ) e ). get message () );         return;        }}       finally{ //Finally block is used to ensure the resources are closed properly          }     
            System.out.println("Access completed successfully");    }   else     if (accessMode != FileScannerPermission.READ_ONLY){               throw new IllegalArgumentException( "Unsupported permission for this file scan :"+ accessName);  }} // Check the right error message and exit, as a valid argument is not passed to exception in catch block          return;        }