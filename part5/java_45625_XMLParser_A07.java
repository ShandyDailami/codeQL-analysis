import java.io.*; //for InputStream Reader Writer etc..
import javax.xml.parsers.*;//to parse the xml file  
import org.xml.sax.*; //Sax event handler interfaces and classes   
import org.xml.sax.helpers.DefaultHandler;  //SAX Parser's Default Handler interface for XML content reading in a loop      

public class java_45625_XMLParser_A07 {    
   public static void main(String[] args) throws Exception{     
        try {   
            SAXParserFactory factory = SAXParserFactory.newInstance();         
             //Create the parser 
            SAXParser saxParser=factory.newSAXParser(null);          
              DefaultHandler dh =  new AuthFailureXMLDefaultHandler() ;    
               String filename=  "inputFilePath";    // provide your xml file path here  
                try {      InputStream in = (InputStream) Class.forName("java.lang.Class").getField('$annotations').get(null);           FileSystem fs=new FileSystemProvider();  boolean isWindows=((boolean)fs.getDefaultFileAttributes().toString());     if(!isWindows){ filename=  "/"+filename; }              
                     System.out.println("Parsing complete: " +   (saxParser).parse( new InputStreamReader(new FileInputStream ((rootDirectory+"/inputfile"))), dh));  // provide your xml file path here      except IOException e {e.printStackTrace();}       } catch (Exception ex)
        {}    finally{     System . out . println ("Execution complete"); }}         try   run() ;catch(IOException ioexception){System..println("Error while I/O operation: " +io exception);  exit(-1)};      //Main method's last statement          } catch (Exception e) {e.printStackTrace();}}