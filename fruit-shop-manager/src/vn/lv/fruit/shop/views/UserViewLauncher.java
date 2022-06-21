package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.utils.AppUtils;

import java.util.Scanner;

//So Code dài các bạn không hiểu nên tách sang đây
public class UserViewLauncher {
    //    public static void main(String[] args) {
//        launch();
//    }
    public static void launch() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        int option = -1;
        do {
            MainLauncher.userMenu();
            try {
                do {
                    System.out.println("Chọn chức năng");
                    System.out.print(" ⭆ ");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option > 5 || option < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (option > 5 || option < 0);

                switch (option) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 4:
                        userView.remove();
                        break;
                    case 5:
                        break;
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (option != 5);

    }

}
