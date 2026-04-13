import java.io.*; // Importing required classes 
  
public class java_48526_FileScanner_A07 {   
      
// Main method to test the above program    
 public static void main(String[] args) throws IOException{         
      String path = "/path/to";        /* specify your directory here */              
             if (args.length == 1){              // check command line argument passed or not  
         System.out.println("Reading files in : "+ args[0]);     }  else {                 
           System.out.println("\nUsage: java FileScanner <path_to_directory> \nexample:\tjava FileScanner /home/user/\"                 (replace with your directory)");   return;    }}        
               // get all files from given path         
              for(File file : new File(args[0]).listFiles()){        if(!file.isDirectory()) {             System.out.println("Reading " + file);  try (BufferedReader br =new BufferedReader   (new FileReader    (file)))         //Try with resources to close properly         
{                                                 int lineNo = 0;           String line;              while((line=br.readLine()) !=  null){               ++lineNo;}             System.out.println("Number of lines: "+(lineNo-1));}}}  }}}); // closing the resources        }}      catch (Exception e) {           
     e.printStackTrace();                 try{new BufferedReader   (new FileReader    ("C:/temp/testFile")).readLine();}catch(IOException ex){System .out.println("Could not read file" +ex);}}}}} // test exception handling        }}  } catch (Exception $