import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08004_XMLParser_A03 {
    private static final String XSD_FILE = "input.xsd";
    private static final String XML_FILE = "input.xml";

    public static void main(String[] args) {
        try {
            validateXMLAgainstXSD(XML_FILE, XSD_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validateXMLAgainstXSD(String xmlFile, String xsdFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the XML file and parse it
        Document doc = builder.parse(new File(xmlFile));

        // Load the XSD schema and validate it
        Pattern pattern = Pattern.compile(loadXSD(xsdFile));
        Matcher matcher = pattern.matcher(doc.getDocumentElement().toString());
        if (!matcher.matches()) {
            throw new Exception("The XML file contains a security-sensitive operation related to injection.");
        }
    }

    public static String loadXSD(String xsdFile) {
        String xsd = "";
        try {
            File file = new File(xsdFile);
            InputStream inputStream = new FileInputStream(file);

            int content;
            while ((content = inputStream.read()) != -1) {
                xsd += (char) content;
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xsd;
    }
}