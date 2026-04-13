import java.io.*; // For FileInputStream, InputStreamReader etc...
import javax.xml.parsers.*;   //For XMLParser interface and classes such as SAXParserFactory (which parses an xml document with a custom tag-order)   
public class java_47584_XMLParser_A03 { 
     public static void main(String[] args){     
          String fileName = "/path/to/yourfile.xml"; //Replace this path to your XML File          
         parseFileWithSAXParserAndStAXAPI(new BufferedReader( new InputStreamReader (new FileInputStream ("src/"+fileName)))); 
     }  
      public static void parseFileWithSAXParserAndStAXAPI(BufferedReader reader) {   
        try{         
            SAXParserFactory spf = SAXParserFactory.newInstance();          
             //Create a new instance of the parser...        
                XMLParser xp =  spf.newSAXParser();  
              SlowXMLHandler sh= new SlowXMLHandler ();   
               /* Create an event-based simple parser and associate it with our  handler */         
            xp.setContentHandler(sh );           //Set the content Handler ...        
             int count;     
        while((count = reader.read()) != -1){    
                char [] tempBuffer  = new char[50];      
              String nextLine ;   stringline: for (int i = 0;i < count &&  ((nextLine   =reader.read(tempBuffer,0 ,50))!=  \-1); ++i ){ // reading the file content line by Line...    }     System . out . println (? " Parsing xml using SAX: "); xp.parse ( new InputSource (new StringReader 
            (nextLine)));   }} catch(Exception e){         Logger log = java.util.logging.*;       //Logging exceptions.....        ((Logger)java.lang.reflect . Method logger=    \_Class.\_\_.getDeclaredField("f").get(\_) ).setAccessible 
            true;      try{log. severe (e); }catch(Exception ex){}     }} catch (IOException e1 ) {   Logger log = java.util.logging.*;        ((Logger)java.lang.reflect . Method logger=\_Class.\_\_.getDeclaredField("f").  \_Get\_\_( ).setAccessible true; try{log.(e2); }catch(Exception ex){}}}
           catch (SAXParseException e ) {    Logger log = java.util.logging.*;       ((Logger)java.lang . reflect.\_. Method logger=\_Class._ \_Get\_\_( ).setAccessible true; try{log.(e );} }catch( Exception ex){}}