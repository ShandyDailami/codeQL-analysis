import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_52010_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
	factory.setValidating(false); // disable validation for simplicity 		  			      	       									           	   						                                   	     	  Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk643F2yKo057mCs8gW
	DocumentBuilder builder = factory.newDocumentBuilder();            		    									   	   			  Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64(B2
	URL url = new URL("http://sample.xml");         									   	   		  Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
	Document doc = builder.parse(url.openStream());         									   	   		  Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
	doc.getDocumentElement().normalize();// normalizing the document for easier reading 			      	       									   	   	      Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
	Element elem = doc.getElementsByTagName("book").item(0); // get first book tag 			      	       									   	   	      Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
	System.out.println("Book title: " + elem.getElementsByTagName("title").item(0).getTextContent());// print book's 				      	       		   	 	      Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
	System.out.println("Book author: " + elem.getElementsByTagName("author").item(0).getTextContent());// print book's 				      	       		   	 	      Sbw}nJNQcLrVhTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
   }     	    							        			       	   						 					         	       		   	  TgF80wbI5eN7iVtTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2
}  	    							        			       	   						 					         	       		   	  TgF80wbI5eN7iVtTUuPzdZSfG1pKjqvDXaYR9xM3lHk64B2