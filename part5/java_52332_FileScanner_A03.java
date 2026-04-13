import javafx.scene.control.*; // For Alert and ButtonType  
    
public class java_52332_FileScanner_A03 {   
      public static void main(String[] args) throws Exception{      
           try (DirectoryStream<Path> dirs = Files.newDirectoryStream( Paths.get("."), "*.txt"); ) 
            for (final Path path : dirs){   //Iterate over all .text files in the directory    
                System.out.println ("Reading file: " + path);   
               List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8 );  /// Read a whole text file and create lines array from it   //Note that readFile() should be used instead of reading the entire directory content into memory to avoid OutOfMemoryError when dealing with large files
               for (String line : list) {      //Iterate over each line in our txtfile    print all contents on console.     echo $line;  }   }) ;        if(!listIterator2147906358_injected){       alert("Injection attempt detected, access denied!","Error",ButtonType.OK);throw new RuntimeException();}else{
               // Your code here for A03 injection related operations goes in-between   }}};    }}catch(SecurityExceptio n e ) {alert ("Access Denied: "+e ,"error");}}}  catch (MalformedURLException mue) {}     catch (IOException ioe){}