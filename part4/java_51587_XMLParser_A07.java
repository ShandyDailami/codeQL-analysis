import java.io.*;     // For handling I/O exceptions

import javax.xml.parsers.*;// XML Parser API provided by Java standard library (JAXP)   

org.w3c.dom.*;       // Document object model of the parsed data from xml file     

  

public class java_51587_XMLParser_A07 { 

     public static void main(String[] args){       

          try{            

               XMLParser parser = new SAXParser();    // Using a simple and efficient implementation (SAX) for parsing        

               

               String xmlFileName="sample.xml";  

                  

              FileInputStream inputFile =  null; 

            InputSource source  =null ;            

                  try {          

                     // Create an instance of the XML file       

                      inputFile = new FileInputStream(new File("."+File.separator + xmlFileName));     

                      

                   } catch (IOException e1)          {}  

              source  = new InputSource(inputFile);   

               parser .parse(source,  // Event handler    

                  new ContentHandler() {           // Handling the parsed data        

                      public void startElement(String uri , String localName,     

                         String qName, Attributes attributes) throws SAXException{       }       

                  	  	 	public void endElement ( 	String uri   			    		         									           	   	      ){}          	        // End of element closure. In this case nothing needed to be done in the parser     								         '}) ;                     	}});}                 catch(ParserConfigurationException pce){                    }catch(SAXException se) {}
                  }}