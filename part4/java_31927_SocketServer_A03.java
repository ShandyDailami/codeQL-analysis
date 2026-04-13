import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31927_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_31927_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Assume the message is a command to execute a command
                if (message.startsWith("cmd:")) {
                    String command = message.substring(4);

                    // Inject the command as a command to a system command execution
                    // For example, this could be a command execution using Spring's JavaShell
                    System.out.println("Executing command: " + command);

                    // Replace the command with a fake command
                    command = "fake-command";
                }

                out.println("Server response: " + command);
            }

            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).startServer();
    }
}