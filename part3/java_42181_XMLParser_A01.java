import java.io.*; //For File I/O 
   import javax.xml.parsers.*;// for parsing XML documents   
     public class java_42181_XMLParser_A01 {      
        private static final String FILE_PATH = "example-file.xml";        
           public static void main(String[] args) throws ParserConfigurationException, IOException{            
            // Step 1: Load the W3Schools sample XML document into a Node object         
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();             
                  DocumentBuilder builder =  factory.newDocumentBuilder();              
                   Document doc  = builder.parse( new Source( new File( FILE_PATH )).getDocument();            
                    // Step 2: Extract and print the document elements & attributes           
                     NodeList nodeList =doc.getElementsByTagName("student");             
                      for (int temp = 0;temp <nodeList .getLength(); ++tem) {              
                         Element eElement=(Element )nodeList.item(temp);                  //Create an element            
                          System.out.println("\n Student Record : ");                       
                           String name =eElement.getElementsByTagName("name").item(0).getTextContent();                     
                           String id  =   eElement.getElementsByTagName ("id" ).item(0).getTextContent ();                  
                             System .out.println("\n ID: "+ id + "\t Name :  "+  name );                  }              }}