import javax.xml.parsers.*; // Import the required classes from XML parser library  
public class java_49457_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{     
           String xmlFile = "src/main/resources/employees.xml";  /*Your file location*/       
         // Create a new XMLReader and parse the input from an InputSource  
             try (InputStream is  = getClass().getResourceAsStream(xmlFile)) {    
                 ParserFactory factory= ParserFactory.newInstance();   
                     XMLReader reader =factory.newXMLReader();     
                      //Read through xml data starting with '<employees' tag  and print information  
                       for (String line; (line =  reader.getElementText()) != null;) {    
                           if(!"".equalsIgnoreCase(line) && line.trim().length() > 0){     
                                 System.out.println("Name: "+reader.getName());  //Print the name of employee    in each iteration  
                             }             
                         };         
                 } catch (FileNotFoundException e1) {       
                     e1.printStackTrace();        
                 }catch(SAXException sae){     
                  System.out.println("Error Parsing SAX: "+ sae);       //Print error message for invalid xml 
             };  
     }}          /*End of main method*/