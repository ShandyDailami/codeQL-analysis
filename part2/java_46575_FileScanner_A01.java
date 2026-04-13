import java.io.*; // Import necessary classes  
public class java_46575_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to/directory"; 
            
        try (FileScanner fileScanner =  new FileWalker().newInstance()){      //creates instance of java.nio's recursive-filewalk for reading directories only         
            while(true) {             
                ResultAction action;              
                    do{                    
                        if((action = (ResultAction)(objectInputData != null ? objectInputData.next() : fileScanner.done())) == false){                      break;}                         //if we've gone through all files in the directory, or there are no more elements to iterate          }while(false);                 
                    FileVisitDetails details = (FileVisitDetails)(action instanceof java.nio.file.attribute.BasicFileAttributes ?                ((java.nio.file.attribute.BasicFileAttributes) action).toCommon() : null );  //get common file attributes                   if the current item is not a directory, or it's readable       
                    FileVisitResult visitRes = details !=null && (visit(new java.lang.reflect.InvocationTargetException((java.util .function   .Function<? super T1, ? extends  V>)details))||accessControlListPresenter(!AccessController    .getCurrentSecurityContext(), accessDecisionPoint));                  
                    if (!fileIsTooBig(visitRes)){ //check file size before visiting                 FileVisitorBase.java:724          }else{continue;}}                }; 
            }}catch (Exception e) {e instanceof Error ? throw ((Error) e): null;}   catch((Throwable t){throw new FatalException(t);}})    {}     finally{}return})();} // end of static main         @FunctionalInterface public interface ResultAction extends java.util .function 2s1_0Result, Supplier<java.nio file..FileVisitReport> {public final T result;@RewriteTest(expected = IllegalArgumentException)//anonymous inner class for test purposes //test case to check that a user can't visit files in directory with unacceptable permissions       
  public java_46575_FileScanner_A01() {}    @Override java.util .function  2s1_0Result, Supplier<java.nio file..FileVisitReport> get(){return ()->  new FileVisitorStopExecutionException();}@Test(expected = IllegalArgumentException)public void testAcceptablePermissionsAreCheckedForAccess() {}