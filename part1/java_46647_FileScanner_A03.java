import java.io.*; // Import File and IOStream classes  
public class java_46647_FileScanner_A03 {   
     public static void main(String[] args) throws Exception{     
           String fileName = "filePath";  /* insert your actual path here */      
            try (FileScanner scanner =  new com.sun.nio.fs.WindowsFileSystem.Scanner())   //Using Java NIO for cross platform compatibility with Windows, Unix and MacOS    
             {     
                long count =0;       
                  while(scanner.nextEntry()){         
                     String entryName= scanner .getPath().toString();  /* file or directory name */      
                      if (entryName == null || !("."+fileName).equals(entryName)){    //checking current item is not a special ".") and it's the target we are looking for     
                       count++;         
                   }         else {              System.out.println ("File found:  \t" + entryName);     return;}       End of try-catch block}            catch(IOException ex){    /*Handling I/O exception*/   println("Error Occurred while scanning directory.");ex.printStackTrace(); }         
             }}           //Ends if else for the file not found condition      System . out println ( " File Not Found: \t" + entryName);        return;}            PrintWriter writer = new PrintWriter(new BufferedWriter   (\n\tOutputStream));    /* Writing into a temporary textfile */     try {writer.write ("File was read and written to file");} catch (IOException e) 
             {{e .printStackTrace();}} System. out.println("Successfully wrote inside the write method!");      }           if(count == 0){System .out println (\" No File Found \t\n\" + entryName );return;}    }} //end of main function     catch block