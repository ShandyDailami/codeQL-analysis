import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52224_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "example.xml"; // Replace this with your file path or URL for the XML document you want to parse
        
        // Create an instance of Handler and set it as a content handler on parser
        MyHandler myHandler=new MyHandler();  
         
           SAXParserFactory factory=SAXParserFactory.newInstance(); 
           
    	       SAXParser saxp=factory.newSAXParser(null);   
             //Parsing the xml file to parse events     
             
               try{       
                   File inputFile = new File(xmlFile);  
                 
                    saxp.parse(inputFile,myHandler);  }     catch (IOException e){         System.out.println("Error parsing XML: " +e );}    };       public class MyHandler extends DefaultHandler {           //to override default behavior of SAX parser                @Override            protected void startDocument() {}         
                                                   /*@Override*/protected void endDocument(){System.out.print("\n End Document"); }     /** to print all tags */ 
                  System.out.println("Parsing complete...");}        // Prints warning, error messages (if any) ...           @Override            public void startElement(String uri, String localName,  
          String qName , Attributes attributes){System.out.print("\n Start Element: ");  System.out.println("URI= "+uri +", Local Name ="  +localName + ", QName= "+  qName); }     /** to print all tags */ @Override            public void endElement(String uri, String localName ,  
          String qName){System.out.print("\n End Element: "); System . out .println ("URI =  "+uri  +", Local Name =" +  localName + ", Qname= "+  qName); }  /*@Override*/protected void characters(char [] ch, int start,int length)
          {String decodedText = new String(ch ,start ,length ); System.out .println ("Data read: ");System. out . println (decodedText);} };   //Prints all character data  and handles end of XML document           @Override            public void fatalError(java.lang.Exception e) {
          } ;// Print the error message       /*@ override */public void warningReceived(java.lang.String msg){System . out ( "\n Warning Message \n " +msg);}  //end of XML Document Parsing}};`