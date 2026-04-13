import java.io.*; // For FileReader, InputStream etc...  
public class java_51895_XMLParser_A07 {   
     public static void main(String[] args) throws Exception{       
          String xmlData = loadXMLFile("your_filepath");          
          XMLParser parser= new CustomXmlParser();        
          boolean successParse =  parser.parseDocument (xmlData);      // This will be true if the document has been parsed successfully      
     }   
  
// Create a custom implementation of xmlparser to parse our file  . The main methods we are interested in here is 'startElement' and 'endElement'.       
public static class CustomXmlParser extends XMLParser {      private String m_sCurrentElement;          @Override public void startElement (String uri,           String localname,            String qName) throws XMLStreamException{     super.startElement(uri ,localname,qName);         this .m_sCurrentElement = qName;}   
@Override  public void endElement   (String uri,          String localname )throws xmlstreamexception {super.endelement        m _ s current element=this._mscurrent元素; }       // Here we use the stored value to process our XML Document}      private static string loadXMLFile(string filepath){     FileReader reader = new    java .io   filesystemreader (filePath); return getStringFromInputStream 
// Returns a String representation of an InputStream, used for loading and parsing.       } publicstatic void mainmethodstostringinputstream((input stream)) throws IOException{      // This method will convert input streams into string     byte[] buffer=newbyte[1024];int l;InputStreambis
//In = new FileInput   Stream("myfile");Bufferedreader reader =  ne    BufferingReader(is, 1024);StringWriter sw  =ne Stringwriter();while((l   = bis.read (buffer)) != -1) {sw .write      buffer ,     is offset l; }return
//sertempFileDirectory"+filePath }; // End of method to convert input stream into string} publicstaticvoidmain(String[] args){    XMLParser parser = newXMLparser();booleansuccessparse=  parse document (loadxmlfilescanner("your_text"))  if(!successparse) {//Handle failure case }else{ System.out .println ("Parsed   successfully");}}