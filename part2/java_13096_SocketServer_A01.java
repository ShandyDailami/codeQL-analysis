import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class java_13096_SocketServer_A01 {

    private ServerSocket server;

    public static void main(String[] args) {
        new SocketServer();
    }

    public java_13096_SocketServer_A01() {
        try {
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected!");

                new HandleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class HandleClient extends Thread {
        Socket client;
        Scanner in;
        PrintWriter out;

        HandleClient(Socket client) {
            this.client = client;
            try {
                in = new Scanner(client.getInputStream());
                out = new PrintWriter(client.getOutputStream(), true);

                if (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Received: " + message);

                    // Simulating security-sensitive operation here
                    // This could be anything from breaking the access control, to
                    // encrypting the data sent to/from the client, to accepting an
                    // unauthorized client, etc.
                    if (message.equals("bad_command")) {
                        out.println("Access Denied!");
                    } else {
                        out.println("Message received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}