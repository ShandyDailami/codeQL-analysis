import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ErrorHandler;
import java.io.File;
import java.io.IOException;

public class java_20422_XMLParser_A01 extends DefaultHandler {
    private static final String LOG_FILE_NAME = "log.txt";
    private static final String ERROR_FILE_NAME = "error.txt";
    private static File logFile;
    private static File errorFile;
    private static ErrorHandler errorHandler;
    
    public java_20422_XMLParser_A01() {
        logFile = new File(LOG_FILE_NAME);
        errorFile = new File(ERROR_FILE_NAME);
        errorHandler = new ErrorHandler() {
            @Override
            public void warning(SAXException e) {
                // Handle warnings, such as missing closing tags or unclosed elements
            }

            @Override
            public void error(SAXException e) {
                // Handle errors, such as missing closing tags or unclosed elements
            }

            @Override
            public void fatalError(SAXException e) {
                // Handle fatal errors, such as XML parsing errors
            }
        };
    }
    
    public void parse(String fileName) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.setErrorHandler(errorHandler);
            reader.parse(fileName);
            logFile.createNewFile();
            errorFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
            try {
                errorFile = new File(ERROR_FILE_NAME + System.currentTimeMillis());
                errorFile.createNewFile();
                errorFile.append(e.getMessage());
            } catch (IOException ex) {
                System.out.println("Error writing to error file: " + ex.getMessage());
            }
        }
    }
    
    @Override
    public void startDocument() throws SAXException {
        // Log and write start of document
        logFile.append("Start of document\n");
    }
    
    @Override
    public void endDocument() throws SAXException {
        // Log and write end of document
        logFile.append("End of document\n");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Log and write start of element
        logFile.append("Start of element: " + qName + "\n");
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Log and write end of element
        logFile.append("End of element: " + qName + "\n");
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Log and write characters
        logFile.append("Characters: " + new String(ch, start, length) + "\n");
    }
    
    public static void main(String[] args) {
        MyXmlParser parser = new MyXmlParser();
        parser.parse("sample.xml");
    }
}