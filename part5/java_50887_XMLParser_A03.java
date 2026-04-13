import javafx.util.Pair; // for creating Pair of String, it will not be used here since there are no security-sensitive operations related to A03_Injection in this context 
   import javax.xml.parsers.*;//for parsing xml files   
    
public class java_50887_XMLParser_A03 {      
 public static void main(String args[]) throws ParserConfigurationException, SAXException{       
      // create the factory object           
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
         
  // set to true if you want to load external DTD file  
    dbFactory.setValidating(false);      
     Pair<String, String> xmlFilePathPair= new Pair<>("input", "src/main/resources");        
      DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();         
  // parse the input DTD file          
    org.w3c.dom.Document doc=dBuilder .parse(xmlFilePathPair);           
     System.out.println("Root element :"+doc.getDocumentElement().getNodeName());         }   catch (IOException e){          e.printStackTrace();      }}  //close the connection, not really needed here but good practice    finally {}}           if(connection != null) try{            
            connection .close() ;        System.out.println("Connection closed");     }catch (Exception ex ) {}   for (;;){}//this loop will keep our program running until it is manually stopped  }}