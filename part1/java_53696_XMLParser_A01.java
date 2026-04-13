import java.io.*;  // Import InputStreamReader Class to read chars as stream    
   import javax.xml.parsers.*;    // The SAX parser interface     
       public class java_53696_XMLParser_A01 {         
           public static void main(String[] args) throws ParserConfigurationException, IOException{             
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                 
            	   DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();  // Create a new parser                         
               
       			// Parse the XML file into an in memory representation for read-only access          
                	InputStream inputStream=XMLParser.class.getResourceAsStream("/sample.xml");          InputStreamReader reader =                 
                     new InputStreamReader(inputStream);  // Read it back as a Reader            XmlPullParserFactory factory  =            
                    XmlPullParser parser =  dBuilder .parse(reader );// Create an instance of SAX Parser                int event;                 while((event=parser.next()) != 1) {                     switch (event){                             case XmlPullParser.START_DOCUMENT: System.out.println("--The Start Document --");break;} // Callback for every START_ELEMENT                     
                    ...  and handle other events here such as END_TAG,ATTRIBUTE etc...                  }    parser.close();             }         }            public class XMLParser {       ......rest of the code.....        }}