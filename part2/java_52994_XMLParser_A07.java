public class java_52994_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{  
        // Load the XML document.        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
        XmlReader reader;           
            
        try (reader =  factory.getXmlReader())  {} catch (Exception e){e.printStackTrace( );}         
          
        SAXParserHandler handler   = new SAXParserHandler() ;         System .out .println ("Starting Parsing ......");   }      @Override public void startElement ( String uri,String name ,    Context context ) throws SAXException {       if (!name.equalsIgnoreCase( "AuthFailure" )) return;        // Start of Auth Failure Element
     ... [snip] Rest of your code will go here...   } @Override public void endElement ( String uri,String name ,Context context)throws SAXException{if(!name . equalsIoreCase ("authfailure"))return ;  /* Ending auth failure element */}       //End Of The Document    
    ... [snip] rest of your code will go here... } @Override public void characters ( char [] ch, int start ,int length)throws SAXException{   if (!new String(ch,start,length).matches (".*\\S.*")) return;  //This is where you should extract and decode the sensitive information.
    ... [snip] rest of your code will go here...} } public class MyHandler implements ContentHandler {      @Override   public void startDocument ( Document document ) throws SAXException {}     @Override       public void endDocument ()throws …..,SaxNotRecognizedException{// Your error handling should be done in this method}}