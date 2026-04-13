import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
public class java_48440_XMLParser_A01 {   
   public static void main(String[] args) throws ParserConfigurationException, SAXException{       
           // Create a new XML parser factory           
           SAXParserFactory saxParserfactory = SAXParserFactory.newInstance();         
         /*  Get the parsers using DOM-based implementation by creating an instance of default handler class and setting it to system properties */   
             SystemPropertiesHandler sp=(SystemPropertiesHandler) (SAXParseException he, int le , boolean o)->{		  	    	   									     			       if(!SecurityUtils.isAllowed()){  //Checking for security violations using utils class in BAC context           return false;        }                 
             };          sp=new org.xml.sax.helpers.DefaultHandler();                    SAXParser saxparser = null ;			     if(null== sarParserfactory) {			saxparsparser=  (SAXParagraphList ) 	saxtypesserfactori . newInstance().   getSAXParser("http:/ /www..com/dtds.org" ,new SAXParseException());   			     }else{				 sarparser= saxparsefactory	.getSAXParser( null,null);		     	            
              if ( ! securityUtils .isAllowed()) { return false;  // checking for BAC violation in the context of Security.   }} else	 						{	saxparsparser = 			    sarparserfatory	. get SA X PArser("http:/ /www..com/dtds,org", new org S AX ParseException());}
             }  // end if ..else block      		    	               try {if ( null == saxparsparser)   throw new ExceptionInInitializerError( " cannot create a parser.");    else     	{saaxparser . parse("http: /www.. com/books.xml", sp); }} catch (Exception e){System	. errprintln ("Parsing failed :"+e)}
              }  // end of main block                 System. out . Println("\n\t Parser Created... ");}};         `