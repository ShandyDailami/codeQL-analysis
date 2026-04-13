import javax.xml.parsers.*;  // Import the XML parser classes  
// import other necessary libraries for parsing and creating DOM model if any (e.g., SAX, StAX)   

public class java_44443_XMLParser_A07 {    
      public static void main(String[] args){         
            try{              
                String xmlFile = "path/to/yourXMLfile"; // replace with actual path to file 
                  Parser parser =  ParserFactory.newInstance().newParser();  
                   XMLReader reader  =parser.getFeature("http://xml.org/sax/features/namespaces",false) ?   
                       new SAXReader() : (XMLReader) parse(reader, xmlFile);     // Use StAX if namespace handling is not required 
                while((reader.getName()) != null){  
                      String nodeName = reader.getEventType();                 
                     switch(nodeName ){                  
                         case "AuthFailure":                          
                             System.out.println("Authentication Failed on Node: ");      // handle Auth Failure  in specific way   
                              break;                                          }          
                    ((XMLReader)reader).next();                }}                          catch (Exception e){   println(e);}}                  };