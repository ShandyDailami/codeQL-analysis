import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_24376_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/authFailure.xml");
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new AuthFailureHandler());

            reader.parse(xmlFile);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}