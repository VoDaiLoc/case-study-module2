package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.utils.AppUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductViewLauncher {
    public static void run() {
        int option;
        do {
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            MainLauncher.productMenu();
            System.out.println("\nChọn chức năng: ");
            option = AppUtils.retryChoose(0,7);
                switch (option) {
                    case 1:
                        productView.add();
                        break;
                    case 2:
                        productView.update();
                        break;
                    case 3:
                        productView.showProducts(InputOption.SHOW);
                        break;
                    case 4:
                        productView.remove();
                        break;
                    case 5:
                        productView.findProduct();
                        break;
                    case 6:
                        productView.sortByPrice();
                        break;
                    case 7:
                        break;
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        run();
                }
        } while (option!=7);
    }
}
