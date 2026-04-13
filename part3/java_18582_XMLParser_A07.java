import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Pipe;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.semgraph.SemanticGraphNode;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankAnnotation;
import edu.stanford.nlp.util.CoreMap;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class java_18582_XMLParser_A07 {

    public static void main(String[] args) throws IOException {
        String text = "Your text here";
        File xmlFile = new File("input.xml");
        String properties = "annotators=tokenize,ssplit,pos,lemma,ner,parse,dcoref,syntax,entities,security,auth";

        // Create the Stanford CoreNLP object
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

        // Annotate the text
        Annotation annotation = new TreebankAnnotation(text);

        // Execute the pipeline and store results in the annotation
        pipeline.annotate(annotation);

        // Print all the named entities that were annotated
        SemanticGraph semanticGraph = annotation.get(SemanticGraph.class);
        SemanticGraphNode[] nodes = semanticGraph.getAllNodes();
        Iterator<SemanticGraphNode> iter = nodes.iterator();
        while (iter.hasNext()) {
            SemanticGraphNode node = iter.next();
            Tree tree = node.getTree();
            if (tree != null) {
                System.out.println("Found " + node.getType() + ": " + tree);
            }
        }
    }
}