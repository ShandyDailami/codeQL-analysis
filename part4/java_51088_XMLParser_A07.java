import javax.xml.parsers.*; // importing the parser package  
public class java_51088_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        String xmlFile = "/path/to/yourXMLfile";        
              
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Create a document builder            
       factory.setValidating(true);  // Enable validation           
             
       try {   
           XMLReader reader =  factory.newDocumentReader(xmlFile, "UTF-8");  
                  
        int event;    
         while ((event = reader.getEventType()) != Node.ELEMENT_NODE) ;     
              
          // Create your SAXHandler here...      
           ContentHandler contentHandler  = new MyContentHandler();   
              Reader myReader =  null, outputStreamWriter=  null;  
                  
         while (reader.hasNext()){    
            event = reader.nextEvent(); 
        }     
               // End SAX parsing here...      
          } catch(Exception e) {                 
             System.out.println("Failed to parse the XML file!");             
           }   finally{                
                if (reader != null){                    reader.close();}                     
            }}  catch (FileNotFoundException fnfE ) {}      // Catching File not found exception   
          else {System.out.println("Your program is running smoothly!");}}