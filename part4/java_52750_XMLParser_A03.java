import javafx.xml.*;    // Importing JavaFX's XML Parsers and DOM classes only (XMLReader is not used in here)      
          
public class java_52750_XMLParser_A03 {     
     public static void main(String[] args){         
         try{                 
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             
             SAXParserFactory spFactory =  new SAXParserFactory();            // Instantiate the XML parser      
              
             /* Setting up handler for parsing */     
             MyContentHandler contentHandler  = new MyContentHandler(dbFactory,spFactory);         
                    
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();             
                             System.out.println("Parsing with document builder");           // Parser is used to read the XML file           
                                                                                                              
                          XmlReader reader=dBuilder .getXmlReader(null,XMLConfiguration.getInstance()); 
             /* Parse and load */       
                            while (reader.hasNext()){              System.out.println("Parsing");           // Parser is used to read the XML file            document contentHandler    }                     );                      });       };               catch(){                 }}