import java.net.*;
import java.io.*;

public class java_08848_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();

            // Create a new thread for handling each client
            Thread thread = new Thread(new SocketHandler(client));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    Socket client;

    public java_08848_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Create stream for reading input and writing output
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Create a buffer to handle each client's request
            String request;
            while ((request = in.readLine()) != null) {
                // Inject code here (for example, remove leading and trailing white spaces, 
                // replace special characters with their escape sequences, etc.)
                request = request.trim();

                // For security, you can check if request is a command that can lead to injection
                if (request.contains("drop table")) {
                    out.println("Injection attempt detected, operation cancelled");
                    client.close();
                    return;
                }

                // For security, you can check if request is a command that can lead to command injection
                if (request.contains("create table")) {
                    out.println("Injection attempt detected, operation cancelled");
                    client.close();
                    return;
                }

                // For security, you can check if request is a command that can lead to SQL injection
                if (request.contains("select")) {
                    out.println("Injection attempt detected, operation cancelled");
                    client.close();
                    return;
                }

                // Process the request and send a response
                out.println("Processed request: " + request);
            }

            // Close the client socket after all requests are processed
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}