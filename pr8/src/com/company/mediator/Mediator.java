package com.company.mediator;

public class Mediator {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User admin = new Admin(chat, "Admin Vanya");
        User user1 = new SimpleUser(chat, "Vova");
        User user2 = new SimpleUser(chat, "Petya");

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("Hello, im Vova");
        admin.sendMessage("Im admin");


    }
}
