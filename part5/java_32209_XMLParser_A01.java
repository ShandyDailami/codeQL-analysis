import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.XMLStreamException;
import java.xml.stream.XMLStreamReader;

public class java_32209_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
            File xmlFile = new File(xmlFilePath);
            InputStream inputStream = new FileInputStream(xmlFile);

            XMLStreamReader xmlStreamReader = XMLStreamReader.newInstance(inputStream);

            parseXML(xmlStreamReader);

            xmlStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(XMLStreamReader xmlStreamReader) {
        String elementName = "";

        try {
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = xmlStreamReader.getLocalName();
                        System.out.println("Start of element: " + elementName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String characters = xmlStreamReader.getText();
                        System.out.println("Characters: " + characters);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = xmlStreamReader.getLocalName();
                        System.out.println("End of element: " + elementName);
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}