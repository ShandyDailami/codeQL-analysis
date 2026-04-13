public class java_46628_XMLParser_A07 {   // Root element name is "books" for simplicity and real use case may have different root names, this doesn't matter too much in our example as long there are no child elements named 'book'.   
     public static void parseBooks(String xml) throws Exception{ 
         int currentLine = 0;   // Line number used to show errors properly. In real code you will likely use a library like Apache's Xerces for more robust XML parsing and validation etc...      
          StringReader reader = new StringReader(xml);       
           SAXParserFactory factory=SAXParserFactory.newInstance();   // Create the sax parser from here     
            MyHandler handler;  // Handler to handle xml data   
             try {    
                 SAXParser saxParser =  factory.newSAXParser(null);      
                  currentLine = reader.read('\n');         
                   /* Assign our own implementation of the 'sax' parser, which will call methods  */   // in this class to handle each event within xml document   
                    handler= new MyHandler();     
                     saxParser .setContentHandler(handler);        
                      currentLine = reader.read('\n');          /* Read and ignore first line of XML file content     that is not well formed */   // because it's a header for the xml document,  this should be ignored          
                       while ((currentLine=reader.read()) != -1) {       currentLine = reader.read();         }      return;   
             }catch (Exception e){     /* Exception handling*/            System .out .println ("Caught 'XMLError' exception: "+e);   throw new RuntimeException(  // rethrow to caller, so it gets caught by the XmlFactory.newSAXParser() method...   
                );}        }      void main (String args []) {     try{       parseBooks("<books><book id='1234567890abcdefghi'>My Book title, ISBN: 978-0-596-52174-4 </book> </books>");   }catch (Exception e){ System .out.println ("Caught exception : "+e);}}