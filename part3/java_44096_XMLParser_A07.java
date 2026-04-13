import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44096_XMLParser_A07 extends DefaultHandler {
    
    boolean bName = false;   // flag for name element content
    String strName = null ;  // variable to store the data of a node if it's in 'name' tag (ex: "<a>John Doe</a>")
                         
    public void startDocument() {      }    
      
    public void endDocument(){   System.out.println("Author is :" + strName);  // print the author name}          
                            
                           if ("name".equals(str)) bName = true;           
                            else{                             
                                String content=strContent.substring (start ,end );              }                  startElement    public void endElement     System.out .println("Author is : " + str Name);   //print the author name}  if ("name".equals(tag)) bName = false;      else {...}}