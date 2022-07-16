package com.ll.example;


import java.util.Scanner;

public class App {
    private Scanner sc = new Scanner(System.in);

    public void run() {
        WiseSayingController wiseSayingController = new WiseSayingController();

        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.create();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(rq);
            break;
                case "수정":
                    wiseSayingController.edit(rq);
                    break;
            case "종료":
                break outer;
            }
        }
        sc.close();
    }

}

