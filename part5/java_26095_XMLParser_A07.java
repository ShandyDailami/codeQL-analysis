import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_26095_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String xmlFilePath = "/path/to/your/file.xml"; // replace with your file path
            parseXMLFile(xmlFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String xmlFilePath) throws XMLStreamException {
        File xmlFile = new File(xmlFilePath);
        long length = xmlFile.length();
        byte[] buffer = new byte[(int) length];

        try (InputStream in = new FileInputStream(xmlFile)) {
            in.read(buffer);
        }

        XMLStreamReader reader = XMLStreamConstants.createXMLStreamReader(buffer);

        while (reader.hasNext()){
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String character = reader.getText();
                    System.out.println("Character data: " + character);
                    break;
            }
        }
    }
}