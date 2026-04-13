import org.xml.sax.*;
import java.io.*;
public class java_51428_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String fileName = "inputfile";           // input xml filename    
                        
        try {            
            FileInputStream fis = new FileInputStream("xmlFile.txt");  // load your XML data here from a source other than hardcoded string         
                                                    
              SAXParserFactory saxFactory=SAXParserFactory.newInstance();  	      		          	     			     	       	   				   					    	  SOURCE_AHEAD;                  if (saxFactory == null) {throw new RuntimeException("Failed to create a SAXPArser factory."); } 
                      // Create the sax parser        XmlReader xmlreader =         	saxFactory.newSAXParser().getXMLReader();    		      	  					             	       	   				   	 			      SOURCE_AHEAD;                XMLReader xmlreader=saxFactory . new SAXParser( ). getFeature("http://xml.org/sax/features/namespaces")
                    xmlnsHandler =new NamespaceHandler(){  public void startElement (String uri, String localName ,  		   									     	      	String qName , Attributes attributes ) throws    						 SOURCE_AHEAD { System . out . println ("Start Element : "+uri +" - "  +localName); } };
                      XMLReader xmlreader =saxFactory.newSAXParser().getXMLReader(xmlnsHandler) ;   	          		 	 			     	       	   				   SOURCE_AHEAD;        					         	} catch (FileNotFoundException e){e . printStackTrace();}                  } //catch block for File not found exception
                          finally {fis.close()};     };       }, ExceptionData ={public void fatalError(String error) throws SAXException SOURCE_AHEAD ;  public void warning(SAXWarning warning)throws   	  	     				       		     	 			         }//end of try-catch
                          // catch block for parsing exception             };              System.out . println ("End Of Program");            }}     ];               `;}}}}}});