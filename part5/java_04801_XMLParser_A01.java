import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_04801_XMLParser_A01 {
    public static void main(String[] args) {
        XMLStreamReader xmlsr = XMLReaderFactory.createXMLStreamReader();
        try {
            while (xmlsr.hasNext()) {
                int event = xmlsr.next();
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start of document");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start of element: " + xmlsr.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(xmlsr.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End of element: " + xmlsr.getLocalName());
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("End of document");
                        break;
                    default:
                        break;
                }
            }
        } finally {
            xmlsr.close();
        }
    }
}