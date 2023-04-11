package org.example.wiseSaying.wiseSay.Entity;

public class WiseSay {
    private int index;

    private String content;
    private String author;


    public WiseSay(int index, String author, String content) {
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
}
