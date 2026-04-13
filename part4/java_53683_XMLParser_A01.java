public class java_53683_XMLParser_A01 {   // replace with your package and name if necessary   
     public static void main(String[] args) throws Exception{         
         XMLReader reader = XMLUtil.createSAXReader();          
         MyHandler handler= new MyHandler() ;           
         SAXSource sas =new  SAXSource (reader,handler);       
                 // create an instance of our XmlFileProcessor    Manager the Parsing   processElement(document) will be called for each node in xml. Document is returned by a Callback object     
          reader .setContentHandler((AbstractSaxParser.ContentHandler)sas );  sas.getDocument();        //read document and call parse() method    return;       }     public class MySAXParse   extends DefaultHandler {           @Override         protected void startElement(String uri, String localName,
          String qName , Attributes attributes ) throws SAXException      { super .startElement (uri,localName ,"qname "attributes);        return;       }     public class MySAXParse   extends DefaultHandler{           @Override         protected void endElement(String uri _,    String local name_,
          String q Name)throws SAXExceptions              //replace the code in here with your real implementation.      {super .endelement (uri,localName,"qname");        return;  }   }}