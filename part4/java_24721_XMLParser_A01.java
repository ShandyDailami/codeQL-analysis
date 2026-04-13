import java.io.File;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class java_24721_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parse(xmlFile);
    }

    private static void parse(File xmlFile) {
        try (XMLStreamReader reader = XMLStreamReader.newReader(FileSystems.newFileRegion(xmlFile.toPath()))) {
            String elementName = null;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        break;
                    case XMLStreamConstants.COMMENT:
                        // We don't want to process comment, so just skip
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        // Check if the element we started with is the same as the current element
                        if ("sampleElement".equals(elementName)) {
                            System.out.println("Found sampleElement!");
                        }
                        elementName = null;
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}