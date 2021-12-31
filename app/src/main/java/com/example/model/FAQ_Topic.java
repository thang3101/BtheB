package com.example.model;

public class FAQ_Topic {
    private int topicThumb;
    private String topicName;


    public int getTopicThumb() {
        return topicThumb;
    }

    public void setTopicThumb(int topicThumb) {
        this.topicThumb = topicThumb;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public FAQ_Topic(int topicThumb, String topicName) {
        this.topicThumb = topicThumb;
        this.topicName = topicName;
    }
}
