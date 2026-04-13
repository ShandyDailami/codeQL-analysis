import com.sun.nio.file.*;
import javax.management.*;
import java.net.*;
public class java_51185_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{      
        FileSystem fs = FileSystems.getDefault();     //standard way to access file system 
         PathMatchingStrategy strategy =  new DirectoryPathMatcher("glob:*.txt",new SimplePatternMatchingStrategy());      /*simple pattern matchers for the files*/   
          boolean recursive=true;  
           fs.setAttribute(PathAttributes.class, Boolean.TRUE);     // set attribute  to true which can be used by file system       
         ForReadIterator it = strategy.iterator();       // creates an iterator of matches     
            while (it.hasNext()) {             /* Iterates through all files matching the pattern */   
                Path p=it.nextPath();     //returns a path for each match  if there is any next file then will print it  
                    System.out.println("File " +p+" exists.");      }          catch (Exception e){       /* exception handling*/        
                                                                           throw new ExceptionInInitializerError(e); }}catch(RuntimeMBeanException re) {re.printStackTrace();}     return;  try{Main a =new Main;}   //try-with resources for autocloseable resource      catch (Throwable t){t.printStackTrace((PrintStream)System.out)}          System.exit(-1); }}