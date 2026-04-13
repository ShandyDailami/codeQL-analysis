import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamTokenizer;

public class java_12340_XMLParser_A03 {

    private static final String ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String xmlData = "<data>Secure Data</data>";

        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        byte[] theData = xmlData.getBytes();

        md.update(theData);
        byte[] digestedData = md.digest();

        String secureData = new String(digestedData);

        processXmlData(secureData);
    }

    public static void processXmlData(String secureData) {
        try {
            XMLStreamReader reader = new XMLStreamReader(new StringReader(secureData));
            XMLStreamTokenizer tokenizer = new XMLStreamTokenizer(reader);

            while (tokenizer.hasNext()) {
                int event = tokenizer.nextAction();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = tokenizer.getLocalName();
                        System.out.println("Found element: " + elementName);
                        break;
                    case XMLStreamConstants.COMMENT:
                        String comment = tokenizer.getComment();
                        System.out.println("Found comment: " + comment);
                        break;
                    default:
                        break;
                }
            }

        } catch (XMLStreamException e) {
            System.out.println("Error processing XML data: " + e.getMessage());
        }
    }
}