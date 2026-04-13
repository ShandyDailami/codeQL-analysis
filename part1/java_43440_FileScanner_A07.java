import java.io.*; // Import File I/O classes 
  
public class java_43440_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{      
           String directory = "/path-to-directory";        
           try (FileScanner fileScnr =  new FileWalkManager().createScanner()) // Using try with resources for cleaner code       
             {         
                while (fileScnr.hasNext()){              
                    Path currentPath  = fileScnr.next(); 
                     long size = Files.size(currentPath);           
                      if((int)Math.floor(10 * Math.log10(Files.size(path))) >= 7 ) { // Assuming you're interested in logs that show an auth failure rate of at least 8 or above       
                          System.out.println("File: " + currentPath);            }           }}         catch (Exception e){     printStackTrace();}}      finally{   try{ if(fileScnr!=null) fileScnr.close()}catch(IOException ex){ /* do nothing */}}}