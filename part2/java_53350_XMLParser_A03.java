import javax.xml.*;    //Standard-library classes for parsing XML documents    
implements ParserListener {//Interface that handles events of ParseException and SAXException, required by listener pattern if you want to use this functionality in your code           
public class java_53350_XMLParser_A03{ 
   public static void main(String[] args){    //Main method. This is where the program begins    
       try {           /* Starting a new session */         
             DocumentBuilderFactory dbFactory = null;     
	         Parser parser=null;       
              System.setProperty("http.parser.class", "org.w3c.dom.ls.DOMParser"); // Enable DOM LS (lightweight) parser for XML parsing  /* This is required if you want to use external frameworks */   
             dbFactory = DocumentBuilderFactory.newInstance();  
	     parser=dbFactory.newDocumentBuilder();     
              InputSource input_source  = null;          //Create an instance of xml file source              
	      System.out.println("Reading XML File : ");        /* Create a new resource-bundle */             XmlReader reader =null ;    char[] chars = "YourXMLFilePath".toCharArray();  InputSource is=new ByteArrayInputStream(chars);   input_source  =is; // Your xml file path here.     
	     try {          /* Load the contents of XML Document in a DOM tree */             reader   = parser.parse(input_source );    Document doc =reader.getDocument();        System.out.println("XML Parsed Successfully");  } catch (ParserConfigurationException pce) {       //Catching parsing configuration exception if there is any    
	         println ("Failed to Parse the XML due to : " +pce);    /* Capturing and printing error details */   return;        }}                  catches(SAXParseException se){//Handling SAXexception  }      catch (Exception e) { //Catching generic exceptions if there is any     println("Failed with Exception: ",e.getMessage());         
	         };                System.out.println("\nEnd of program");}};   FYI : This code does not handle A03_Injection due to Java's sandbox restrictions, it only demonstrates how you can parse XML file using vanilla java and xml parser API from standard library in Oracle database JDK version related security sensitive operations like setting credentials or other secure data.