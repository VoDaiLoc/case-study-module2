package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.utils.AppUtils;

import java.util.Scanner;

public class MemberView {
    public static void launch() {
        int option;
        do {
            System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                    "║                                                                                                                                                                              ║\n" +
                    "║                                                                                  \033[1;94mMEMBER MENU\033[0m                                                                                   ║\n" +
                    "║                                                                                                                                                                              ║\n" +
                    "║                                                                                                                                                                              ║\n" +
                    "║                                                                            [1] \033[0;95mHiển thị sản phẩm\033[0m                                                                              ║\n" +
                    "║                                                                            [2] \033[0;95mTìm kiếm sản phẩm\033[0m                                                                             ║\n" +
                    "║                                                                            [3] \033[0;95mSắp xếp sản phẩm\033[0m                                                                             ║\n" +
                    "║                                                                            [4] \033[0;95mTạo Order\033[0m                                                                             ║\n" +
                    "║                                                                            [5] \033[0;95mXem danh sách Order\033[0m                                                                             ║\n" +
                    "║                                                                            [6] \033[0;95mQuay lại\033[0m                                                                                      ║\n" +
                    "║                                                                            [0] \033[0;95mThoát\033[0m                                                                                         ║\n" +
                    "║                                                                                                                                                                              ║\n" +
                    "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            OrderView orderView = new OrderView();
            System.out.println("\nChọn chức năng: ");
            option = AppUtils.retryChoose(0,6);
            switch (option) {
                case 1:
                    productView.showProducts(InputOption.SHOW);
                    break;
                case 2:
                    productView.findProduct();
                    break;
                case 3:
                    productView.sortByPrice();
                    break;
                case 4:
                    orderView.addOrder();
                    break;
                case 5:
                    orderView.showAllOrder();
                    break;
                case 6:
                    break;
                case 0:
                    AppUtils.exit();
                    break;
                default:
                    System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    launch();
            }
        } while (option!=3);
    }
}
