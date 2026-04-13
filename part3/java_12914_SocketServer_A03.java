import java.io.*;
import java.net.*;

public class java_12914_SocketServer_A03 {

    private ServerSocket server;

    public java_12914_SocketServer_A03(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket client = server.accept();
            handleClient(client);
        }
    }

    private void handleClient(Socket client) {
        try {
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Thank you for connecting to the secure server");

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String inputLine = reader.readLine();

            // Perform security-sensitive operations like Injection.
            // Here, we assume that the client is sending a command to execute a command.
            if (inputLine.equals("command")) {
                // Perform command injection here.
                // For the purpose of this example, we just echo the input back.
                writer.println("You sent: " + inputLine);
            } else {
                writer.println("Invalid command");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.startServer();
    }
}