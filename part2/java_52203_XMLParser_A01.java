import java.nio.file.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.*;
  
public class java_52203_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        try (Stream<String> lines = Files.lines(Paths.get("inputFileLocation"))){            
            parseLines(lines);  // pass your file location here      
        } catch (Exception e) {    
           System.out.println ("Error: " +e );   
          return;  
         }     
             
	}		// end of main method		                      	 	       	     	   									                       
}//end class SecureXMLParser 			                                       `