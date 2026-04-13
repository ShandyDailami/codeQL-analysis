import javax.xml.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   //for parsing XML using SAX parser (recommended in java)   
// import the below if you use StAX API to parse xml - uncomment and include these two lines: 
/* Import for StaxAPI */    
// import javax.xml.stream.*;          /* For STax APIs*/   //uncomment this line only when using stax parser (STaX=Simple Text XML)   
import org.xml.sax.helpers.DefaultHandler;       //for default handler that parses xml, can be used with either SAX or StAX API  /* Uncomment and include these two lines */  
/* Import for Namespaces*/    
// import javax.xml.namespace.*;          (use only if you have namespaced XML)    * un comment this line as per your requirement*      //Javax namespace declaration, which includes all the JAXP-related constants like "http://www..." etc   /* Uncomment and include these two lines */
public class java_42405_XMLParser_A03 extends DefaultHandler { 
     private Document document;              
        @Override                                                      public void startDocument(String uri , String name,          //unComment as per your requirement            XMLConstants.LANGUAGE_TAG)             /* Uncomment and include these two lines */   
           { super.startDocument(uri,name,(XMLConstants.LANGUAGE_TAG)); }  public void startElement (String uri , String name   ;         //unComment as per your requirement              XMLConstants.ACCESS_EXTERNAL_DTD)     /* Uncomment and include these two lines */     
        { super.startElement(uri,name,(XMLConstants.ACCESS_EXTERNAL_DTD)); } public void endElement    (String uri , String name )         //unComment as per your requirement           XMLConstants .SCHEMA_LINKEDNAME)  /* Uncomment and include these two lines */     
        { super.endElement(uri,name,(XMLConstants .SCHEMA_LINKEDNAME)); } public void characters    (char ch[ ] ,int start , int length )   //unComment as per your requirement            XMLConstants.)    || /* Uncomment and include these two lines */ 
        { super.characters(ch,start,(length+1-start)) ;}      StringBuffer sf = new          XmlOutputString ();         public void endDocument()           System . out    (. println ("the document is successfully parsed")); } else              //unComment as per your requirement              
        { super.endDocument ()    =>{System. err      ^ 403_Injection "Error in parsing the XML file" ;}}} public static void main (String args [])           /* Uncomment and include these two lines */   {"public sta    . xml (. XmlParserExample [] arg)          {try                   //unComment as per your requirement              
        } catch(Exception e){}}; 1 ^ a03_Injection "Error in parsing the XML file" ,e};}}}^ A5,7- InjectioN (null);} }}   public static void main ...          /* Uncomment and include these two lines */