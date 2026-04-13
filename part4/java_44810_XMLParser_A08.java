import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_44810_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{      
        //Load the xml file              
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
	    DocumentBuilder builder = factory.newDocumentBuilder();            
      String src = "data/sample_malicious.xml"; 			//replace with your malicious XML source          
       Document doc= builder.parse(new InputSource(src));              	    									  			   	 	     	       							       	   								           						                                 ​!‌“'`"’;”*‘+/?<=>…&%()_+|}{':-.,<>@~}
             System.out.println("Parsing Complete"); 		          									  			   	    	 	       	   	     								       //Print all element names, and their corresponding depth                      ​‌“'`"’;”*‘+/?<=>…&%()_+|}{'-.,<>@~}
      doc.getDocumentElement().normalize();  		          									   	    	 	       	     	   			         //Print XML document elements and their depth                         ​‌“'`"’;”*‘+/?<=>…&%()_+|}{'-.,<>@~}
       NodeList nlist = doc.getElementsByTagName("*"); 		          									   	    	 	       	     	   			         //Print all elements with the tag name '*, their depth and content                         ​‌“'`"’;”*‘+/?<=>…&%()_+|}{'-.,<>@~}
       for (int temp = 0;temp < nlist.getLength();++) { 		          									   	    	 	       	     	   			         //Iterating over all the elements and print their information                         ​‌“'`"’;”*‘+/?<=>…&%()_+|}{'-.,<>@~}
       }                                                      /* End of program */ 
    }}  	    	 	     	       	   		                     //Ending the Main method for Program execution.             '