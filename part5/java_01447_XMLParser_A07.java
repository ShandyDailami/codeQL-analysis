import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_01447_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            MyHandler mh = new MyHandler();
            sp.parse("src/main/resources/sample.xml", mh);

            // Printing results
            System.out.println("Number of errors: " + mh.getErrorCount());
            System.out.println("Number of warnings: " + mh.getWarningCount());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private int errorCount = 0;
    private int warningCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Adding unique operation here
        if (qName.equalsIgnoreCase("warning")) {
            warningCount++;
        } else if (qName.equalsIgnoreCase("error")) {
            errorCount++;
        }
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getWarningCount() {
        return warningCount;
    }
}