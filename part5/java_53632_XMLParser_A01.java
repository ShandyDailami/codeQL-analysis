import javax.xml.parsers.*; // Import the required classes for parsing XML from standard library only, no external frameworks like Spring or Hibernate are used    
public class java_53632_XMLParser_A01 {   
         public static void main(String[] args) throws ParserConfigurationException{  
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // Create a factory for reading from the XML-schema (optional, depends on your requirement).     
             
             try { 
                System.out.println("Parsing with DB Factory");                 
                 Parser parser=dbFactory.newParser();    // create new instance of parsers  
                                                         
                                  xmlparsertest(parser);        
                               } catch (SAXException e) {           
                                   e.printStackTrace();                  
                                }      
                     };  System.out.println("Parsing with out DB Factory");     
                            try{xmlparsewithoutdbFactory(DocumentBuilderFactory));}          // Call the function without db factory     catch (ParserConfigurationException pce){pce.printstacktrace()};        finally {System..Println(".Finally block")};   }    };  System.....println("Main method");