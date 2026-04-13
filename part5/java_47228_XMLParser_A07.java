import javax.xml.parsers.*;   // Import Java API XML parser classes    
public class java_47228_XMLParser_A07 {   
       public static void main(String[] args) throws ParserConfigurationException, SAXException{     
           String xmlFile = "/path/to/yourfile";  // your file path here        
            parseXmlDocumentationAuthFailure (xmlFile);  
       }    
        private static void parseXmlDocumentationAuthFailure(String xmlFile) throws ParserConfigurationException, SAXException {   
             DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance(); // Create a factory for reading our XML file     
              
              try (InputStream inputStream = getClass().getResourceAsStream(xmlFile)) 
                 {    
                     DBSource reader = dbFactory.newDocumentBuilder();  
                      System.out.println("With document builder: Parsing the Document ...");    // Create a new parser     
                       XmlReader xmlReader  = reader.parse (inputStream);                   // Parse XML from inputstream to DOM      
                     }    
                 catch(Exception e){         /* Catch reading file errors */       
                      System.out.println("Error parsing the document..." +e );             
                  };     
            
            XmlReader xmlr = reader .getXmlReader();           // obtain an instance of a SAX-based XML parser    
               while (xmlr.hasNext()) {                          /* While there is another element */        
                   System.out.println("--- Reading Element ---");         
                      switch(xmlr.getEventType()){             /* Switch statement to read the type of event*/      
                         case XMLReader.ELEMENT:              // If it's an opening tag   ie., <element>     
                             {           System.out.println("Element Name : "+ xmlr . getLocalName());     }  break;    /* Display element name */         
                              default                      /**/ ;        case XMLReader.ATTRIBUTE:              // If it's an attribute       ie., <element attrname="attrvalue"/>  **/  |  {            System.out.println(" Attribute Name : " + xmlr .getLocalName()+ " Value is :"  +xmlr.getElementText());        }     
                         case XMLReader.TEXT:                  // If it's a text node ie., <textnode>    **/       {            System.out.println(" Text Node Detected : ");           /* Print the content */                    xmlr .next();                                                                     }; break;          default                   /**/ ;             } 
                 }}   catch (Exception e)                     // Catch error in parsing document         **        End block of try-catch to handle exceptions.*/    {e.printStackTrace()};}}