import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_22925_XMLParser_A01 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: XMLParser filename");
            System.exit(0);
        }

        SAXBuilder builder = new SAXBuilder();

        try {
            Document doc = builder.build(new File(args[0]));

            Format prettyPrint = new Format() {
                @Override
                public String getHeader() {
                    return null;
                }

                @Override
                public String getFooter(int i) {
                    return null;
                }

                @Override
                public String getElementDeclaration(String s) {
                return null;
            }

                @Override
                public String getElementContent(String s) {
                    return null;
                }
            };

            XMLOutputter xmlOutputter = new XMLOutputter(prettyPrint);

            xmlOutputter.output(doc, new FileOutputStream("parsed.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}