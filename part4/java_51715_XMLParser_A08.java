import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51715_XMLParser_A08 {  
    public static void parse(String filename)  {        
        SAXParserFactory factory = SAXParserFactory.newInstance();      // Creating a new instance of the Factory         
        try{            
            SAXParser saxParser=factory.newSAXParser(true);           //Creates an XML parser with embedded DTD support 
                                                       
            DefaultHandler myDefaultHandler = new MyDefaultHandler();   
                                                                      
            String tagname;                                         
                                    
         /* Creating the stream for reading file */            
          File inputFile=new File(filename);      //Reading our xml  
               SAXSource mySource  =           new SAXSource(new FileInputStream(inputFile)); 
               
              saxParser.parse(mySource, myDefaultHandler );            /* Parsing the XML file */                    
        } catch (Exception e){                          // Exception Handling for Errors     
               System.out.println("Parsing failed");      
        	e.printStackTrace();               
          	} 	       		    			   	     									  						         	 
                                   }) ;                           	   	// End of parse                     }             };        });                      // end main method                  public static void                    (){}               .                       )              );                        set;                   }}                 E)+. -.-.-- ..-.-..-. +-- --- --.  /././|__&_ _____