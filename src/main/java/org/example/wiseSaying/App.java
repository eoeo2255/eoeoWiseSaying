package org.example.wiseSaying;

import org.example.wiseSaying.system.controller.SystemController;
import org.example.wiseSaying.wiseSay.controller.WiseSayController;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayController wiseSayController = new WiseSayController();

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getAction()) {
                case "종료" -> {
                    systemController.exit();
                    return;//break를 걸 경우, switch문이 종료됐다가 while문 안에서 다시 돌기때문에 return으로 메서드 자체를 종료시켜준다.
                }
                case "등록" -> wiseSayController.write();
                case "목록" -> wiseSayController.list();
                case "삭제" -> wiseSayController.remove(rq);
            }
        }
    }
}
