import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Hex; // for HEX conversion of byte array to hex string 
// If you're using apache libraries, replace above lines with the below: import com.googlecode.java-crypto/jsse/providers/SunJCE provider if not already added in classpath and use SunJCEProvider() instead of DefaultCryptoProvider accessors;... (replace '......(...)' by using appropriate SHA256 implementation.)
// Also you should always close the socket once it is no longer needed, here I am closing after a client has disconnected: 
sock.close();   //Replace with your code that closes Socket and notifies all threads waiting on this object that its state cannot be relied upon to remain unchanged from one invocation of an overridden method followed by socket close; e g., if (socket != null) {... }