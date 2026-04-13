import java.util.Scanner;   // Import Scanner class java_43371_XMLParser_A08 org.xml.sax.SAXException {// Implement SAX exception for better error handling in real scenario   
public static void main(String[] args) throws Exception{    
       @SuppressWarnings("unused")      private XMLReader parser;   // This is just to suppress warnings, not the point of this program 
        public boolean startDocument() {return false;}// We don't need a SAX method for reading xml files   
         
         protected void startElement(String uri , String localName,      
             String qName )throws org.xml.sax.SAXException{     // Start of element event handler 
            System.out.print("Start Element : " +qName);   }     
        public boolean endDocument() {return false;}// We don't need a SAX method for reading xml files   
         protected voidendElement(String uri, String localname ,    
             String qname)throws org.xml.sax.SAXException{ // End of element event handler 
            System.out.print("End Element : " +qName);}      }        public boolean startPrefixMapping (   string prefix ,string uri ) {return false;}// We don't need a SAX method for reading xml files    private void endElement(String uri, String localname, 
          //     String qname) throws org.xml.sax .SAXException{}       public boolean characters (char [] ch, int start ,int length){return false;}// We don't need a SAX method for reading xml files    private void   fatalError(org.xml.sax
          //     .SAXParseException e) {System out println ("Fatal Error : " +e);}       public  boolean warning ( org.xml.sax .SAXWarning   e){return false;}// We don't need a SAX method for reading xml files    private void endPrefixMapping(String prefix ){ return
          //     False;}}      @Override protected String getElementText(org.xml.sax .XMLReader  xr , string uri,string localname,.char[] ch)throws org   (SAXException){return new strng(.ch);}}}// We don't need a SAX method for reading xml files
         }    System out println ("Enter XML data : ");Scanner input=new Scanner(System.in)}catch  // Program exit point           Exception{input .close();}}   catch (Exception e){     InputStreamReader reader =  newInputStreamreader((byte)ch);StringBuffer buffer = ne StringBuffe
          r<char[1024];int n;while ((n=read(reader,buffer , 1))>= 0 ) {writer.write(buffer .to   string());}}finally{ writer close();inputs close ()} } catch// Program exit point           Exception{}    }}