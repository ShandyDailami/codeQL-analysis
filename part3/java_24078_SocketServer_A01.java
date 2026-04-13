import java.io.*;
import java.net.*;

public class java_24078_SocketServer_A01 {

    private static ServerSocket server;
    private static Socket client;
    private static DataOutputStream out;
    private static String clientMessage, serverMessage;

    public static void main(String[] args) throws Exception {
        serverInit();
        broadcast();
    }

    public static void serverInit() throws Exception {
        server = new ServerSocket(3200);
        System.out.println("Server is listening on port 3200");

        while (true) {
            client = server.accept();
            System.out.println("Client connected");

            out = new DataOutputStream(client.getOutputStream());

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            clientMessage = in.readLine();
            serverMessage = "Server: " + clientMessage;

            out.writeBytes(serverMessage + '\n');
        }
    }

    public static void broadcast() throws Exception {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    serverMessage = "Client: " + clientMessage;
                    try {
                        out.writeBytes(serverMessage + '\n');
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            clientMessage = "";
            clientMessage = in.readLine();
        }
    }
}