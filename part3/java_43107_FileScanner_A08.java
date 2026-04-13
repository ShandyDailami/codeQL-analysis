import java.io.*; // Importing the required Java libraries (File I/O, Directories and Files)   
 import javax.sound.midi.* ;// The MIDI classes are used for creating a music sequence - not really needed in this example since we're just scanning files    
  public class java_43107_FileScanner_A08 {   // Defining the main file scanner method (file checker, etc.)        
       private static final int MAX_MIDI_CHANNEL = 16;     
        boolean[] midiChannels = new boolean[MAX_MIDI_CHANNEL]; 
     File startingDirectory ;    // Declaring a file to start scanning from.   Note: this should be an absolute path directory, not just relative one - it will depend on your program's requirements            public static void main(String[] args) {          new Scanner(); }           private boolean checkFileIntegrity()