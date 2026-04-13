import java.io.*; // Import necessary classes from Standard Library packages: InputStream and PrintWriter for file handling etc...  
public class java_46517_FileScanner_A03 {   
       public static void main(String[] args) throws IOException{         
            File root = new File(".");        /* Using the current directory */        
              ListingVisitor visitor =  new 	ListingVisitor();     //Create a Visitor instance  		
             root.accept(visitor, null);      	//Visit all files and directories in this path	 			   	       	   									                                                                               							     	     	} }` /* End of main method */ `public static class ListingVisitor extends org.eclipse.jdt.core.IMovableSourceFolder$IVisitor { @Override public boolean visit(File file) throws IOException{ //Implement the Visiting Mechanism...  
        System.out.println("Found File: " +file .getName());  }@ Override	public void endVisit(@org.eclipse.jdt.core.IMovableSourceFolder source){	System.out.print("\nFinished visiting files and directories in the current directory");}	}`