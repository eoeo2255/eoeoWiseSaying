package org.example.wiseSaying.wiseSay.repository;

import org.example.wiseSaying.Container;
import org.example.wiseSaying.wiseSay.entity.WiseSaying;

import java.util.List;

public class WiseSayingRepository {

    private int index;
    private List<WiseSaying> book;

    public WiseSayingRepository() {
        this.index = 0;
        this.book = Container.getUtil().readJson();
    }

    public List<WiseSaying> findAll() {
        return book;
    }

    public WiseSaying findBtIndex(int index) {
        for (WiseSaying wiseSaying : book) {
            if (wiseSaying.getIndex() == index) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void remove(WiseSaying wiseSaying) {
        book.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public int write(String content, String author) {
        WiseSaying say = new WiseSaying(index, content, author);

        book.add(say);
        index++;

        return index;
    }
}
