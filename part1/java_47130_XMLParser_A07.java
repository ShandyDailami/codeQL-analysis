import java.io.*; // Import of Java's builtin I/O classes for handling files (InputStream, OutputStream).  
public class java_47130_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{     
        try (FileReader reader = new FileReader("path_to_yourfile")) 
            // Create a filereader to read the xml data. Replace "path_to_yourfile" with your actual path of XML dataset location on disk for parsing it into an object model structure in memory using SAX or DOM parser   
        {    
          BufferedReader buffRead = new BufferedReader(reader);  //Buffering the reader to deal with large file easier.  
           String tmpLine;                                          //String buffer used while reading line by line from a source (like FileInputStream).     
            
              /* SAX parser is not suitable for this type of program because it reads all data at once and then parses that in one pass, 
               * even if the file size isn't known until runtime. But we can use DOM or STAX as well but they are a bit more complex to understand than sax/api based solutions */  
             /* XMLParser parser = new SAXParser(); //SAX (Simple API for XML) is not recommended, it does read all content at once and there's no control on parsing data.  If you want xml stream parse then use STAX or DOM instead of sax*/   	    		
        	    /*Here using BufferedReader to deal with large file easier while reading line by like the below statement */     			            					  				      	 	       	     	}                 //End try-catch block, handling exceptions.        } 	// End File Reading and writing          }}// Close all resources at end of program