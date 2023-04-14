package org.example.wiseSaying.wiseSay.repository;

import org.example.wiseSaying.Container;
import org.example.wiseSaying.wiseSay.entity.WiseSay;

import java.util.List;

public class WiseSayingRepository {

    private int index;
    private List<WiseSay> book;

    public WiseSayingRepository() {
        this.index = 0;
        this.book = Container.getUtil().readJson();
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

    public int write(String content, String author) {
        WiseSay say = new WiseSay(index, content, author);

        book.add(say);
        index++;

        return index;
    }
}
