package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.utils.AppUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        UserViewLauncher.launch();
                        break;
                    case 2:
                        ProductViewLauncher.run();
                        break;
                    case 3:
                        OrderViewLauncher.run();
                        break;
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }



    public static void mainMenu() {
        System.out.print( "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                  \033[1;94mMAIN MENU\033[0m                                                                                   ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                            [1] \033[0;95mQuản lý người dùng\033[0m                                                                            ║\n" +
                "║                                                                            [2] \033[0;95mQuản lý sản phẩm\033[0m                                                                              ║\n" +
                "║                                                                            [3] \033[0;95mQuản lý đơn đặt hàng\033[0m                                                                          ║\n" +
                "║                                                                            [0] \033[0;95mThoát\033[0m                                                                                         ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public static void userMenu() {
        System.out.print( "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                  \033[1;94mUSER MANGEMENT\033[0m                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                            [1] \033[0;95mThêm người dùng\033[0m                                                                               ║\n" +
                "║                                                                            [2] \033[0;95mSửa thông tin người dùng\033[0m                                                                      ║\n" +
                "║                                                                            [3] \033[0;95mHiển danh sách người dùng\033[0m                                                                     ║\n" +
                "║                                                                            [4] \033[0;95mXóa người dùng\033[0m                                                                                ║\n" +
                "║                                                                            [5] \033[0;95mQuay lại\033[0m                                                                                      ║\n" +
                "║                                                                            [0] \033[0;95mThoát\033[0m                                                                                         ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public static void productMenu() {
        System.out.print( "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                  \033[1;94mPRODUCT MANGEMENT\033[0m                                                                           ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                            [1] \033[0;95mThêm sản phẩm\033[0m                                                                                 ║\n" +
                "║                                                                            [2] \033[0;95mSửa thông tin sản phẩm\033[0m                                                                        ║\n" +
                "║                                                                            [3] \033[0;95mHiển thị sản phẩm\033[0m                                                                             ║\n" +
                "║                                                                            [4] \033[0;95mXóa sản phẩm\033[0m                                                                                  ║\n" +
                "║                                                                            [5] \033[0;95mTìm kiếm sản phẩm\033[0m                                                                             ║\n" +
                "║                                                                            [6] \033[0;95mSắp xếp sản phẩm\033[0m                                                                              ║\n" +
                "║                                                                            [7] \033[0;95mQuay lại\033[0m                                                                                      ║\n" +
                "║                                                                            [0] \033[0;95mThoát\033[0m                                                                                         ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public static void orderMenu() {
        System.out.print( "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                  \033[1;94mORDER MENU\033[0m                                                                                  ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                            [1] \033[0;95mTạo order\033[0m                                                                                     ║\n" +
                "║                                                                            [2] \033[0;95mXem danh sách order\033[0m                                                                           ║\n" +
                "║                                                                            [3] \033[0;95mQuay lại\033[0m                                                                                      ║\n" +
                "║                                                                            [0] \033[0;95mThoát\033[0m                                                                                         ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }
}