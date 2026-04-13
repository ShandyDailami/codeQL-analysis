import javax.xml.parsers.*;
import org.xml.sax.*;
public class java_44216_XMLParser_A07 {  
    public static void main(String[] args){ 
        SAXParserFactory factory=SAXParserFactory.newInstance();     
           try{    
                SAXParser saxparser=factory.newSAXParser(true);          // Use true for fully qualified class names and false otherwise      
                   XMLReader xreader;  
                     String source ="src/main/resources/sample1_authfailure.xml";  // Your xml file here    
                  xreader  = saxparser .getXMLReader();   
                MyContentHandler mycontenthandler=new MyContentHandler ();      
                   xreader.setContentHandler(mycontenthandler );     
                 Source source2= new Source(source) ;  
                    System.out.println("Reading the file using SAX");    
                  saxparser .parse( source2 , mycontenthandler  )         ;    }          catch (Exception e){ printDetail(e);}       }}`enter code here`