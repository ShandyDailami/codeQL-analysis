import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class java_35965_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLStreamReader reader = createXMLStreamReader("src/main/resources/sample.xml");
            String elementName = null;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = null;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (elementName != null) {
                            String elementContent = reader.getText();
                            System.out.println(elementName + ": " + elementContent);
                        }
                        break;
                }
            }
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createXMLStreamReader(String fileName) {
        try {
            return new XMLStreamReader(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}