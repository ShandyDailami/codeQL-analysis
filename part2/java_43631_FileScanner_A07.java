import java.io.*;
import java.nio.file.*;
import static java.util.stream.Collectors.*;

public class java_43631_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        Path startPath = FileSystems.getDefault().getFileStore().getRootDirectory(); // or any directory you want to scan from here, e.g., new File("your/directory").toPath() 
        
        Files.walk(startPath).filter(path -> !Files.isHidden(path) && (Files.isRegularFile(path)) )  
            .forEach((file)->  {    // for each file found, you can process it here e.g., read and print its content if necessary 
                try{             
                    Files.lines(Paths.get(String.valueOf(file)));       }     catch (IOException ignored) {}         });        }}`