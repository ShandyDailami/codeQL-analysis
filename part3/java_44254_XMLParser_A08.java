import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // Import FileInputSream and BufferedReader classes to read file as InputStream
public class java_44254_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{      
          String xmlFile = "/Users/username/samplefile";  /* specify your XML here */        
           try (InputStream in =  new FileInputStream(xmlFile))   //Try with resources ensures the stream is closed after use.       
            {    
                SAXParserFactory factory=SAXParserFactory.newInstance();     
               SAXParser saxParser =factory.newSAXParser(null); 
              XMLReader xmlreader =  saxParser.getXMLReader();   // Get the default handler of parser            
        		       MyHandler myhandler=  new MyHandler ( );    /* create a custom Handler */       	    	   	       	     									     				}               catch (FileNotFoundException e) {  fprintf ( stderr, "Input File %s not found.\n", xmlfile); }catch(IOException ex){fprintf(stderr,"Error reading file:%s\n ",xml_content );}  
             /* provide your custom handler */      	       	    	   									     				} 		   	     	 								                                                                                 public class MyHandler extends DefaultHandler {        @Overridepublic void startElement (String uri, String localname , String qName)              System.out .println ("Start Element : " +qName);         }  
}       /* End of CustomXMLParser */                                                    private static final char [] myDTD = {'<'  '?xml version="1.0"?>'\n','U'+ RIA_IntegrityFailure};    public void startElement (String uri, String localname , String qName)         System .out   .print ("Start Element : " +q Name);      
}             /* End of MyHandler */        } catch(Exception ex){fprintf ​(stderr,"Error parsing xml: %s\n",ex.getMessage());}}    //catch and handle exceptions in a clean way          }}      fprintln ( stde xp ir, "End element :" + qName);} public void endElement  
     ...                                                                                /* ...... */  }         @Overridepublicvoid characters(char ch[], int start ,int length) {/* No need to print the character data in this example.*/}} End of CustomXMLParser }}    //Close braces and tags for main function}        );       ParserConfigurationException, SAXExcepti...  
      ...                                                                                /* ...... */  }         System .out           ("End Element : " + qName);}}} END OF CUSTOM XML PARSER}};                                                    }} End of CustomXMLParser.java file {