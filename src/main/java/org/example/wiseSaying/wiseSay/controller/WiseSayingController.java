package org.example.wiseSaying.wiseSay.controller;

import org.example.wiseSaying.Container;
import org.example.wiseSaying.Rq;
import org.example.wiseSaying.wiseSay.Service.WiseSayingService;
import org.example.wiseSaying.wiseSay.entity.WiseSay;

import java.util.List;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(WiseSayingService wiseSayingService) {
        this.wiseSayingService = wiseSayingService;
    }

    public void write() {

        System.out.print("명언: ");
        String content = Container.getSc().nextLine().trim();

        System.out.print("작가: ");
        String author = Container.getSc().nextLine().trim();

        int index = wiseSayingService.write(content, author);

        System.out.printf("%d번 명령이 등록되었습니다.\n", index);

    }

    public void list() {
        List<WiseSay> book = wiseSayingService.findAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (WiseSay wiseSay : book) {
            System.out.printf("%d / %s / %s\n", wiseSay.getIndex(), wiseSay.getContent(), wiseSay.getAuthor());
        }
    }

    public void remove(Rq rq) {
        int index = rq.getParameterInt("id", -1);

        if (index == -1) {
            System.out.println("id는 정수로 입력해주세요.");
            return;
        }
        WiseSay wiseSay = wiseSayingService.findBtIndex(index);

        if (wiseSay == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",index);
            return;
        }

        wiseSayingService.remove(wiseSay);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", index);
    }

    public void update(Rq rq) {
        int index = rq.getParameterInt("id", -1);

        if (index==-1) {
            System.out.println("id는 정수값으로 입력해주세요.");
            return;
        }

        WiseSay wiseSay = wiseSayingService.findBtIndex(index);

        if (wiseSay == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", index);
            return;
        }

        System.out.printf("기존 명언 : %s\n", wiseSay.getContent());
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();

        System.out.printf("기존 저자 : %s\n", wiseSay.getAuthor());
        System.out.print("저자 : ");
        String author = Container.getSc().nextLine().trim();

        wiseSayingService.update(wiseSay, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n",index);
    }
}