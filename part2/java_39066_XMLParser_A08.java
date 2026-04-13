import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class java_39066_XMLParser_A08 {

    public static void main(String[] args) {
        validateXmlFile("src/main/resources/document.xml", "src/main/resources/schema.xsd");
    }

    private static void validateXmlFile(String fileName, String schemaFile) {
        try {
            File schemaFileXml = new File(schemaFile);
            SchemaFactory factory = SchemaFactory.newInstance(new FileNameMapper() {
                public String getAggregatedSchema(DocumentType dtype) {
                    return new File(schemaFileXml.getPath()).toString();
                }

                public String getSystemId(String external) {
                    return new File(external).toString();
                }
            });

            Schema schema = factory.newSchema(schemaFileXml);
            Validator validator = schema.newValidator();

            DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
            factory2.setValidating(true);
            factory2.setNamespaceAware(true);

            DocumentBuilder builder = factory2.newDocumentBuilder();

            Document doc = builder.parse(new StreamSource(new File(fileName)));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/output.xml"));

            transformer.transform(source, result);

            validator.validate(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}