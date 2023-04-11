package org.example.wiseSaying.wiseSay.controller;

import org.example.wiseSaying.Container;
import org.example.wiseSaying.WiseSay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayController {
    private int index;
    private List<WiseSay> book;

    public WiseSayController() {
        this.index =1;
        this.book = new ArrayList<>();
    }

    public void write() {

        System.out.print("명언: ");
        String content = Container.getSc().nextLine().trim();

        System.out.print("작가: ");
        String author = Container.getSc().nextLine().trim();

        WiseSay say = new WiseSay(index, content, author);
        book.add(say);

        System.out.printf("%d번 명령이 등록되었습니다.\n", index);
        index++;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (WiseSay wiseSay : book) {
            System.out.printf("%d / %s / %s\n", wiseSay.getIndex(), wiseSay.getAuthor(), wiseSay.getContent());
        }
    }
}
