package ru.netology;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            // Отправка сообщения серверу
            writer.println("Клиент");
            // Получение ответа от сервера
            String response = reader.readLine();
            System.out.println("Ответ сервера: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
