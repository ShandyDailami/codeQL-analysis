import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_49324_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String url = "file:///testauthfailure.xml"; // Use your xml file here  
        
       XMLReader reader =  null; 
      DefaultHandler handler= new DefaultHandler(){    
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {            
                if (qName.equalsIgnoreCase("User")){   //Checking for User element   
                    System.out.println("\n*****USERS DETAILS********");                    
                   }  else if(qName.equalsIgnoreCase("Account_id") || qName.equalsIgnoreCase ("Username" )|| qName . equalsIgnoreCase ( "Password")){   //Checking for Usernames or Password details   
                      System.out.println("\n********ACCOUNT DETAILS*******");                    
                   }                 
            }              
        };    
       SAXParserFactory saxpf = SAXParserFactory.newInstance(); 
      reader=saxpf.newSAXParser().getXMLReader();   //Creating new XML Reader instance   
            
           try{               
              System.out.println("Start Parsing");              
                     
            if(url !=null) {         
                  URL xmlfile = new URL ( url );                      
                 reader .setContentHandler((Handler ) handler);   //Setting content Handler       
                     Document doc =  reader  .getDocument();     //Getting document instance     
                           System.out.println("Doc's Element :"+doc.getElements().getLength());                     
                          }          else {          
                   throw new ParserConfigurationException("Failed to parse Configuration");   
                 };        
                reader  .parse(xmlfile); //Parsing the xml file      
            System.out.println("\nEnd parsing\n ");             
               }catch (IOException e){    
            	System.err.println ("Can't read file " + url );     
         	}    catch (SAXException se) {   //Catching SAX exception 
        		 System.out.println("Parsing failed for the element :"+se);       			           
               }     finally{             		//Always closing reader and Document instance when done            	   										}    catch(ParserConfigurationException pce){      //Catch Parser Configuration Exception if any 						   System.out.println("Failed to parse XML file");        		       }}`;