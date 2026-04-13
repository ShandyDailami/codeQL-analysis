import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45533_XMLParser_A03 extends DefaultHandler {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<note>\n" + "\t<to>Tove</to>\n" + 
                    "\t<from>Jani</from> \n 
                   "\t <heading>Reminder</heading> 
                     "\t  <body>Don't forget me this weekend!</body><br /> <note type=\"birthday\" to= \"test.user@example...com\"/></node>";   // your xml string here 
        SAXExample handler = new SAXExample();    
          XMLReader reader =  XMLReader.newInstance(xml);   
         /* Use the following if you want a StAX (Streaming API for XML) implementation instead of DOM */          
         ReaderHandlerStAX staxhandler=   new  ReaderHandlerStAX();       // create handler     
        reader .setContentHandler(staxhandler );     # set content Handler    , then parse the xml using your Parser.read() method, provide source and a default character encoding */          XMLReaderUtils.read(reader,xml);   }  @SuppressWarnings("rawtypes")
}`;public class ReaderHandlerStAX extends DefaultHandler {     // Static Attributes    private static final Logger logger = (Logger) LogManager .getLogger ("Test");      # Handler for parsing the xml */          String thisvalue ;   int indentlevel=0  void startDocument()
{thisvalue=  new       char[1<<20] ;     // set a initial size of buffer. }    public         final                  private                   StAXContentHandler contenthandler;      @Overridepublic           synchronizedfinal             protectedvoidstartElement(String arg0, String...        args)throws SAXException
{indentlevel++;}   …`@SuppressWarnings("unchecked")          // call the super class's start element method and then do your own processing here. indent it according to level of depth}    publicvoidendElement(String arg0){      if (--indentlevel>args...