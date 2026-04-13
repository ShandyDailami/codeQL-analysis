import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.parse.Parse;
import edu.stanford.nlp.parse.ParseException;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class java_00221_XMLParser_A03 {
    public static void main(String[] args) {
        String text = "<document>Your XML content goes here</document>";
        parseXml(text);
    }

    public static void parseXml(String text) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,parse");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);

        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            Parse parse = sentence.get(Parse.class);
            Tree tree = parse.getTree();
            SemanticGraph semanticGraph = parse.getSemanticGraph();

            // Here you can use the parsed tree and semantic graph to process the XML.
        }
    }
}