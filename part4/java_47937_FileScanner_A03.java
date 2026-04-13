import java.io.*; // Import necessary classes  
class java_47937_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{        
            String directory = "/path/to";      /* Specify your folder path here */         
             try (FileScanner scanner =  new FileSystems().newFileCompletionScanner((Path.of(directory))) ) {  // Use file completion to avoid listing all subfiles      
                  while (true)   for (; ;){           boolean accept = false;        switch ((accept=scanner.tryAdvance(p->{}))?1:0){                     case 0:(throw new AssertionError());default : return;} }}}} // Use a try with resource to ensure the FileSystems handle it's resources (like close)