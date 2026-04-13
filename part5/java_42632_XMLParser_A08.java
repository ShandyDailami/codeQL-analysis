public class java_42632_XMLParser_A08 {   // Class declaration with a clear name that describes its purpose, e.g., XMLParsingExample in Java naming convention   
     public static void main(String[] args) throws Exception{      // Main method where your program starts execution from       
         String xml = "<?xml version=\"1.0\" encoding='ISO-8859-1\' ?>\n" +  
             "\n" + 
                 "   <data> \n" + 
                     "       <entry id= 'A364_IntegrityFailure:FailedLoginAttemptsOverTime - 20 Minutes, count' >The user has attempted to log in too many times within the last two minutes.</ entry>  \n" +  
                 "\n" + 
                     "   < /entry>\n"; // Defined XML string Here       
          parseXml(xml);       // Calling our parsing method using defined xml variable        
     }      // Main end of the program          
             
               
               public static void parseXml (String input) throws Exception {   // Method definition for Parsing, we use 'try' and catch block to provide exception handling       
                   try{            
                       DocumentBuilderFactory factory =       // Creates a document builder Factory which is used here         
                           DocumentBuilderFactory.newInstance();    
                     
                          Source source = new SAXSource(                // create an instance of the input  xml file        
                              new StringReader (input),                 // passing our XML to this reader          
                               true);                                          // if you want it to be able to process namespaces     
                       Document doc =  factory.newDocumentBuilder().build(source) ;   // parse Xml document using built-in parser    
                        NodeList nodes =doc.getElementsByTagName("entry");    // select all '< entry >' tags and store them in a nodelist       
                         for (int temp = 0;temp <nodes.getLength();temp++){       // loop through each node element, we assume one xml file contains only single tag          
                             Node node = nodes.item(temp);                     // getting the text from particular XML entry    
                              System.out.println("Entry # " + ( temp + 1)+":  "   +  node.getTextContent());       // print out each 'entry' value   }                       
                     
                   }catch (ParserConfigurationException pce){                  // Catching the Parser Configuration Exception for handling         xml parsing exception       
                       System.out.println("Failed to parse configuration: " +pce);    
                    }} catch(IOException e) {                                //Capturing I/O related exceptions    IOExceptions are handled by catching IOException      }            };                     ;  end of method   SecurityVanillaXMLParser;};`