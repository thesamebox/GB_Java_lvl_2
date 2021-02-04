package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket  socket;
    static final int PORT = 8889;
    static final String IP_ADDRESS = "localhost";

    static DataInputStream in;
    static DataOutputStream out;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Connected to server");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                try {
                    while (true) {
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                String clientMessage = in.readUTF();
                if (clientMessage.equals("/end")) {
                    System.out.println("Disconnected");
                    break;
                } else {
                    System.out.println("Server: " + clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
