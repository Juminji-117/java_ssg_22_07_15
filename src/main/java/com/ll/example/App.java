package com.ll.example;


import java.util.Scanner;

public class App {


    public void run() {
        Scanner sc = new Scanner(System.in);
        WiseSayingController wiseSayingRepository = new WiseSayingController();

        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            //switch문 불편한 점: 여러 개의 초기화된 같은 의미 지역변수 생성 필요 ex.paramId, paramId_
            switch (rq.getPath()) {
                case "등록":
                    WiseSayingController.write();
                    break;
                case "목록":
                    WiseSayingController.list();
                    break;
                case "삭제":
                    WiseSayingController.remove(rq);
            break;
                case "수정":
                    WiseSayingController.modify(rq);
                    break;
            case "종료":
                break outer;
        }
            }
        sc.close();
        }



}

