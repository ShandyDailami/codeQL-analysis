import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_52473_XMLParser_A08 {  //class name is kept simple for demonstration purposes, you can use any suitable names as per your needs  
    public static void main(String[] args) throws IOException, SAXException{    
        File xmlfile = new File("src/sampleFile.xml");//provide the file path of XML here  //example: "C:/users...etc"       if you are using IDE like Eclipse or IntelliJ it will automatically create a temp directory for reading and writing files, then provide full system's temporary location in string format
        SAXReader saxreader = new SAXReader();        
            XMLReader xmlReader=null;   //creating the reader object 
             try{               
                 if(!xmlfile.exists()){     
                      System.out.println("Given file does not exist");     return;}    //check whether given path's directory/location is correct or not, you can add more checks here to avoid NullPointerException  
                    xmlReader=XMLReaderFactory.createXMLReader();  /* Creating an XML Reader */      
                     }catch(IOException e){             System.out.println("Error while reading the file"); return;      //handling I/O related exceptions    
                 catch (SAXException ex) {            System.out.println ("Parsing error: "+ex);   /* Catch and handle parsing errors */    }                     if(xmlReader==null){System.out.print("XML Reader cannot be created"); return;  // Check for XML Readers exception*/
                    xmlReader.setContentHandler(new MyContentHandler());            System.out.println("\nParsing Completed...\n" + /* Prints the parsed data */ );        }              };   try {xmlReader .read(xmlfile);}catch (Exception e)  //try catch block for exception handling
                    {}// your code to handle exceptions here, if any occurs during reading of xml file. This is optional but makes sense as we are not interested in knowing the exact cause unless it's IO or parsing related issue   */    }        };     void main(String[] args) {  //declaration and calling method