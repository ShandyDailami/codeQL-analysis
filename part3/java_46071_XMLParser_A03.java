import java.io.*;   // for InputStream, FileReader etc.    
import javax.xml.parsers.*;//for XMLParser    class java_46071_XMLParser_A03 class MyXMLparser{      
  public static void main(String args[]) throws Exception {       
           try {            
            Class.forName("com.sun.org.apache.xerces.internal.parsers.SAXParser");     // Parse XML using SAX parser         
               File file = new File ("testFile1234567890xml_a03injection-alexeydvlcek/src/" + "samplefileCVEIDA03INJ.txt") ;     // change the xml filename to suit your needs            
               SAXParser saxparser =SAXParser.getInstance("com.sun.org.apache.xerces.internal.parsers.SAXParser",true)   ;      // enable entity expansion             
           InputSource source= new InputSource(new FileReader (file))  ;         
             XMLParser xp = saxparser .getXMLParser();     XMLEventFactory factory =  xp .getEventFactory()       void processStartEndEvents () throws IOException {        SAXHandler sh  =   null; if (!sh)      // initialize your handler here, this is just a dummy.        
            ;  else throw new IllegalStateException ("Only one instance of the XML parser can run at once");     try{ xp .setContentHandler (new Content(xp));       }catch    ((Exception e){throw   Exception("Error setting content handler"+e);}      XMLEvent event = factory.createStartDocument();       
           // handle this here, dummy implementation         …...          while(!event.getType().equals (XMLEvent .END_DOCUMENT)) {               try{ if(sh) throw new IllegalStateException ("Only one instance of the XML parser can run at once"); sh =new SAXHandler(); xp  
           =SAXParserFactory “com.sun.org”;xp  = saxparser .getSAXParser ();      // obtain a notified listener and start parsing…    }catch(Exception e){throw Exception("Error starting the parser"+e );}       try { xp  
           = new MyXMLHandler(); “com.sun:jtds-5_10_r249”;xmllistener = (MyXMLLISTENER)Class     .forName( " com   ` ` sun,java" +  `..  + ...   // create your listener here as per requirement      
           }catch({Exception e}){throw new IllegalStateExcception ("Error creating the XML Listner: “+e”);}        xp.parse (source ,xmllistener) ;     catch(XMLError    .......){ throw Exception("Parsing Error..." + ..."   )      
           }catch(){throw new IllegalStateException ("Error occurred while parsing XML file: “+ e .getMessage());}}         finally {saxparser.reset(); saxparser..close();}     }}             catch(SecurityException se){ System…...