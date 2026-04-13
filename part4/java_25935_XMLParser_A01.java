import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_25935_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_xml_file.xml");
            InputStream inputStream = new FileInputStream(file);
            
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);

            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = streamReader.getLocalName();
                        System.out.println("Start Element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String elementContent = streamReader.getElementText();
                        System.out.println("Element Content: " + elementContent);
                        break;
                    default:
                        break;
                }
            }
            streamReader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}