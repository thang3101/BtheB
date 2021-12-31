package com.example.model;

public class Messages {
    private int Message_Thumb;
    private String Message_Name;


    public Messages(int message_Thumb, String message_Name) {
        Message_Thumb = message_Thumb;
        Message_Name = message_Name;
    }

    public Messages() {
    }

    public int getMessage_Thumb() {
        return Message_Thumb;
    }

    public void setMessage_Thumb(int message_Thumb) {
        Message_Thumb = message_Thumb;
    }

    public String getMessage_Name() {
        return Message_Name;
    }

    public void setMessage_Name(String message_Name) {
        Message_Name = message_Name;
    }

}
