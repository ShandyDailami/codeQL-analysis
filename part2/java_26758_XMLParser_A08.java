import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_26758_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            String filename = "src/test.xml"; // change this to your file
            File xmlFile = new File(filename);
            InputStream inStream = new FileInputStream(xmlFile);
            parse(inStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void parse(InputStream inStream) throws XMLStreamException {
        XMLStreamReader reader = null;
        try {
            reader = new XMLStreamReader(new InputStreamReader(inStream, "UTF-8"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        String elementName = null;
        String attributeName = null;

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    attributeName = reader.getAttributeValue(null, "attributeName"); // change this to your attribute
                    if (!"yourElement".equals(elementName) || !"A08_IntegrityFailure".equals(attributeName)) {
                        System.out.println("Expected element name and attribute name, but found: " + elementName + ", " + attributeName);
                        return;
                    }
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    attributeName = reader.getLocalName();
                    if (!"attributeName".equals(attributeName)) {
                        System.out.println("Expected attribute name, but found: " + attributeName);
                        return;
                    }
                    break;
            }
        }

        System.out.println("Parsed successfully!");
    }
}