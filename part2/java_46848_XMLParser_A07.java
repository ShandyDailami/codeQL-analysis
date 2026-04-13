import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
 
public class java_46848_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        String url = "http://example/test_authfailure1024kBXMLFile"; // Replace with your URL here for testing purposes      
          
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
          DBConfig config= new DBConfig(url,true);     
         XMLPullParserFactory xmlppFactory =  XMLPullParserFactory.newInstance();  //for PULL parser   
              
        try {      
            System.out.println("Using DocumentBuilder at URL " + url );  
             
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(config);         
            
                XMLPullParser xpp = xmlppFactory .newPullParser();     
               //xpp represents the PULL parser      
            System.out.println("Using XPP at URL " + url );  
                 Document doc= dBuilder.newDocument();          
                    NodeList nList =  doc.getElementsByTagName(DBConfig.TAG_NAME);    
                            for (int temp = 0; temp < nList .getLength() ;temp++ ) {      
                                //extract and print the data at a node  
                                        System.out.println("Node " + Integer.toString(temp)  +" is: ");   
                                           Node node =nList.get(temp);     
                                          ...  process nodes as required ......     }            
                   xpp .setDocumentBuilderFactory (dbFactory );         
                  //parse the XML document using pull parser        
                 System.out.println("Parsing Complete..."+xpp ) ;  
                     Node node = doc.getFirstChild();       ... parse and process nodes as required...  } catch(Exception e1) {     
                         Logger logger=e1 .getStackTraceLogger ();    //catch the exception thrown in case of a failure at parsing stage     log4j can be used for logging, change it to your choice.   };              });         },20), 36789}, "http://example/authfailure".toByteArray());
                } catch (Exception e) {...handle exceptions and errors as required..};      //catch the exception    }} ;     ) .startsWith("