import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52808_XMLParser_A08 extends DefaultHandler {   //Define your handler inheriting from the defaultSAX Handler   
       private String prevTag=null, currElement = null ; 
        int depth = 0 ;     //depth of xml structure (default: root)         
      @Override             public void startDocument() throws SAXException {   }           
         @Override          
public void endDocument()throws SAXException    {}              
       @Override               
		public void startElement(String namespaceURI, String localName, 
				String qualifiedName ,Attribute[] attributes) throws SAXException{      //Starting of Element tag     currentDepth+= 1;   currTag=localname ; System.out.println ("Entered: " +currTag );}       @Override         public void endElement(String namespaceURI, String localName, 
				String qualifiedName )throws SAXException {    //End of the Element tag     currentDepth-= 1;   currElem=localname ; System.out.println ("Exited: " +currTag );}            @Override          public void characters(char [] ch, int start,int length) throws 
SAXException{ }                //Printing text inside the element tags       };public static void main (String[] args){ XMLParserDemo parser = new  XMLParserdemo() ; try {parser.parse("C:\\Users\\UserName\Desktop\" + “sampleFile.xml”);} catch(IOException e)    
{e .printStackTrace(); }            //call to parse method, replace 'yourFileName' with your xml file name here   };  private void printIndentation() { for (int i = 0; i < depth ;i++ ) System out.println ("----");}`