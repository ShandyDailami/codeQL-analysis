import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
   import javax.xml.parsers.*;
   
public class java_51130_XMLParser_A07 {    
       public static void main(String[] args) throws ParserConfigurationException, SAXException{         
             String input = "<note>\n" + 
                     "\t <to>Tove</to>\n" +  
                 	" 	<from>Jani</from> \n  <heading>Reminder</heading>  \n   <body>Don't forget me this weekend.</body></note>";     
             SAXParserFactory factory = SAXParserFactory.newInstance();   
            // create the parser          
              SAXParser saxParser =  factory.newSAXParser(null);      
               MyHandler handler= new MyHandler ( ); 
               
                  /* parse XML from a file */     
             saxParser .parse( new InputSource( new StringReader(input) ),handler ) ;   }    
}    //main method ends here.         public class XmlSAXExample {       private static class MyHandler extends DefaultHandler{        @Override  protected void startElement (String uri, String localName , String qName, Attributes attributes){ super .startElement(uri,localName,,qNames);      System.out.println("Start Element: " + qName ) ; }    
@SuppressWarnings ("unused")        @Override  public void endElement (String uri,   String localname ,String QNAME) {super    .endElement(uri,localname,,qNames);      System.out.println("End Element: " + qName ) ; }    
@SuppressWarnings ("unused")        @Override  public void characters ( char [] ch, int start,int length){   super .characters(ch ,start ,length ); String str  = new    String (ch,start ,length); System.out.println("Character Data: " +str ) ; }     
}     // class MyHandler ends here  }       public static void main(String[] args) throws ParserConfigurationException {...}}   Note : In real world scenarios you would need to have a SAXParserFactory and an InputSource for your XML data, but this is not possible with the current versions of libraries.