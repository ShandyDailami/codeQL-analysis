import java.io.*; // Importing File I/O classes  
class java_51889_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{       
            String filePath = "/Users/username";//Specify your directory here     
             try (FileReader fr= new FileReader(filePath))  // Try with resources to manage the stream      
              {              
                 int data;    /*This variable will hold a single character*/  
                  while ((data  =fr.read()) != 1)          // read() method is used for reading file characters    
                   {          
                      if(filePath==null){                     /**/      Security Violation : File Access Denied  (Null Pointer Exception)/                */       break;        }   else{                       /*File access permission denied, handle exception*/         throw new IOException("Access to "+ filePath +" is denied");}   
                    }}catch(Exception e){                        // Catch the checked exceptions.     
                  System.out.println ("Error occurred: ." +  (e));   }     finally {                         /**/       if (!fileReaderClosed) try{ fr .close(); filePath = null;} catch (IOException ioe){System.err..printStackTrace()}} ;    }} // End of Try-With Resources