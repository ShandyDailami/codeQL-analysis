import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16074_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket client = server.accept();
            handleRequest(client);
        }
    }

    private static void handleRequest(Socket client) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        String request = reader.readLine(); // read request
        System.out.println("Received request: " + request);

        // Here you can add some security-sensitive operations related to A03_Injection
        // For instance, if the request contains a SQL injection attempt, we can block it
        // if (request.contains("DROP TABLE")) {
        //     writer.println("Blocked request: SQL Injection attempt detected");
        // } else {
        //     writer.println("Processed request: " + request);
        // }

        writer.close();
        client.close();
    }
}