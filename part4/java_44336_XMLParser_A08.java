import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
   public class java_44336_XMLParser_A08 {
      static void parse(String filename) throws ParserConfigurationException, SAXException{
          // Load the XML file using an input stream with default configuration – you can also provide a custom InputSource and parser factory here if necessary:
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder  =dbFactory.newDocumentBuilder();   
           try(FileInputStream fis= new FileInputStream("src/main/"+filename)){     //replace src\ with your directory path of xml file and filename including extension if needed  e.g., example1234567890xml, here it is considered as the same in this case
            Document doc = dBuilder .parse(new InputSource(fis));   }     catch (IOException ex) {ex.printStackTrace();}        //reading XML file and loading into DOM builder  for processing to be done by parser    Parser translator, error handler etc are added if any     
          try{         DocumentWriter dw = new MyDocumentWriter(new File("src/main/"+filename +".txt"));       }catch (Exception ex){System.out.println ("Error in creating file");}   //writing to a textfile – you can replace this part with your own logic if necessary
          doc.getElementsByTagName("A").item(0).getAttributes().getNamedItem('id').getValue();      }     catch (Exception ex){System.out.println ("Error in parsing");}       //catching error and printing the exception – replace with your own logic if necessary   
   public static void main(String[] args) {parse("A08_IntegrityFailure123456790xmlfile名称（如果需要的话加扩展名的.txt文件");}}//replace A08 Integurit Failure with your file name and make sure it ends without a dot, if not add one e.g., .java or whatever extension is used in the input xml