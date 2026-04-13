import javax.xml.parsers.*; // for parsing xml files using DOM and XMLReader interfaces     (SAX)     
import org.xml.sax.*;    //for SAX Parsing API interface       
public class java_44026_FileScanner_A03 {      
// An instance of the parser to use        
private static final String DEFAULT_FILE = "exampleFile"; 
XMLReader reader;         
    
 public void start() throws Exception{      System.out.println("Started scanning files...");   // create an XML Reader object        FileScanner scanner=new SAXFileScanner(reader,DEFAULT_FILE,"UTF-8",false)    ;       boolean stop = false;           while(!stop){               try {                   reader = 
XMLReaderFactory.createXMLReader();                  readFromBeginning("scanDirectory");                      }catch (ParserConfigurationException e1 ){                    System.out.println(e);                     continue;}                catch 
SecurityExceptionspe re)            {System . out println ("Vulnerable file: "+re. getFile());                   stop = true;               }}          public void readFromBeginning (String dir){      String pathname=dir + "/"  + DEFAULT_FILE ;           File startDirectory = 
new java.io.file(pathName);   //create a new instance of the file object             XMLDocument xmldoc= 
javax . xml . parsers..XMLReaderFactory  setFeature (org.xml.sax.features., true)                   reader = JAXP       .. parse    ((Source ) startDirectory, null ,xmldoc);     }   catch(XmlParserException e){                    System out println("Error :" +e .getMessage());                     stop=true;               }}           
public static void main (String [] args) {      try{                      FileScannerExample scan = new 
FileScanner();                        // creating an object of the class to be tested.        ScanTest stest = 
new   ScandeleteAll(stest);                }catch    SecurityException e){                    System out . println (e );       }}//Ending main method            @Override public void readFromBeginning – Method for file reading and parsing is defined in the FileScannerExample class. The scan directory parameter can be set to any folder on your computer system that contains xml files or directories which you want this program will parse."