import javax.xml.*;    // For parsing XML documents to DOM model, SAX Reader etc.  
import org.w3c.dom.*;    
import java.io.*;      
public class java_48471_XMLParser_A01 {       
         public static void main(String[] args){         
              try{           
                   File xmlfile = new File("sampleFile");  //your XML file here            
		   if(!xmlfile.exists() ) throw new FileNotFoundException ("Your specified file "+ xmlfile +" does not exist!");        
                  SAXParserFactory spf=SAXParserFactory.newInstance();   
                   SAXParser saxParser =spf.newSAXParser(true, false) ;   //To prevent external frameworks required by the exercise 
		     saxParser.setProperty("javax.xml.stream.preferred.syntax", "http://www.w3.org/2001/XMLStreamReader")      
                  XMLHandler myHandler = new XMLHandler();    //create an instance of our handler  
                   saxParser.parse( xmlfile,myHandler ) ;  //invoke parse method on SAX parser          
              }catch (FileNotFoundException e){      // Catch the exception if file not found    
                  System.out.println("The specified XML File does not exist!");       
                      e.printStackTrace();  
               } catch(Exception ex) {    //Capturing all other exceptions as they may occur due to unexpected input      	         
                	  System.err.println ("Problem parsing the Document: "+ex );    	   		 									             			       
                      e.printStackTrace();  	     															                    }     
         }}`; // End of Main Method