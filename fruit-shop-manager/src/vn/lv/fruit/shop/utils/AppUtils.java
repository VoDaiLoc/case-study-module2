package vn.lv.fruit.shop.utils;

import vn.lv.fruit.shop.views.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
        return option;
    }

    public static long retryParseLong() {
        long result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static String retryString() {
        String result;
        System.out.print(" ⭆ ");
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.println("không được để trống");
            System.out.print(" ⭆ ");
        }
        return result;
    }


    public static double retryParseDouble() {
        double result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static String doubleToKg(double value) {
        String patternKg;
        if (value<1) {
            patternKg = "0.# Kg";
        }
        else patternKg = ".# Kg";
        DecimalFormat decimalFormat = new DecimalFormat(patternKg);
        return decimalFormat.format(value);
    }

    public static boolean isRetry(InputOption inputOption) {
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'y' để sửa tiếp \t|\t 'q' để quay lại\t|\t 't' để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'q' để quay lại\t|\t 't' để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }

            System.out.print(" ⭆ ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    return true;
                case "q":
                    return false;
                case "t":
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);
    }

    public static void exit() {
        System.out.println("\tTạm biệt. Hẹn gặp lại lần sau!");
        System.exit(5);
    }
}
