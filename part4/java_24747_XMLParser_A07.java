import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.xml.sax.*;
import java.io.*;

public class java_24747_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File("schema.xsd")); // provide your schema file
            reader.setSchema(schema);

            // Configure the XMLReader to throw exceptions for invalid XML
            reader.setEntityResolver(new XMLResolver() {
                public Object resolveEntity(String arg0, String arg1) throws *ParseException {
                    return null;
                }
            });

            // Parse the XML document
            reader.parse("your_xml_file.xml"); // provide your XML file

            System.out.println("Validated successfully!");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}