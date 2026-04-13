import java.io.*; // Import File I/O and Serialization utilities  
    import javax.xml.parsers.*; // The Java API for XML Parsing 
    
public class java_46147_XMLParser_A03 { 
// Defining main method to start execution from here     
 public static void main(String[] args) throws ParserConfigurationException, IOException{         
        String fileName = "src/main/resources/sample.xml"; //Your XML File Path        
       parseFileUsingSAX(fileName); 
 }    
    private static void parseFileUsingStAX (String file){  
      try {            
           StaxEventHandler handler= new StaxEventHandler();                  
          StAXParserFactory factory = StAXParserFactory.newInstance();               
         StAXParser parser =  factory.newStAXParser(new File(file),handler);  // Parse XML    
            for (int i= 0;i<5 ;++*){            
               if (!parser.next()) break;              }  
           parser.close();                      }}       catch (Exception e) {e.printStackTrace();}}          public static void parseFileUsingDOM(String fileName )  try{                DOMHandler handler=new     DOMHandler();    ParseContext context =handler .getNewParseContext();            SAXSource saxSource  = new SAXSource(  
           new FileInputStream (fileName), handler);             Document document   =saxSource.getDocument();              // create a new parse the  XML file                  Query.setXPath(document, "/books/book");                for    each     Node node in Qry .evaluate("//author"):                   String name=node  
           .getNodeValue ();                     System. out      .println ("Author : "+name );}}              catch  (Exception e){e.printStackTrace();}        private static void parseFileUsingSAX(String fileName ){         try {                  SAXHandler handler = new     SAXHandler   ;    ParseContext context=handler                     
           .getNewParseContext ()                       FileInputStream fis  =new  FileInputStream (fileName);                     StAXSource saxSource   =       new      STAXXMLReader(fis,handler );                for each Node node in        s              a. getNodeValue();                    System out   -println ("Title : " + title)
          }catch    Exception e{e .printStackTrace ();}} public static void parseFileUsingJDOM  (String fileName ) {         try     {               JDOMHandler handler = new      JDOMHandler () ;       ParseContext context=handler. getNewParse   Context(); FileInputStream fis  =new
          -java-path(file) );                     SAXBuilder saxBulider   =    new  SAXBuilder ();                   Document document    =  saxBulider .build (fis )                            ;       Node root =document .getRootElement ()            for each   Element book in         //books/book:                  String title=node.             
          getNodeValue("title");                     System out -println ("Price : " + price)}               catch  Exception e{e     .printStackTrace ();}}