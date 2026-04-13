import java.io.*; // Import Java I/O related classes 
class java_48077_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    	
        String currentDirectory = new File(".").getAbsolutePath();         		      
         System.out.println ("Current directory: " +currentDirectory);          			     					               	       				 	    }             	 
}  
class FindFiles {    public static void main(String[] args) throws IOException{    	FileScanner fs = new FileScanner (){                      @Override                            		       protected boolean accept(Path path, BasicFileAttributes attrs )throws IOException                  					       	       				 	    };                   	  }             	}
class FindFiles2 {    public static void main(String[] args) throws Exception{    	BufferedReader br = new BufferedReader (new InputStreamReader         ((System.in),"UTF-8"));     		       File current;         			        while((br . readLine() )!= null);           }            	 
}   cmp   `