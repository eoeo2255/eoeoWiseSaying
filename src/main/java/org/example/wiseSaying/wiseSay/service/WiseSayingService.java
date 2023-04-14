package org.example.wiseSaying.wiseSay.service;

import org.example.wiseSaying.wiseSay.entity.WiseSay;
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

    public List<WiseSay> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSay findBtIndex(int index) {
        return wiseSayingRepository.findBtIndex(index);
    }

    public void remove(WiseSay wiseSay) {
        wiseSayingRepository.remove(wiseSay);
    }

    public void update(WiseSay wiseSay, String content, String author) {
        wiseSayingRepository.update(wiseSay, content, author);
    }
}
