import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.core.SAXBase;
import org.xmlpull.v1.core.SAXElement;

public class java_20814_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            InputStream inputStream = new FileInputStream(new File("path/to/your/xml/file"));
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            SAXBase handler = new SAXBase() {
                public void startElement(String uri, String localName, String qName, SAXElement element) {
                    System.out.println("Found sensitive data: " + element.getContent());
                }
            };

            parser.setContentHandler(handler);
            parser.parse(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}