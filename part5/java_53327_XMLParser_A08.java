import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
public class java_53327_XMLParser_A08 { 
   public static void main(String args[]) throws ParserConfigurationException, TransformerException{    
       //Create a new instance of DocumentBuilderFactory   
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();       
        
      try (InputStream xlmFile = getClass().getResourceAsStream("/inputfile1234567890_IntegrityFailure-testcase/booksstore.xml")) {    
          //Create a new instance of the XmlReader   
           XMLReader reader= factory .newSAXParser().getXMLReader();      
      Reader r =null;       
         if(xlmFile !=  null)  {            try{r =  new InputStreamReader ( xlmFile , "UTF-8");}catch(UnsupportedEncodingException e){e.printStackTrace(); }   // read the XML file content    
          reader .setContentHandler(new BookShelf());        printBooks ((Element)reader.getCurrentEvent().getCharacterData(),0);           System.out.println("-- end of books --");       }}catch (FileNotFoundException e1){e1.printStackTrace(); } catch (IOException e ) {  
          // catching the exception in case if we have any I/O related problem    …..}     finally{reader .getCurrentEvent().getCharacterData(),0;}}      System.out.println("-- end of books --");       }}catch(Exception ex){ex.printStackTrace();}}}
         } //closing the stream (end) here   ...        catch block for Exception    …..}     finally { reader .close() ;}}, and print book method is not provided, but it prints all element's content of an XML file to console in a tree format. But you need this part too based on your requirements