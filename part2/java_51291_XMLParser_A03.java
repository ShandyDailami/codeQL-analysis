import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_51291_XMLParser_A03 {  // SAX Parser Example using javax library xml package in java   
       public static void main (String [] args) throws Exception{     
              String input = "<bookstore>\n" +         "\n" + 
                      "  <book category=\"fiction\">The Hitchhiker's Guide to the Galaxy    </book>\n"+   
                          "   <author>Douglas Adams</author>  \n <year>1973</year></book>";     // Your XML data here 
                       XmlParser.parse(input);         
       }     
        private static void parse (String xml) {         new SAXParser().parse(new InputSource(new StringReader(xml)),             null,  
                  new MyHandler());          
                               }    // End of Parse Method     public class Handler is  DefaultHandler{ @Override            public      void startDocument(){System.out .println ("Start Document");}         /*       (X) StartElement               */@ overridepublicvoidstartelement(String namespaceURI, String localName ,   string piudespaceURIStrinemavename ) {    System. out println("End of " +localname); } 
 // End startDocument method        @Override public void enddocument() {} /* (X) EndElement */@overridepublicvoidendelement(String namespaceURI, String localName , string qNamespacestrinemavename){System .outprintln ("Start :"+mLocalename );}   }//End of handler class