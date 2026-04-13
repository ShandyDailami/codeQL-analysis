import java.io.*; // Import the necessary Java libraries, File objects and IOException are used here
public class java_46323_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        String dir = "/path/to/directory";     
	File f=new File (dir);//create a new file object of directory. 
	if (!f.exists()) //check if the path exists and is correct or not, then throw exception accordingly  
	{throw new SecurityException("Incorrect Path");}   		    	 			      									     	   	            } else { File[] files = f.listFiles();//get all file names in directory 														          for (int i = 0; i < files.length ;i++) //loop through the list of available Files  
	{FileReader fr=new FileReader(files[i]);			    	              			//open and read a specific text-file   					     	  if ((fr = new FileReader((dir + "/" +  files[i].getName()))) !=  null) //read file into memory. If the object is not created it returns ‘null’, hence there should be no SecurityException here    
	BufferedReader br=new BufferedReader(fr);  			              			//create a new buffering character input stream and FileWriter for output   				     	  while ((line = br.readLine()) !=  null) // read line from file until end of the text-file is reached 					     {System.out.println("Content in " + files[i].getName()+": "); System.out.print(line);} }}}