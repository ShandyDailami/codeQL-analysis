import edu.stanford.nlp.pipeline.*;

import java.io.*;

public class java_41761_XMLParser_A08 {

    public static void main(String[] args) throws IOException {
        // Initialize pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Read XML file
        FileInputStream fis = new FileInputStream("sample.xml");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        // Parse XML
        AnnotatedSentence sentence;
        Properties sentenceProps = new Properties();
        sentenceProps.setProperty("annotator", "parse");
        pipeline.annotate(isr, sentenceProps);

        // Print parse tree
        for (AnnotatedTree tree : sentence.get(sentenceProps)) {
            System.out.println(tree.toString(true));
        }

        isr.close();
        fis.close();
    }
}