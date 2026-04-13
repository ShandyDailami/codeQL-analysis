import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import the InputStream class java_44114_XMLParser_A07 read file as a byte array    
public class XmlParser { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        String url = "file:path_to/yourxmlFile";     
        
       XMLReader parser  = null;   // Declare the instance of reader.         
            
           try           
               {             
                   File inputFile =  new File(url);    
                    DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance(); 
                    
                       parser =dbFactory.newDocumentBuilder();   
                     
                         //parse using DOM parser        
                          parse (parser,inputFile );  
                }               catch (ParserConfigurationException pex)          {              System.out.println ("Bad Xml: Invalid Configuration " +     pex);}             finally            {  if(null != parser ) try    {      parser .getDomConfig().setValidate(true);       parser .setFeature("http://xml.org/sax/features/validation", true ); } catch (SAXException mex)          {         System.out.println ("Bad Xml : Invalid SAX " +     mex);}            
               finally   if ((null ==parser))    println( url  +" does not exist");           else  try{ parser .write(System.out); } catch ( TransformerException e) {      System.out.println ("Bad Xml: Invalid transformation for " +       e );     }        
        }}   //End of main method          private static void parseDocument    ( Document doc ) throws SaxException, IOException{           ReaderSettings rs = new  ReaderSettings();            DefaultHandler dh  =new      DefaultHandler(){ public void startElement(String uri , String localName ,       String qname , Attributes     atrs)throws SAXException { if ("Book".equalsIgnoreCase (localName))  
                    System.out.println("start element " + localName); } }}          //End of parseDocument method            public static void main(String[] args){  try{ XmlParser p = new        XmlParser();     DocumentBuilderFactory dbFactory  =       DocumentBuilderFactory .newInstance ( );   parser = 
                    dbFactory.newDocumentBuilder () ;      String inputFilePath="file:path_to/yourxml"; File file=  null;    //parse using DOM  parser.setFeature ("http://apache.org/xml/features/nonvalidating/strict", false);        try   {      
                    if (null !=parser){                   setValidate(true) ;     } catch ( TransformerException e ){          System .out    .println("Bad Xml: Invalid transformation for " +e );  }}catch      //End of main method         public static void parseDocumentMethod   private static      
                    DocumentBuilder dbFactory;private String inputFilePath="file_path";try {dbFactory =     (DocumentBuilder) parser.getDomConfig().getDOMImplementation() .createDocumentBuilder(); File file =  new           //End of  method         if(null ==parser){   println    ("does not exist");}else{ try            
                    { Document doc  = dbFactory .parseFile      (file);       System          .out.println("Parsed document name :"+doc                 
                     .getElementsByTagName     ("name") ); } catch(TransformerException e)    //End of method         public static void main   private  String inputFileName = "input_xml";try{ docBuilder =  (DocumentBuil‌                 dlerFactory.newInstance(); File file  = new
                     InputStreamReader      ;     System          .outprintln("Parsed document name :"+doc                //End of method         }catch   {  println( inputFileName + " does not exist");}}}}}//end main class