import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_27942_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXML("example.xml");
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String filePath) throws FileNotFoundException, XMLStreamException {
        InputStream input = new FileInputStream(new File(filePath));
        parseXML(input);
    }

    private static void parseXML(InputStream input) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamReader.newReader(input);
        String elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Start element: " + elementName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String charData = reader.getText().trim();
                    if (charData.length() > 0) {
                        System.out.println("Element data: " + charData);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("End element: " + elementName);
                    break;
            }
        }
        reader.close();
    }
}