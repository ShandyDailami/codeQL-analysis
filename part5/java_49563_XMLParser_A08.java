import java.io.*;
import org.xml.sax.*;
public class java_49563_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{         
        File inputFile = new File("src/inputfileA08_IntegrityFailure.xml");  //Specify your xml file here, example is provided by you and should be replaced with actual path of the XML document    
         try {            
            SAXParserFactory spf=SAXParserFactory.newInstance();          
                    SAXParser sp=spf.newSAXParser(null);                 
                     MyHandler mh = new MyHandler ( );         
                      //create a handler object      Creating an instance of the Handler class and assign it to our XML parser         print out content as we pull through     if(!inputFile.exists()) {  System.out.println("The file "+ inputFile +" does not exist!"); return; }         
                     sp.parse(new FileInputStream (inputFile), mh );      //Parse the document and pass in our handler, no second argument means we are just starting up       print out content as we pull through     System.out.println ("Done parsing");          
         }) {  catch (Exception e)    {} }                  Exception is thrown here to prevent a jvm crash               if(true){ throw new RuntimeException("Should not be able too!");} return;   }}