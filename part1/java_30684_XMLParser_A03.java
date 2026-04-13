import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Pipeline;
import edu.stanford.nlp.simple.Document;

import java.util.Map;

public class java_30684_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a new Stanford CoreNLP pipeline
        Pipeline pipeline = Pipeline.getInstance();

        // Annotate a document
        Document document = new Document("src/main/resources/input.xml");
        Annotation ann = new Annotation(document);
        pipeline.annotate(ann);

        // Iterate over the annotations
        List<String> sentences = ann.get(CoreAnnotations.SentencesAnnotation.class);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        // Extract named entities from the document
        Set<String> namedEntities = ann.get(CoreAnnotations.NamedEntityTagsAnnotation.class);
        for (String namedEntity : namedEntities) {
            System.out.println("Found named entity: " + namedEntity);
        }

        // Extract the sentences and print the parse tree
        for (String sentence : sentences) {
            Document sentenceDocument = new Document(sentence);
            Pipeline newPipeline = Pipeline.getInstance();
            Annotation sentenceAnn = new Annotation(sentenceDocument);
            newPipeline.annotate(sentenceAnn);
            Map<String, String> parseTree = sentenceAnn.get(edu.stanford.nlp.pipeline.Pipeline.ParsedAnnotation.class);
            System.out.println(parseTree);
        }
    }
}