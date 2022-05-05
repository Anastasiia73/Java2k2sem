package com.company.mediator;

public class SimpleUser implements User{
    Chat chat;
    String name;


    public SimpleUser(Chat chat, String name){
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь " + this.name +  " получил сообщение сообщение: " + message);
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message,this);
    }
}
