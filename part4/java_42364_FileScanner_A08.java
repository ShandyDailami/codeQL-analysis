import javax.imageio.*;   // Import ImageIO class java_42364_FileScanner_A08 reading image files (*)   
 import javazoom.jntu.posix.lame.*;                    // LAME encoder package (LAME lib by jntu/koreader - *, licensed under the Beerware license *) 
import javax.sound.sampled.*;     // Import SoundSystem class for handling audio files (*)     
 public Class Test {                   // Start of test program with a main method  
    private static void playSound(String soundFile){         
        try{                       
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundFile));    
             Clip clip=AudioSystem.getClip();     
              clip.open(ais);  // Open the audio input stream   (LAME: mp3 decoder)      
               while(!clip.isOpened()){Thread.sleep(10)};         System.out.println("Playing sound file");    for (;;) {             Thread.sleep(256*4); clip.stop();     }} catch   (Exception e ){e .printStackTrace()); } 
      public static void mainTestFileScanner() throws Exception          // Main method which will start the program, calls other methods         File directory = new           java.io.,Directory("C:\\Users\YourUserNameHere");     String[] files  = dir            .list(new FilenameFilter(){public boolean accept (String dirname ,             Files desc){return true;}});for   (int i = 0 ;i <files..length - 1;) {
          if(!files[file].isFile() || !Sound.getExtensions().contains((filename).substring(         filename .lastIndexOf(".") + 1))) continue;}    }catch      ((SecurityException se)             throw new Exception ("Error in audio playback: " + e);} 
            if (args[0].equalsIgnoreCase("/s")) {                   // If the user specifies /s, then start sound test.           TestSound(argv [1]);}} else{TestFileScanner();}}}else System .out   Println("Usage : \n\tjava -jar Aaronaughtsdangerousintegritytestsounddecryptor08Amanda_Lemonade256kBmp.war /s <name of sound file>");}
            public static void TestSound(String name){           // Method to test the audio playback   try {playSound("C:\\Users\YourUserNameHere"+FileSeparator + "mysoundfile.wav") }catch (Exception e)             {System .out Println ("Error in sound file decryption");}}
            public static void TestFiLeScanner(){              // Method to test the File scan operation    try{Test   Scan(new           java.io.,Directory("C:\\Users\YourUserNameHere"));} catch (Exception e) { System .out Println ("Error in file decryption");}}
            public static void main          (String [] args){     TestFileScanner();}}}  // End of program }} end   */