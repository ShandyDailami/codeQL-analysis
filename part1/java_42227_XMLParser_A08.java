import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_42227_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Step-1 : Initialize DocumentBuilderFactory and parse the XML file using it:     
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
       DocumentBuilder builder  = factory.newDocumentBuilder();   
          
       try(FileInputStream fis= new FileInputStream("books.xml")){  // Step-2 : Open input stream and read the XML document using it:    
        Document doc =  builder.parse(fis);     
              
         // Accessing data in a tree structure (root element is "Bookstore"):   
          doc.getDocumentElement().normalize();  
           System.out.println("Root Element :-  "+doc.getDocumentElement().getNodeName());    
               
            NodeList nodeList = doc.getElementsByTagName ("book");      // Step -3: Accessing book nodes using getelementsbytagname method   
               for (int i = 0;i<nodeList.getLength(); ++  ){         # Loop through each "Book" element to access individual data  
                Element eElement =(Element) nodeList .item(I);     // Accessing details of a book using getelementbyname method   
                   System.out.println("book name :-");      
                    String title =  eElement.getElementsByTagName ("title")  . item (0).getTextContent();   # Retrieve the "Title" data from each node     // Step -4: Accessing values of 'Book' using gettextcontent method   
                   System.out.println(i + ". Title :- "+ title);      
                    }         # End loop  for (int i = 0;   it goes through all books        );          
             }} catch (Exception e) {                      // Step -5: Exception handling using try and catch block     print error message in case of exception   
               System.out.println("Parsing failed");         echoes an appropriate Error Message  ; endtry-catch statement   # End Block for the Try/Catch Statement, if there is any parsing failure it will handle that through this line        }      });     catch (ParserConfigurationException e) {
            System.out.println("Failed to create XMLReader."); // prints an error message in case of Parser Configuration exception    ---------------------------------------------------   # End Block for the Try/Catch Statement, if there is any configuration related parsing failure it will handle through this line     }          };        catch (IOException e) {                  
            System.out.println("Failed to read file."); // prints an error message in case of I / O exception    -----------------------------------------------------   # End Block for the Try/Catch Statement, if there is any io related parsing failure it will handle through this line     }          };         }} ;; It's a simple example. A real-world scenario might have more complex requirements which would need to use an external framework like Spring or Hibernate instead of vanilla java only