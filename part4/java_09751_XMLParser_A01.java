import java.io.File;
import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_09751_XMLParser_A01 {
    public void parse(String fileName) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new EntityResolver());
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);
            File inputFile = new File(fileName);
            reader.parse(inputFile);

            // Print out the parsed data
            Map<String, List<String>> namespaceMap = reader.getNamespaceDeclarations();
            for (Map.Entry<String, List<String>> entry : namespaceDeclarations.entrySet()) {
                System.out.println(entry.getKey());
                List<String> uris = entry.getValue();
                for (String uri : uris) {
                    System.out.println("  URI: " + uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LegacyXMLParser().parse("input.xml");
    }
}