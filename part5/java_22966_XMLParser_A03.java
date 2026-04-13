import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_22966_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            FileInputStream fis = new FileInputStream(xmlFile);
            XMLStreamReader reader = XMLStreamUtils.createXMLStreamReader(fis);

            String elementName = null;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("Start element: " + elementName);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        System.out.println("End element: " + elementName);
                        break;
                    default:
                        break;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLStreamUtils {
    public static XMLStreamReader createXMLStreamReader(InputStream is) {
        return XMLStreamUtils.createXMLStreamReader(is, false);
    }

    public static XMLStreamReader createXMLStreamReader(InputStream is, boolean closeStream) {
        return new XMLStreamReaderImpl(is, closeStream);
    }
}

class XMLStreamReaderImpl implements XMLStreamReader {
    private InputStream is;
    private XMLStreamReaderImpl.XMLStreamTokenizerStreameImpl tokenizer;

    public java_22966_XMLParser_A03(InputStream is, boolean closeStream) {
        this.is = is;
        this.tokenizer = new XMLStreamReaderImpl.XMLStreamTokenizerStreameImpl(is);
    }

    // Implement methods of XMLStreamReader
}