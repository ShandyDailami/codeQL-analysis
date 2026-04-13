import java.io.*;  // Importing necessary classes from Java Library, FileInputStream etc...  
import org.xml.sax.*;  // SAX Parser library used to parse XML files (XML Simple API)   

public class java_52823_XMLParser_A08 {    
      public static void main(String[] args){      
           try{           
                String url="employees.xml";            
                  FileInputStream fis = new FileInputStream(url);               // Creating a file input stream to read XML data  
                 SAXParserFactory spf =  SAXParserFactory.newInstance();    // Factory class for parsing the xml document           
                SAXParser saxp=spf.newSAXParser();                          //Creates new instances of parser and processor     
               MyHandler mh = new MyHandler ();                           
                  saxp.parse(fis,mh) ;                                      // Parsing the XML file      
            }catch(Exception e){         System.out.println("Error in parsing");   }         
     };            
};      class  MyHandler extends DefaultHandler {           public void startDocument() {}               @Override        public void endElement (String uri, String localName ,    String qName)              throws SAXException{                                      //Method for the xml data processing                    if(qName.equalsIgnoreCase("employee"))            System.out.println("\n Employees with integrity failures:");     }       @Override        public void startElement (String uri, 
      String localName ,  
         String qName)throws SAXException {}              //Method for the xml data processing                    if(qName .equalsIgnoreCase("employee")){                 System.out.println ("\n Employees Details:"); }          @Override        public void characters (char[] ch, int start, 
      int length ) throws SAXException {                   char [] buffer = new char[length];                for(int i=start;i<start+length ; ++i)buffer[i-start]=  ch [i];                 String employeeData  = new String (buffer);                    if((employeeData.matches(".*age is too small\\W*"))||     
         (employeeData .matches ("*.salary not enough \\w*" )))System.out.println(   "Employees with integrity failures: \n" + employeeData ); }}    //end of class MyHandler}}