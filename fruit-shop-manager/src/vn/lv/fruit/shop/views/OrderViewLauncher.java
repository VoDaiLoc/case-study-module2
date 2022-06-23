package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.utils.AppUtils;

import java.util.Scanner;

public class OrderViewLauncher {
    public static void run(){
        int option;
        do {
            MainLauncher.orderMenu();
            Scanner scanner = new Scanner(System.in);
            OrderView orderView = new OrderView();
            System.out.println("\nChọn chức năng");
            option = AppUtils.retryChoose(0, 3);
            switch (option) {
                case 1:
                    orderView.addOrder();
                    break;
                case 2:
                    orderView.showAllOrder();
                    break;
                case 3:
                    MainLauncher.menuOption();
                    break;
                case 0:
                    AppUtils.exit();
                default:
                    System.out.println("Chọn sai! vui lòng nhập lại");
                    run();
            }
        } while (option!=3);
    }
}
