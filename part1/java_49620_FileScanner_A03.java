import java.io.*;   // Import the necessary classes needed: File, Files   
import java.nio.charset.StandardCharsets;    
import java.util.concurrent.*;  // For ExecutorService and Callable task to read file concurrencyly (Java8)
import static org.apache.commons.lang3.StringUtils.isNotBlank;   // To check if a string is not blank or null, used by the function below in case injection vulnerability exists via bad user inputs 
    
public class java_49620_FileScanner_A03 {   
       private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());     
       
   public static void main (String[] args) throws IOException, InterruptedException{          //Main method to create a new instance of the program 
           Main sampleProgram=new Main();         //Instantiate an object for this class             
    List<File> fileList = Arrays.asList(args);        //Get files from command line arguments            
     if (fileList == null || fileList .size() == 0 ) {                 System.out.println("Usage: Main <files...>  "); return; }   else for  EACH FILE IN ARRAY OF PATHS      sampleProgram.processFile(new FilePaths[ELEMENT]);}         
    void processFile (final Path[] paths) throws IOException, InterruptedException {         //Method to read a file and print its content line by-line in parallel           if (! isNotBlank ((paths))) return;   for EACH PATH IN ARRAY OF FILES       executor.submit(new FileProcessorTask((Path))).get();    }             
     private class  FileProcessorTask implements Callable<Void> {          //Callable task to read a file concurrently           Path path ;                  try (Stream < String > stream = Files .lines      ((path), StandardCharsets.UTF_8) ){ for EACH LINE IN FILE             this(line);}   }       
    FileProcessorTask  (@NonNull final       Pattern pattern, @NonNull         InputPath input){          //Constructor to create a new task and assign its inputs                private static class      UnsafeFileHandler implements Runnable {                  public void run ( ) throws IOException     ;                     try(Stream < String > stream = Files .lines ((input.getAbsoluteInputStream () , StandardCharsets  UTF_8))){ for EACH LINE IN FILE             this