package org.example.wiseSaying.wiseSay.service;

import org.example.wiseSaying.wiseSay.entity.WiseSaying;
import org.example.wiseSaying.wiseSay.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public int write(String content, String author) {
        return wiseSayingRepository.write(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findBtIndex(int index) {
        return wiseSayingRepository.findBtIndex(index);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying, String content, String author) {
        wiseSayingRepository.update(wiseSaying, content, author);
    }
}
