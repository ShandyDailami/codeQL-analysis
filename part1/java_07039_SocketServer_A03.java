import java.net.*;
import java.io.*;

public class java_07039_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Create new thread for each client connection
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07039_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input stream and output stream
            InputStream inputStream = this.socket.getInputStream();
            OutputStream outputStream = this.socket.getOutputStream();

            // Create buffered reader and writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Handle client's input
            String clientInput;
            while ((clientInput = reader.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                // Split input into SQL injection and command
                String[] commandParts = clientInput.split(" ", 2);
                // Execute command with sanitized input
                executeCommand(commandParts[0], commandParts[1]);
            }
            // Close connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeCommand(String command, String input) {
        // Execute command and print output (for now)
        System.out.println("Executing command: " + command + ", with input: " + input);
        System.out.println("Output: " + command + " " + input);
    }
}