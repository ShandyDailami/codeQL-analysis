import java.io.*;
import java.net.*;
import java.util.*;

public class java_38772_SocketServer_A08 {
    private static List<PrintWriter> clientOutputStreams;
    
    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;
        
        clientOutputStreams = new ArrayList<>();
        
        try {
            serverSocket = new ServerSocket(2222);
            System.out.println("Waiting for client connection...");
            
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connected client " + socket.getInetAddress().getHostAddress());
                
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                
                clientOutputStreams.add(writer);
                
                handleClient(socket, writer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void handleClient(Socket socket, PrintWriter writer) {
        Thread thread = new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMessage;
                
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    
                    for (PrintWriter writer : clientOutputStreams) {
                        writer.println(clientMessage);
                    }
                }
                
                removeClient(writer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        thread.start();
    }
    
    private static void removeClient(PrintWriter writer) {
        clientOutputStreams.remove(writer);
    }
}