package org.example.wiseSaying.wiseSay.Service;

import org.example.wiseSaying.wiseSay.entity.WiseSay;

import java.util.List;

public class WiseSayingService {
    private int index;
    private List<WiseSay> book;

    public WiseSayingService(int index, List<WiseSay> book) {
        this.index = index;
        this.book = book;
    }

    public int write(String content, String author) {
        WiseSay say = new WiseSay(index, content, author);

        book.add(say);
        index++;

        return index;
    }

    public List<WiseSay> findAll() {
        return book;
    }

    public WiseSay findBtIndex(int index) {
        for (WiseSay wiseSay : book) {
            if (wiseSay.getIndex() == index) {
                return wiseSay;
            }
        }
        return null;
    }

    public void remove(WiseSay wiseSay) {
        book.remove(wiseSay);
    }

    public void update(WiseSay wiseSay, String content, String author) {
        wiseSay.setContent(content);
        wiseSay.setAuthor(author);
    }
}
