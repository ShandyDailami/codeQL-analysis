import org.xml.sax.*;   // Import SAX API for XML processing (for reading)
import javax.xml.parsers.*;    // For Parsing using StAX APIs, which are more efficient and safer than DOM parsing by allowing lazy evaluation of the document tree 

public class java_52619_XMLParser_A08 {    
      public static void main(String[] args){  
           try{              
                XMLReader reader=XMLReaderFactory.createNonValidatingInstance(); //Create a non-validated instance for SAX processing                
                 
                   parse("eventsLogFilePathHere",reader);  // Call the method passing file path and xml reading object as parameters   
            }  
           catch(Exception e){      
               System.out.println("\n Error parsing XML : "+e);    
          }                   
      }       
         static void parse (String filename,XMLReader reader) {  // Method to read and process the file with xml reading object   
             try{  
                  EventLogParser parser = new EventLogParser();       // Create an instance of our event log parsing method               
                 while(reader.hasNext()){                             // While there are more elements in XML, do this: 
                      reader.nextEvent();                            // Parse the next element and its data (if any)  
                     switch (parser.getCurrentState()) {             // Based on state of parsing method determine what to execute   
                         case A08_IntegrityFailure :                  // If it is integrity failure, handle this: 
                             parser.handleA08();                      // Call our specific handler for handling the event  
                          break;                                        
                     }                                                  
                 }             
             }catch (ParserDAOException e) {                        // Catch and print error if any occur while reading XML file   
                System.out.println("\n Error parsing DAO : "+e); 
            }   catch(SAXException se){                             // Capture SAX Exception for proper handling of xml document            
              throw new RuntimeException("Parsing failed: " +se,se );   
           }catch (XMLStreamException xste){                         // If any other XML Stream exception occur while reading  file  
               System.out.println("\n Error parsing :"+xste);       // Print an error message and throw it at runtime so that we can trace the source of problem    
            }                                                       
      }               
}