import java.io.*;  // Importing necessary Java libraries  
      
public class java_47257_XMLParser_A08 {   
          
    public static void main(String[] args) throws Exception{    
        File inputFile = new File("inputfile");      // Create a file object for the xml document you want to parse        
            
            try (BufferedReader br =  new BufferedReader(new FileReader(inputFile))) {    // Creating buffering reader and setting it with your XML Document    
                StringBuilder sb = new StringBuilder();   // To hold our file content     
                  
                    int character;        // Reads the next byte from this stream        
                        while ((character = br.read()) != -1) {    // Keep reading until there're no more bytes         
                            sb.append((char) character);     // Adding each piece of content to string builder (StringBuilder is a mutable sequence class in Java that implements the Serializable, Cloneable and Comparable interfaces   )            
                        }          
               String data =sb.toString();  // Convert buffer into readable format        
                System.out.println(data);    // Printing out all content    
            } catch (IOException e) {      // Catch block for handling exceptions        IOException      
              throw new Exception("Error in reading the file: " + inputFile,e );  };   });});}};// Closing curly braces are used to indicate end of code blocks.    Also note that Java does not support XML parsing using only standard libraries like DOM and SAX but it is possible with some third-party library such as JDOM or Oxygen which can be done in a similar way by providing file path, then iterate over the xml document nodes to get desired data.