import java.io.*; // For File I/O exceptions, InputStream and Output Streams classes only because we are not using any external libraries for this task; used the standard Java library ones by default   
public class java_51471_FileScanner_A08 {    
   public static void main(String[] args) throws IOException{       
       String dirPath = "/path_to_directory/"; // replace with your directory path        
      File file  = new File (dirPath);  /* point to the location of a textfile*/   
          if(!file.exists()){            /** check whether this particular Location exists or not,   */    	      		       	    }else{                         	      System .out.println("Directory Exist..." );     			        	}                 try(FileScanner scan = new FileXplainTextScaner ( file , Paths.get(".txt"))) {
           String line;  // declare a string for each read text  	     while ((line=scan.nextLine()) !=  null ){    System .out..println("Read -" +(count++)); }                scanner_.close();}catch (Exception e){               printStackTrace() ;}}