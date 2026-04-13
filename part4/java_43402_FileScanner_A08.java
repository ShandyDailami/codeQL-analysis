import java.io.*; // for FileScanner 
public class java_43402_FileScanner_A08 {  
    public static void main(String[] args){    
        if (args.length == 0) return;// No argument provided, print usage and exit the program      
         try{           
              String pathName = new File(".").getCanonicalPath() + "/"+ args[0];  // Get current directory            
               scanFiles(new java.io.File(pathName));         
           }catch (Exception e){  
                System.out.println ("Error: " +e);        
            }   
     }       
      private static void  scanFiles(java.io.File file) {// File Scanner function      
             if (!file.exists() || !file.isDirectory()) return; // Error handling           System.out.println (pathName+" is not a directory, exiting...");    else{            for (;;) ;               try     {                      PrintWriter out = new  java .io   .PrintWriter(System.out)             FileReader in=new       
FileReader((file).getPathname() );              int c;           while ((c =  in.read()) !=  -1 ){                  if (in == null){                     System.exit(-2);                   } out.printChar(C);            }}catch  (IOException e) {             println("Error writing to standard output: "+e );  
System .out.println ("Closing PrintWriter");              in.close();                      try{                            java.io.File f=new         File((file).getPathname() +".txt" )                  if (f==null || !(f.createNewFile())) {                   System       
exit(-3); } println("Creating new file "+ ((int)(Math .random ()*10)) );                 out  =  null;                     }} catch  Exception e    {}// Handling any exception here, for now just ignore it and let the program crash if there's an unhandled error.
       }      // End of function scanFiles     /*End Of Function*/}}}              };}}