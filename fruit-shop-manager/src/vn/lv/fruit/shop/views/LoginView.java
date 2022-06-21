package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.model.Role;
import vn.lv.fruit.shop.model.User;
import vn.lv.fruit.shop.services.IUserService;
import vn.lv.fruit.shop.services.UserService;
import vn.lv.fruit.shop.utils.AppUtils;

import java.util.Scanner;


public class LoginView {//Single Responsibility Principle (SOLID)
    private final IUserService userService; //Dependency Inversion Principle (SOLID)
    private final Scanner scanner = new Scanner(System.in);
    User user = new User();

    public LoginView() {
        userService = UserService.getInstance();
    }

    public void login() {
        boolean isRetry = false;
        System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                                                                                                                                                              ║\n" +
                "║                                                                                  \033[1;94mĐĂNG NHẬP HỆ THỐNG\033[0m                                                                          ║\n" +
                "║                                                                                                                                                                              ║\n" +
                "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");

        do {
            System.out.println("Username");
            String username = AppUtils.retryString();
            System.out.println("Mật khẩu");
            String password = AppUtils.retryString();
            user = userService.login(username, password);
            if (user == null) {
                System.out.println("Tài khoản không hợp lệ! ");
                isRetry = isRetry();
                login();
            }
             if (user.getRole()==Role.ADMIN){
                System.out.println("Bạn đã đăng nhập với quyền Admin thành công!");
                System.out.println("CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI CỬA HÀNG TRÁI CÂY NHÀ LÀM\n");
                MainLauncher.menuOption();
            }
            else {
                System.out.println("Bạn đã đăng nhập với quyền User thành công!");
                System.out.println("CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI CỬA HÀNG TRÁI CÂY NHÀ LÀM\n");
                MemberView.launch();
            }
        } while (isRetry);
    }

    private boolean isRetry() {
        do {
            try {
                System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                                       \033[1;94mMENU\033[0m                                                                                   ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                       [1] \033[0;95mNhập 'y' để tiếp tục đăng nhập\033[0m                                                                     ║\n" +
                        "║                                                                       [2] \033[0;95mNhập 'n' để thoát khỏi chương trình\033[0m                                                                ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");

                System.out.print(" ⭆ ");
                String option = scanner.nextLine();
                switch (option) {
                    case "y":
                        return true;
                    case "n":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
                ex.printStackTrace();
            }
        } while (true);
    }
}
