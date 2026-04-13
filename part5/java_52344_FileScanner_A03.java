import java.io.*; // Importing the BufferedReader for file operations, and InputStream/OutputStream streams   
public class java_52344_FileScanner_A03 {  
     public static void main(String[] args) throws IOException 
	 {       
		 try (BufferedReader br = new BufferedReader(new FileReader("C:\\myDir"))){ //Reading from a file securely        	 			      					          } catch (Exception e1)                  	       	   	     	{  				    System.out.println ("Error in reading the files" +e);    	}}
		  String line;                    
           while ((line = br .readLine()) != null){ //Reading from a file securely            	 			         }catch (Exception e) {                 	   	       	     	{  				 System.out.println ("Error in reading the files" +e);    	}}   		  }}