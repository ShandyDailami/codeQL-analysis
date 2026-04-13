import javax.annotation.processing.*;
import org.apache.commons.io.filefilter.*;
import java.nio.file.*;
    import static com.google.common.base.Preconditions.checkArgument;
   public class java_42397_FileScanner_A03 {    
       private final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");  // Pattern matcher for .txt files        
    @SuppressWarnings({"Java8FileFormat", "unused"})     
        public void fileScanner(String directory) {      
            try (Stream<Path> stream = Files.newDirectoryStream( Paths.get(directory)))   // File Stream creation for specific path        
             {    
                List<Path> matchedFiles  =stream                    
                    .filter(path ->  !path.toString().contains("../") &&  /* Exclude parent folder */    fileMatcherAbsentUserParentFolderNameIncludedAnyOtherFileExtensionTxtGlobbingPatternSpecifiedTheSameDirectoryNotAllowedAndOnlySetsOfThreeDifferentEntriesAtEnds())
                    .filter(path -> path.toString().endsWith(".txt"))        // File only with the extension of txt        
                {    
                      if (Files.isRegularFile(Path) && ! Files.getCTimes( Path ).beforeNow() <1L * 24*60*3){throw new IllegalStateException("Too old file"); }// Exclude too young files           throw Exception for other errors and then proceed with processing         
                      if (Files.isReadableFileLockedByAnotherProcess()) {                  // Checking the readability of a lock-controlled path        try to unlock it         return false;}}                .filter(p -> !pathMatcher.matches("folder1/subFolder/*", p))
                                  Files.setTimesNowIfSupported (Path,   /* Set file times now if possible */    Instant.now(), 0L , Duration.ZERO); return false; }}                   .collect(Collectors.toList()); }catch ((Exception e) { System..println("Error: "+e)} );}}