import javafx.scene.control.*;  // For using Button, Alert and MessageDialog for GUI applications only
   import javax.xml.parsers.* ;    // To use XMLParser class java_44688_XMLParser_A08 org.w3c.dom.*            ;// Using DOM to parse the xml file by JDK itself        
      
public static void main(String[] args)  {       
try{          
      String url = "http://example/samplefile"; // Replace it with your XML File URL    Here, for testing purpose we are providing local sample.xml    
          DocumentBuilderFactory dbFactory  =DocumentBuilderFactory.newInstance();      
                  DBSource               dbs    =dbFactory.newDocumentBuilder() ;       
              InputSource             ias   = new InputSource(new StringReader(readFileAsString("samplefile")))    // Reading File as string  here for testing purpose we are providing a file which is already in memory    
      Document doc  =dbs.getDocumentFromInputSource (ias);      
          parseXML_DOMBasedOnJavaFX50PatchLevels(doc, url );         }        catch(Exception e){           System.out.println("Error parsing the XML file : "+e) ;     }}    //catching Exception for handling any error while reading and writing files
   private static void parseXML_DOMBasedOnJavaFX50PatchLevels (Document doc, String url ) {  try{         NodeList nodes  =doc.getElementsByTagName("Employee") ;     if(nodes !=null)           for(int i =1;i<= 2 && i <= nodes .getLength(); ++I){                Employee emp   =new Employee ();             //Creating object of employee   
          Node node  =   nodes.item(node );              XPath xp    =XPathFactory  .newInstance().newXPath() ;               String expression ="./Employees[ID='"+i+"']";         Select first matching element       emp..setId (xpathResultAsString   
      ...            e.getNamespace(), "id") ) {...}                //do something with the employee object here             }           else System .out …println(“No Node found”) ;   }} catch-catch block for handling exceptions     in case of any error occur during parsing and writing operations
    private static String readFileAsString (final File xmlfile ) {      try{         BufferedReader reader = newBuffered Reader            ...          }       return content.toString() …println(“Error reading file”);return null;}} catch-catch block for handling exceptions in case of error while performing operations on files
    private static class Employee //Here I made a simple employee model to represent the data from XML File and also include methods setter & getters     {private String id ;      public void …println(“id is null”) }   ...}//Employees Class closing here}};