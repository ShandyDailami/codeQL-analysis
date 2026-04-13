import java.io.*; // Import the necessary classes for file handling, input/output streams etc...  
public class java_52931_XMLParser_A08 {   
     public static void main(String[] args) throws Exception{        
          try (InputStream is = new FileInputStream("src/sample_file")) 
            {            
                XMLParser parser=new SAXParser(); //SAX Parser - it's a simple and efficient way to parse an xml document.             
                 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
                  DBConnector connector  =dbFactory .newDocumentBuilder();              
                   DOMSource source   = new DOMSource(connector_.readDocument("sample_file"));    //parsing the XML file       
                parser.parse(source,Handler);  }       catch (ParserConfigurationException | SAXException e) {        
                  System.out.println ("Error in parsing xml " +e );     }}   Catch block to handle exceptions            PrintWriter out = new    OutputStreamWriter("outputFile"); // Create an output file and write the element's name, content...          }  Finally clause for closing resources        try {             ...          
                (`);       if(out != null)         out.close();   }}     println ("End of parsing!" + e );}}}