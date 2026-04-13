import java.io.*;
import java.net.*;

public class java_14526_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2222);
            System.out.println("Server started.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);

                    // Send message to all other clients
                    for (Socket s : ServerSocketExample.sockets) {
                        if (s != socket) {
                            out.writeUTF(message);
                        }
                    }
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerSocketExample {
    public static Socket[] sockets = new Socket[5];

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                sockets[i] = new Socket("localhost", 2222);
            }

            while (true) {
                for (int i = 0; i < 5; i++) {
                    DataOutputStream out = new DataOutputStream(sockets[i].getOutputStream());
                    out.writeUTF("Hello from server!");
                }

                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}