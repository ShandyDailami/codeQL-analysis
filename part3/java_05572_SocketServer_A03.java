import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05572_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is waiting for a client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client has connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Checking for injection attacks
                if (inputLine.contains("INJECTION")) {
                    System.out.println("Injection attack detected, closing connection...");
                    socket.close();
                    System.out.println("Connection closed");
                    return;
                }

                out.println("Echo: " + inputLine);
            }

            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}