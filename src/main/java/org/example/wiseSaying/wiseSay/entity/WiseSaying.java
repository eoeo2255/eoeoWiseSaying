package org.example.wiseSaying.wiseSay.entity;

public class WiseSaying {
    private int index;

    private String content;
    private String author;

    public WiseSaying() {
    }

    public WiseSaying(int index, String author, String content) {
        this.index = index;
        this.author = author;
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
