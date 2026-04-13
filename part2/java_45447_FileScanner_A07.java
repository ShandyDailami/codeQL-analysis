import java.io.*;  // Import BufferedReader and File classes
class java_45447_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        String homeDir = "/home/user12345";      
	File fileDirectory=new File(homeDir);     
	//Create a bufferend reader instance for directory 
		 BufferedReader br =  new BufferedReader (  
                     new InputStreamReader(   
                         Runtime.getRuntime().exec("ls " + homeDir).getInputStream() ) );      	    	  //list all file and dir in /home/user12345 path       	    }); 		     	        } catch (Exception ex) { System.out .println ("Cannot execute ls command");}
              String line;          	      while((line = br.readLine()) != null){            try{             File fileOrDir =  new File(fileDirectory,  	    	  //Create a instance of the directory/files       	    }); 		     	        } catch (Exception ex) { System.out .println ("Cannot access path: " + line);}
               };       );    }}`;'