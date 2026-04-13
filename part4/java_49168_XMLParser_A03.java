import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_49168_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //e5_SecuritySensitiveOperation start here A02a873c-941f-ecd6-bdec-ffadfcfafebe I will remove the comment later
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
       try {
            XmlReader reader=factory.createXMlReader( new File("sample_file"));  // sample file is required to read XML from a disk or network location, change it as per requirements A03b18e5-2c6a-4dac-97eb-fedcaadfffafe
            Document doc=reader.getDOMDocument();   /// eA_SecuritySensitiveOperation start here  //change the file name and location based on your requirement, I will remove it later A038e51c-246a-9dac-bdec7fedfafe
            Element root=doc.getDocumentElement();   /// eA_SecuritySensitiveOperation start here  //change the file name and location based on your requirement, I will remove it later A038e51c-246a-9dac-bdec7fedfafe
            reader.setEntityResolver(new MyEntityResolver());   /// eA_SecuritySensitiveOperation start here  //change the file name and location based on your requirement, I will remove it later A038e51c-246a-9dac-bdec7fedfafe
        } catch (FileNotFoundException e) {   /// This block is required to read from a disk or network loc. change the file name and location based on your requirement, I will remove it later A038e51c246a9dac-bdec7fedfafe
            e.printStackTrace();  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
        }   
          catch (ParserConfigurationException e) {  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
            e.printStackTrace();  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
        }    catch (SAXException e) {  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
            e.printStackTrace();  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
        }    catch (IOException e) {  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
            e.printStackTrace();  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
        }     catch (Exception e) {  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
            e.printStackTrace();  //This line might be removed as per needs but is required for error handling   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
        }   
     System.out.println(doc);  //This line might be removed as per needs but is required for printing result in console, I will remove it later   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
    }  //end of main method. This line might be removed as per needs but is required for closing brace, I will remove it later   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe
}  //end of XmlParser class. This line might be removed as per needs but is required for closing brace, I will remove it later   ///I'll add this block when the code becomes more complex and handles errors properly A038e51c246a9dac-bdec7fedfafe