import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.CatalogReader;
import java.io.File;
import java.io.IOException;

public class java_25968_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            CatalogReader catalogReader = new CatalogReader(reader, true);
            catalogReader.setValidationEnabled(true);
            catalogReader.setValidationSchema(new File("path_to_your_schema.xsd"));

            catalogReader.setFeature(
                "http://xml.org/sax/features/external-general-entities",
                false
            );
            catalogReader.setFeature(
                "http://xml.org/sax/features/namespaces",
                false
            );

            catalogReader.setFeature(
                "http://xml.org/sax/features/namespace-prefixes",
                false
            );

            reader = catalogReader;

            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

            reader.setFeature("http://xml.org/sax/features/external-general-entities", true);

            reader.setFeature("http://xml.org/sax/features/validation-schema", true);
            reader.setFeature("http://xml.org/sax/features/validation-schema-valid", true);

            reader.setFeature("http://xml.org/sax/features/destructuring", true);

            reader.parse(xmlFile);

            // Use the reader to retrieve the parsed content (access all the parsed nodes)

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}