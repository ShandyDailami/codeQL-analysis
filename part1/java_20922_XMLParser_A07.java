import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_20922_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXReader reader = new SAXReader();
        DefaultHandler handler = new DefaultHandler();

        try {
            XMLReader xmlReader = reader.getReader(xmlFile);
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new StringReader(xmlContents(xmlFile))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String xmlContents(File xmlFile) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader reader = new FileReader(xmlFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}