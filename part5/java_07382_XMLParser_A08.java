import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_07382_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            A08_IntegrityFailureXMLHandler integrityFailureHandler = new A08_IntegrityFailureXMLHandler();
            saxParser.parse("src/main/resources/data.xml", integrityFailureHandler);

            System.out.println(integrityFailureHandler.getFailedEntries());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}