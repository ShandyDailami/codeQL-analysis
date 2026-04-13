import java.io.*;
import java.net.*;

public class java_37014_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // create a server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            // accept a client connection
            Socket socket = serverSocket.accept();

            // create a reader and writer for the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // read a message from the client
            String message = reader.readLine();

            // process the message (e.g., echo it back to the client)
            String response = processMessage(message);

            // send the response back to the client
            writer.println(response);
       
            // close the connection
            socket.close();
        }
    }

    private static String processMessage(String message) {
        // here is where you would implement your security-sensitive operations
        // for instance, you can use a technique like SQL Injection or command injection

        // for the purpose of this example, we'll just return the input message
        return message;
    }
}