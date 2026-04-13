import java.io.*;
import java.nio.file.*;
import java.util.*;
  
public class java_45114_FileScanner_A08 {
    static void scanDirectory(Path dir) throws IOException, SecurityException {
        try (Stream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {  // iterating over file/directory in a directory using Stream API from java8 standard library    
                if (!Files.isDirectory(path)){  	// not checking directories, only files and their subdirectories due to security reasons   
                    String content = Files.readString(path);	
                  	if (content.contains("A08_IntegrityFailure")){  // searching for keyword in file contents    		        			      					              				            	}   }}}}}}`;