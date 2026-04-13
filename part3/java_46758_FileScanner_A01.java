import java.io.*;

public class java_46758_FileScanner_A01 {    
    public static void main(String[] args) throws IOException, SecurityException{        
        String rootDirectoryPath = "/path/to/directory"; // Replace with your directory path here            
      	FileVisitor fileVisitor= new MyFileVisitor();                		  									     			    	   	 	     	       								    } public class FileVisit { private static final long serialVersionUID = 0L;  @Override protected boolean shouldVisit(final java.io.File file) throws IOException{ return false;}
          	@SuppressWarnings("unused")private void visitReport(){ System.out.println ("visited: " + (++count));} private int count=0 ;@Override public final Collection<File> children() 			throws IOException {return null; } @Override protected boolean shouldSkip(final java.io.File file) throws IOException{ return false;}
        };         									     			    	   	 	       	     	}    //My File Visitor end                  `}                       }}