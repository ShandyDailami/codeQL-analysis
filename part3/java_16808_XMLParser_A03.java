import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.util.ErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_16808_XMLParser_A03 {
    private static final String XML_FILE = "legacy_sample.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE);

        SAXParser saxParser = new SAXParser();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/rpc", true);

            ErrorHandler errorHandler = new ErrorHandler() {
                @Override
                public void error(SAXParseException e) {
                    System.err.println("Parse error: line " + e.getLineNumber() + ", column " + e.getColumnNumber());
                }

                @Override
                public void fatalError(SAXParseException e) {
                    System.err.println("Parse fatal error: line " + e.getLineNumber() + ", column " + e.getColumnNumber());
                }

                @Override
                public void warning(SAXParseException e) {
                    System.err.println("Parse warning: line " + e.getLineNumber() + ", column " + e.getColumnNumber());
                }
            };

            reader.setErrorHandler(errorHandler);

            saxParser.parse(reader, xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}