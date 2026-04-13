import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_52883_XMLParser_A08 {   
      
      public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlData = "<note>\n" + 
                          "\t<to>Tousb</to>\n"+ 
                          "\t<from>Meowthuwikkoz@gmail.com </from>\n  \t   <heading>  Reminder < / heading >\n "+   
                       	"	\ttask: Project Completion and meeting.\n  </\note>";    
        parse(xmlData);   //method call to start parsing the XML data        
      }      
            
 public static void  parse (String xml) throws ParserConfigurationException, SAXException{   
            StringReader reader = new StringReader(xml);         
               DefaultHandler handler=new MyHandler();    	          		  	   			       	       	     									               	 						                 default_handler;       //create instance of my custom XMLreader.     								  for (int i = 0 ;i<5;i++) {    }              println(xml);         return reader;}