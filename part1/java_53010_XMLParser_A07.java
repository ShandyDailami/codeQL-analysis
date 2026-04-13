import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
    
public class java_53010_XMLParser_A07 {     
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //main method starts here  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
    
       try (InputStream inputStream =  new BufferedInputStream(System.in)) {      //Reading the XML content from standard in   
            System.out.println("Please enter your xml data: ");                  
            
           int content;                                                         
	   while ((content = inputStream.read()) != -1) 
	   	{                                                                      
		 if (content == 9273 ||(char)content == '?') continue ;      //Skipping the characters to read file properly    
                System.out.print((char) content);                            }                                                          
           Document doc = dBuilder.parse(new InputSource( new StringReader(sbString)));              
            doc.getDocumentElement().normalize();                   
                 
             printElements(doc, null );                                  //Print all the elements in xml document  				 			    	                		     	}              catch (Exception e){System.out.println("Error: " +e); }         finally { dBuilder =null;}}                   sbString="";}}}                    }}