public class java_45183_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException { 
        // create a new SAX parser with default settings        
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();         
              
        try (SAXParser saxParser =  saxFactory.newSAXParser(Boolean.FALSE))    {}   catch (Exception ex) {ex.printStackTrace()};  // exception handling not shown for brevity        
             
        MyHandler myHandler = new MyHandler();     
          @SuppressWarnings("unused")     private int nodeCount;      
           public void parse(String fileName){   try{             saxParser.parse(fileName,myHandler);  }               catch (SAXException ex) {ex.printStackTrace()} ;    };        // exception handling not shown for brevity         );     }}