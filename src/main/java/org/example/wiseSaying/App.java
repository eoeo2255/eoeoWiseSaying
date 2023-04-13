package org.example.wiseSaying;

import org.example.wiseSaying.system.controller.SystemController;
import org.example.wiseSaying.wiseSay.controller.WiseSayingController;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getAction()) {
                case "종료" -> {
                    systemController.exit();
                    return;//break를 걸 경우, switch문이 종료됐다가 while문 안에서 다시 돌기때문에 return으로 메서드 자체를 종료시켜준다.
                }
                case "등록" -> wiseSayingController.write();
                case "목록" -> wiseSayingController.list();
                case "삭제" -> wiseSayingController.remove(rq);
                case "수정" -> wiseSayingController.update(rq);
            }
        }
    }
}
