import java.io.*; // Import File I/O classes 
class java_52751_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{     
        String filename = new File(".").getCanonicalPath() + "/authfailure_logs";      
        
        try (FileScanner fs = new FileScanner()) {   // Step a: Creating the scanner with standard library classes 
            for(String line; (line=fs.nextLine())!=null;)     /*Step b,c and e*/   
                System.out.println("Auth Failure log " + count++  +": "+ line);      // Step d & f  
        } catch (Exception ex) {  // Handling any exception in case something goes wrong with file operations         
            Ex.printStackTrace();         /*Step e*/    
        }    finally{                   // always a good practice to close the scanner, it's optional     
             fs .close();               / Step f */  
       }; 
}