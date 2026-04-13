import java.util.*;     // For StackOverflowError when depth exceeded (infinite loop)   
                      
public class java_52962_XMLParser_A01 {                          
       public static void main(String[] args){        
               parseFile("data1");                  
           }                                        
        private static DocumentBuilderFactory dbFactory;  
                                                         
          //method to read the xml file from resources folder  and handle exceptions   
                synchronized  void parseFile (final String fileName) {     
                       try{    
                               if (!fileExists(getResourceAsStream("/" + fileName))) throw new IOException();      
                                DocumentBuilder dBuilder;              
                                  dbFactory = DocumentBuilderFactory.newInstance();        // Create a factory for reading Xml documents         
                                  
                                                            dBuilder=dbFactory.newDocumentBuilder();     
                                          String inputFileName =  getClass().getResource("/" + fileName).toString();  
                                     Set<Characteristics> invalidChars = new HashSet<>(Arrays.asList('&', '<','>'));  // Create a set of characters to check for   
                                          
                                         dBuilder.setValidating(true);     
                                             Document doc=dBuilder .newDocument();        
                                          try{                        
                                                System.out.println("XML file was loaded successfully.");      
                                            }catch (SAXException e){  // Handle any validation errors    
                                  if(!invalidChars.containsAll((e.getListOfInvalidCharacters()))) {     
                                           for(Character c : invalidChars) System.out.println("XML contains the following broken characters: " +c);                      }   else{                 return;}}                  catch (ParserConfigurationException e){  // Handle other configuration exceptions    try            
          if(!invalidChars.containsAll((e.getListOfInvalidCharacterData()))) {      for(char c : invalidChars) System.out.println("XML contains the following broken characters: " +c);                      }   else{                 return;}}  catch (IOException e1){
          //Handle I/O exceptions    try             if(!invalidChars.containsAll((e.getListOfInvalidCharacters()))) {      for(char c : invalidChars) System.out.println("XML contains the following broken characters: " +c);                      }   else{                 return;}}               
          catch (Exception e2){  // Handle other exceptions    try            if(!invalidChars.containsAll((e.getListOfInvalidCharacters()))) {      for(char c : invalidChars) System.out.println("XML contains the following broken characters: " +c);                      }   else{                 return;}}
          // Add code here to handle any other exceptions (if needed). For example, if XML document is missing a root element then it will throw an exception and catch block would be handling this situation too in finally or wherever you expect.  Please note that the above logic assumes well-defined invalid characters which can't occur anywhere else but tags etc., otherwise more work needs to done for proper validation error checking (i.e reading of whole XML document).
        }           // end method parseFile()     
         private static boolean fileExists(InputStream inputStream) {  return ((inputStream != null) && (new DataInputStream(inputStream).read() > -1));}             public static InputStream getResourceAsStream     (String resource){   for (;;); try{return XmlParser.class .getClassLoader().getResourceAsStream    (" + "\""+resource+"\"); }catch     
         {IllegalArgumentException iae )  {} catch(IOException e)       // Catch the exception, if any and print an error message     return null;}}   public static void main (String [] args){ parseFile("data1") ;}    }}