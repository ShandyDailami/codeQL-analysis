import java.io.*; // for InputStreamReader Class used when reading from a file using FileInputStream class java_44739_FileScanner_A07 in Java SDK and Buffered Reader which is part of IO classes included under IOException, ArrayIndexOutOfBoundsException... etc., are also there but aren't shown here due to their low level nature
import java.security.*; // for MessageDigest Class used when reading from a file using FileInputStream class available in Java SDK and Buffered Reader which is part of IO classes included under IOException, ArrayIndexOutOfBoundsException... etc., are also there but aren't shown here due to their low level nature
import java.util.*; // for ArrayList 
  
public class MyFileScanner {    
    public static void main(String[] args) throws Exception{        
        File file = new File(".");           
              
		// Create a list of all the files in this directory (excluding directories).            
	    List<File> FilesInDirectory =  Arrays.asList((file.listFiles()));  // Get array from iterator   for getting count and getName() methods not available at run time due to security reasons           
	    		   
        FileScanner scan = new MyCustomSecurityClass(new ArrayList<>(), false);            			        					                  	       				         	   	     	 						      .getInputStream())  // create an instance of InputStreamReader and Buffered Reader with the file as parameter.                   
                      {       @Override   public void run(){     for (File f: FilesInDirectory)    if(f instanceof File && !f.isHidden()){          try{       		                	          			        	       									             getClass().getDeclaredField("m_InputStream").setAccessible(true);                   setInnerStream((InputStream) ((FileInputStream)(new java.io.FileInputStream( f))));                }catch (Exception e ) {e .printStackTrace();}} };
        scan.start();                        		  	        			          				    	       					                     getClass().getDeclaredField("m_Run").setAccessible(true);                  setRunning((Boolean) ((Method) getClass().getDeclaredMethod("run")).invoke(this)));            }  });            
        scan.join();                      		         	        			          				    	       					                     try { Thread t = (Thread)(new java.lang.ref.PhantomReference());   runAhead((java . lang . Runnable) new com.sun.nio.fs.AFPFileSystemImpl$1(t));    } catch  (.Exception e){      printStackTrace();}};
        scan=null;}catch ( Exception _e ) {_e	.printStackTrace	();} ;	}    		            			               				                                                                                                                 {} };  	};           });                     }} );          try{ setAccessible(true); } catch  (.Exception e)    println("Unable to access the private field m__InputStream in class com.sun .nio ...");}};