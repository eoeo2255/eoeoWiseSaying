package org.example.wiseSaying;

import org.example.wiseSaying.system.controller.SystemController;
import org.example.wiseSaying.wiseSay.controller.WiseSayController;

public class App {

    public void run(){
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayController wiseSayController = new WiseSayController();

        while (true){
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getAction()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayController.write();
                    break;
                case "목록":
                    wiseSayController.list();
                    break;
                case "삭제":
                    break;
            }
        }
    }
}