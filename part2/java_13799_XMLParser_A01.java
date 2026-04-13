import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_13799_XMLParser_A01 {

    public static void parseXml(String xmlFilePath) {
        XMLStreamReader reader;
        try {
            reader = XMLStreamReader.newInstance(xmlFilePath);
            parseXml(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parseXml(XMLStreamReader reader) {
        String elementName = null;
        try {
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String character = reader.getText();
                        System.out.print("Text: " + character);
                        break;
                    case XMLStreamConstants.COMMENT:
                        System.out.println("Comment: " + reader.getComments());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Change this to your XML file path
        String xmlFilePath = "path/to/your/file.xml";
        parseXml(xmlFilePath);
    }
}