import java.io.*;
import java.net.*;

public class java_40402_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Hello, this is the server!";
    private static final int PORT = 12345;

    public static void main(String[] args) {

        // Step 1: Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started on port " + PORT + "...");

            // Step 2: Accept incoming connections
            while (true) {
                Socket socket = serverSocket.accept();

                // Step 3: Handle the connection
                handleConnection(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void handleConnection(Socket socket) {
        try (SocketWriter writer = new SocketWriter(socket);
             SocketReader reader = new SocketReader(socket)) {

            // Step 4: Send a message to the client
            writer.write(SERVER_MESSAGE);

            // Step 5: Receive and print a message from the client
            String message = reader.read();
            System.out.println("Server received: " + message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class SocketReader extends InputStreamReader {

        public java_40402_SocketServer_A03(Socket socket) throws UnsupportedEncodingException {
            super(socket.getInputStream());
        }

        public String read() throws IOException {
            BufferedReader reader = new BufferedReader(this);
            return reader.readLine();
        }
    }

    static class SocketWriter extends OutputStreamWriter {

        public java_40402_SocketServer_A03(Socket socket) throws UnsupportedEncodingException {
            super(socket.getOutputStream());
        }

        public void write(String message) throws IOException {
            PrintWriter writer = new PrintWriter(this);
            writer.println(message);
            writer.flush();
        }
    }
}