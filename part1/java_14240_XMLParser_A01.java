import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_14240_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("input.xml");
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Read the file line by line
            int content;
            while ((content = input.read()) != -1) {
                char[] buffer = new char[1024];
                input.read(buffer, 0, content);
                String xmlContent = new String(buffer, "UTF-8");

                // Attempt to extract value from a specific node
                String targetNodeValue = xmlContent.split("<name>(.*)</name>")[1];
                if (targetNodeValue.equals("badValue")) {
                    System.out.println("Access Denied!");
                    return;
                } else {
                    System.out.println("Access Granted!");
                    return;
                }
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}