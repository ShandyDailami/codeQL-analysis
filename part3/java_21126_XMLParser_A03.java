import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.Pipe;
import edu.stanford.nlp.simplepipe.SerializableSink;
import edu.stanford.nlp.training.Example;
import edu.stanford.nlp.training.Trainer;
import edu.stanford.nlp.training.synapse.SynapseTrainingData;
import edu.stanford.nlp.util.CoreMap;

import java.util.Iterator;

public class java_21126_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path";
        String modelFilePath = "your_model_file_path";

        Pipe.Config conf = new Pipe.Config(modelFilePath);
        SerializableSink sink = new SerializableSink(conf);

        Pipe pipe = new Pipe(sink);
        CoreAnnotations.setCoreAnnotations(Annotation.class);

        Annotation annotation = new Annotation(xmlFilePath);

        try (Trainer trainer = new Trainer(pipe, annotation, new SynapseTrainingData())) {
            trainer.train();

            Iterator<CoreMap> sentence = annotation.iterator();
            while (sentence.hasNext()) {
                CoreMap sentenceAnnotation = sentence.next();
                for (CoreMap word : sentenceAnnotation.get(CoreAnnotations.MorphologyAnnotation.class)) {
                    System.out.println(word.get(CoreAnnotations.PartOfSpeechAnnotation.class));
                }
            }
        }
    }
}