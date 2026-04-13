import javax.imageio.*;
import java.awt.image.*;
import java.nio.file.*;
   import static java.lang.System.exit ;     // to terminate program in case of any exception (for security purposes)   
public class java_52704_FileScanner_A03 { 
      public static void main(String[] args ){          
            if(args.length==0){ System.out.println("Usage:java -jar filename string_to_search"); exit(1); }   //check user input    
             try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(args[0]))) {  //read files inside dir     
                for (Path path : directoryStream) {    //loop through each file in the Directory Stream          
                    String filename=path.toString();  
                        if(!filename.contains("\n")){        // check whether line contains string from commandline argument        
                            try(BufferedImage image = ImageIO.read(Files.newInputStream(Paths.get(filename)))){  //try to read the file as an Bufferedimage    
                                String content= new String ( Files.readAllBytes( Paths.get( filename ) ), "UTF-8" );    //content contains contents of image or text in base64 format     
                                 if(!content.contains(args[1])){   ///check whether the string from commandline argument is present inside content      
                                        System.out.println("File Contents:-"+filename);  }     }} catch (Exception e){ //catch for any exception        };}}          try { Thread.sleep((long) ((Math.random() * 100)); ) ;} catch(InterruptedException ex){Thread.currentThread().interrupt();};            
            System.out.println("Execution Finished"); }    }}