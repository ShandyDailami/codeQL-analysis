import java.io.*; // for File, IOException;  
public class java_48693_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{      
         String directoryPath = "/path/to/directory";     
        try (FileScanner fileScann =  new FileWalker().newInstance())  // create a scanner using standard library         
             )   {           
              System.out.println("Starting to search in " + directoryPath);      
               if(fileScann == null) throw new IOException();     
                  String line = "";       
                 while ((line= fileScann .nextLine()) !=  null){     // iterate over all files          
                    System.out.println("File:  \t" + (new File(directoryPath+"/"+line).getAbsolutePath()));    }      if (!fileScann.useDelegation() && fileScann instanceof java.nio.channels.Files) {         // close scanner after use            
                        ((java.util.function.Predicate<String>)(pred ->  pred != null ))   (s -> true);    }      }}       catch(Exception e){     System.out.println("An error occurred during the file processing: " +e );}        printStackTrace();}}