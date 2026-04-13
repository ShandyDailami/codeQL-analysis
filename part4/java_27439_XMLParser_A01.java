import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Pipe;
import edu.stanford.nlp.xml.XMLUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_27439_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "data.xml";  // Your XML file path here
        process(xmlFile);
    }

    private static void process(String xmlFile) {
        File xml = new File(xmlFile);
        Pipe linePipe = null;
        try {
            linePipe = RNNCoreAnnotations.pipe(xml, "tokenize,ssplit,pos,lemma,parse,coreference,entity", CoreAnnotations.AnnotationProperties.values());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Annotation ann = new Annotation(xml);
        linePipe. annotate(ann);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        XMLUtil.loadIntoDocument(doc, ann.get(CoreAnnotations.SentencesAnnotation.class), xmlFile);

        // Your XML parsing code here
    }
}