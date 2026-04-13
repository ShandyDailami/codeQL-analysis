import java.io.*; // for File, IOException 

public class java_42278_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{    
        String directory = "/home/user";      
        
		// Step1 - Use Directory Reader to get all files in the specified dir     
        File f = new File(directory);          // input file 		           			  					   				            	 	   								                                              	        .java                                                                                                       e.                                        aa     ddddsssA07_AuthFailurebbb..txtcccccc/home/.authfailure       cCcDDEEFFGGHHii
        File[] files = f.listFiles();          // list all the file in directory   	  					 		      .java                                                                                                       e., aa,.textA07_AuthFailurebbb..txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
        for (int i = 1; files != null && i < files.length - 3 ;i++) {   // loop through the file in directory    						 .java                                                                                                       e..textA07_AuthFailurebbb...txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
            File txtFile = files[files.length - i]; 			   	 		   // check for the file with text extension .java .. java ea..textA07_AuthFailurebbb...txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
            if ( txtFile != null && xmlString.contains("AUTHFAILURE")) { // check for the text content that contain "AUTHFAILURE" .java .. java eaa..textA07_AuthFailurebbb...txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
                FileReader reader = new FileReader(xmlString);             // create a filereader for the specific text files 	 	 .java                                                                                                       e. containAAA..texta07_AuthFailurebbb...txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
                BufferedReader br = new BufferedReader( reader);          // create a buffering character input stream 	 	 .java                                                                                                       e. containAAA..texta07_AuthFailurebbb...txtcccccc./home/.authfailure       cCcDDEEFFGGHHii
                String line = "";                                       	// hold the read string    		  									   				.e., AUTHFAILURE  aaa...../A.user	aCCDDdddEEFfGGHH......123...//home/.authfailure       cCcDDEEFFGGHHii
                while ((line = br.readLine()) != null) {                  // read line from the text file    			  					  .e., AUTHFAILURE aaa...../A..user	aCCDDdddEEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
                    System.out.println(line);                           // print out the read line  									   			  .e., AUTHFAILURE aaa...../A..user	aCCDDdddEEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
                }                     br.close();                          // close the buffered reader    					  		 	.e., AUTHFAILURE aaa...../A..user	aCCDDdddEEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
            }                     FileWriter writer = new FileWriter("/destination_folder/" + txtFile.getName());   // create filewriter for the specific text files 	 	 .e., AUTHFAILURE aaa...../A..user    ccCCDDddeEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
        }                    FileWriter writer = new FileWriter("/destination_folder/" + txtFile.getName());   // create filewriter for the specific text files 	 	 .e., AUTHFAILURE aaa...../A..user    ccCCDDddeEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
        writer.close();                     										// close filewriter    								.  		 	        e, . user A07_AuthFailurebbb...txtcccccc./home/..user      ccCCDDddeEFfGGHH....../home/.authfailure       cCcDDEEFFGGHHii
    }        catch (Exception ex) {           // Catch exception if there is any, and print the stack trace.    		 .e., A07_AuthFailureaaa..textA...txtcccccc./user/home/.authfailure  ccCCDDddeEFfGGHH....../USERHOMECcCDDEEFFGGHHii
        ex.printStackTrace();          // print the stack trace  										.e., A07_AuthFailureaaa..textA...txtcccccc./user/home/.authfailure  ccCCDDddeEFfGGHH....../USERHOMEcCDDEEFFGGHHii
    }                      catch (IOException ex) {         // Catch I/O exception if there is any, and print the stack trace.     .e., A07_AuthFailureaaa..textA...txtcccccc./user/.authfailure  ccCCDDddeEFfGGHH....../USERHOMEcCDDEEFFGGHHii
        ex.printStackTrace();          // Prints out the stack trace  									    .e., A07_AuthFailureaaa..textA...txtcccccc./user/.authfailure  ccCCDDddeEFfGGHH....../USERHOMEcCDDEEFFGGHHii
}                      }                    if ( files == null) {          // Check whether the file is exist or not.    .e., A07_AuthFailureaaa..textA...txtcccccc./user/.authfailure  ccCCDDddeEFfGGHH....../USERHOMEcCDDEEFFGGHHii
        System.out.println("Directory doesnt contain any files!");   // Prints out the message if directory is empty    .e., A07_AuthFailureaaa..textA...txtcccccc./user/.authfailure  ccCCDDddeEFfGGHH....../USERHOMEcCDDEEFFGGHHii
}}`;