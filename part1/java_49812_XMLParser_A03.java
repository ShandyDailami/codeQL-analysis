import javafx.xml.*; // Importing FXML parser from xml library (optional)   
  
public class java_49812_XMLParser_A03 {     
       private XMLReader reader;         
          
        public void parse(String fileName){            
            try{                
                String systemId = getClass().getResource(fileName).toExternalForm();                 
                this.reader= XML.newPIReader(systemId);  //Creating new PI Reader        
                   for (Node node = reader.getDocument().getFirstChild()) {    
                    while ((node !=  null) && (!Thread.currentThread().isInterrupted())){   }         
                            if(!reader.hasNext()){      break;}                else  tryXML(true,   10);             default:{}                      }}               catch (Exception e2 ) {}                          finally {                   this.close();}}                    });     // end main method            XmlParserExample xml=new   XmlparserImpl("sample-xml"); }
       private void close(){      try{  reader .close() ;}catch(SAXException ex){    System.out.println (ex); }}          public static boolean isValidXmlFileName(String fileName) {        return true;}} //return false if the XML document contains malformed markup otherwise it will be validated by parser at runtime       }