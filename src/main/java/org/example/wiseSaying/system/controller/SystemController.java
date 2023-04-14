package org.example.wiseSaying.system.controller;

import org.example.wiseSaying.Container;
import org.example.wiseSaying.wiseSay.entity.WiseSay;

import java.util.List;

public class SystemController {

    public void exit() {
        System.out.println("명언 앱을 종료합니다.");
    }

    public static void build(List<WiseSay> book) {
        System.out.println("데이터를 빌드합니다.");
        Container.getUtil().saveObjToJsonFile(book);
    }

}
