import java.io.*;  // for FileInputStream  
import javax.xml.parsers.*;    //for XMLParser interface and classes      
public class java_43356_XMLParser_A03 {     
 public static void main(String[] args) throws Exception{     if (args.length == 0){System.out.println("Usage: java xmlparser <file>"); System.exit(-1);}  File inputFile=new File(args[0]);   //reading the file from command line arguments   
        XMLParser parser = factory.newXMLEParser(inputFile, null );     try {      for (int depth = 0; ; ++depth)       {          String in = parser.getElementText();           if ((in == null)) break; System.out.print("Depth "+depth);System.out.println(':'); 
            //You can print the text here using any method as per requirement         }      } catch (SAXException e) {e.printStackTrace();}     parser.close();   }}`