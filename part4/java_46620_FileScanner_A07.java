import java.io.*; // For FileInputStream, OutputStream etc... 
import java.nio.charset.StandardCharsets;  
import java.security.*;   
from javax.crypto import Cipher;    
from javax.crypto.spec import SecretKeySpec;     

public class java_46620_FileScanner_A07 {
	final static String key = "a secret kick ass encryption key";  // Use a real one!  
	   
	public void encrypt(String inputFile, String outputFile) throws IOException{    
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");   
	Cipher cipher= Cipher.getInstance("AES");     
	cipher.init(Cipher.ENCRYPT_MODE,aesKey);  
		 
	// File operations    
        try (FileInputStream fis = new FileInputStream(inputFile)) {      
            byte [] buffer =  new byte [fis.available()];    // make sure it has enough space     
	    fis .read (buffer );          cipher .update (buffer);   } 		                   	try (OutputStream os =new BufferedOutputStream        (new FileOutputStream(outputFile))) {os.write(cipher.getOutputSize());}     catch (Exception e){e.printStackTrace();}}   
	   			      
	public void decrypt(String inputfile, String output_location) throws IOException{   // same as above but for the Decryption process      Cipher cipher=Cipher .getInstance ("AES");	cipher 		    	.init (Cipher.DECRYPT_MODE , aesKey);	try   	   
            {FileOutputStream fos = new FileOutputStream(output_location))	{fos  			         	  .write((byte)cipher         .doFinal());}	}// end of try...catch block  }	//end method main        public static void     main (String[] args){SecureFilescanner sfs=new SecurFitnesHScaner();     
	sfs.encrypt("inputfile", "output_location");}} //replace input file and output location with your real files   try {SFS1    .decrypT ("outptu" +"_locatoin")  }catch (Exception e)     {}//end of main method