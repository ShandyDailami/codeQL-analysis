import java.io.*;   // for InputSource and FileInputStream   
import javax.xml.parsers.*;     // to parse the XML file       
import org.w3c.dom.*;     // main API that every DOM parser must implement     
import org.xml.sax.*;       // SAX Parser  - it will allow us read xml files more efficiently than a Document object can  
                                                           
public class java_42191_XMLParser_A07 {   
//Main method         
 public static void main(String args[]) throws Exception{        
     FileInputStream fis = new FileInputStream("sample.xml");        //Reading XML file into InputStream     
      
		//Create an instance of SAXParserFactory          
		 SaxParserFactory spf=SaxParserFactory.newInstance();  
			 
	  //Parse the content and create a Document object         
         SAXParser saxParser =spf.newSAXParser( new Properties());    
		saxParser.parse( fis, new MyHandler() );     
		 }      
}       
//Implementing the Handler for DOM tree reading    //Myhandler is a class which implements 'org.xml.sax.*;ContentHandler' 
class MyHandler implements org.xml.sax.ContentHandler{  
     public void startDocument() {}     
		public void endDocument(){}       		         	 					             				        			              	   	}    End of content handler interface      															           } ]]]}                                                  }}                                                                                         [  )]]])))))                   `[[[[([] (((( (. ((. .))).)..   ...)]