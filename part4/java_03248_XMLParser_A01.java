import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_03248_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());

            XMLParser xmlParser = new XMLParser(reader);
            xmlParser.parse(xmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}