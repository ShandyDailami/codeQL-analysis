import java.net.*;
import java.io.*;
import java.util.*;

// Define our custom security manager
class java_05834_SocketServer_A03 extends SecurityManager {
  private static final Set<String> authorizedCommands = new HashSet<String>() {{
    add("read");
    add("write");
  }};
  
  @Override
  public boolean invoke(MethodInvocation methodInvocation) throws IllegalMethodInvocationException, IllegalAccessException {
    String methodName = methodInvocation.getMethod().getName();
    if (authorizedCommands.contains(methodName)) {
      return true;
    }
    throw new IllegalMethodInvocationException(methodName + " is not allowed");
  }
}

public class SocketServer {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket();
    socket.bind(new InetSocketAddress(8080));
    
    System.setSecurityManager(new CustomSecurityManager());
    
    // Create input and output streams
    InputStream input = socket.getInputStream();
    OutputStream output = socket.getOutputStream();

    // Start reading
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    PrintWriter writer = new PrintWriter(output, true);

    String command;
    while ((command = reader.readLine()) != null) {
      System.out.println("Received: " + command);
      
      // Simulate a command execution
      if (command.equals("write")) {
        writer.println("Hello, client!");
      } else if (command.equals("read")) {
        writer.println("Data received!");
      } else {
        writer.println("Unknown command!");
      }
      
      writer.flush();
    }
    
    socket.close();
  }
}