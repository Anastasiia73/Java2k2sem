package com.company.mediator;

public class Admin implements User{
    Chat chat;
    String name;

    public Admin(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }


    @Override
    public void getMessage(String message) {
        System.out.println("Админ " + this.name + " получил сообщение: " + message);
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
}
