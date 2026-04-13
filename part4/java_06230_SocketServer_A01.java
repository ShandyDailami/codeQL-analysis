import java.io.*;
import java.net.*;

public class java_06230_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("close")) {
                dataOutputStream.writeUTF("Connection closed");
                dataOutputStream.flush();
                socket.close();
            } else {
                dataOutputStream.writeUTF("Received your request");
                dataOutputStream.flush();
           
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(5000);
                        dataOutputStream.writeUTF("Connection timed out");
                        dataOutputStream.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        dataOutputStream.close();
                        socket.close();
                    }
                });
                thread.start();
            }
        }
    }
}