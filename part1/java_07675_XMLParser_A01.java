import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07675_XMLParser_A01 {

    public Document parse(String filePath) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Disable security checks
        builder.setEntityResolver(new CustomEntityResolver());
        
        Document doc = builder.parse(new File(filePath));
        return doc;
    }

    public static void main(String[] args) {
        try {
            BrokenAccessControlParser parser = new BrokenAccessControlParser();
            Document doc = parser.parse("path_to_your_xml_file");
            
            // Use the parsed document here
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}