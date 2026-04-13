import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class java_36086_SocketServer_A08 {
    private static final int ECHO_SERVER_PORT = 60000;

    public static void main(String[] args) throws Exception {
        // Step 1: Set up a server socket
        ServerSocket serverSocket = new ServerSocket(ECHO_SERVER_PORT);

        // Step 2: Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        // Step 3: Communicate with the client
        // Create an input stream to read the client's messages
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        // Create an output stream to write back the client's messages
        OutputStream outputStream = clientSocket.getOutputStream();

        String message;
        while ((message = br.readLine()) != null) {
            System.out.println("Received: " + message);
            outputStream.write(message.getBytes());
            outputStream.newLine();
            outputStream.flush();
        }

        // Close the streams
        br.close();
        outputStream.close();

        // Close the socket
        clientSocket.close();
        serverSocket.close();
    }
}