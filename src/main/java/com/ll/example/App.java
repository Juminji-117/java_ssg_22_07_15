package com.ll.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);
        int lastId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();

                    int id = ++lastId;

                    System.out.printf("%d번 명언이 등록되었습니다.\n",id);


                    WiseSaying wiseSaying = new WiseSaying(id,content,author);
                    wiseSayings.add(wiseSaying);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (WiseSaying temp : wiseSayings) {
                        System.out.printf("%d / %s / %s\n", temp.id, temp.content, temp.author);
                    }
                    break;
                case "삭제":
                    System.out.println("id를 입력해주세요.");
                    id = sc.nextInt();
                    if (wiseSayings.get(id) == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
                        continue;
                    }

                    wiseSayings.remove(id);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n",id);
                    break;
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }
}

