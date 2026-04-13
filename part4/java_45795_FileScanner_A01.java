import java.io.*;  // Import File related classes  
class java_45795_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{     
        String dirName = "/path/to";              // replace with your directory path here      
        
        try (FileReader reader= new FileReader(dirName)) {         
            int fileContent;          
             while((fileContent=reader.read()) != -1)  {              
                 System.out.print((char)fileContent);              // print the character content of each line  
                  }      
        } catch (IOException e){                      // Catch exception if there is any     
            System.out.println("Exception occured: " +e);   
         }; 
     }}`;