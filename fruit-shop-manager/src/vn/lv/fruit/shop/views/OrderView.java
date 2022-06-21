package vn.lv.fruit.shop.views;

import vn.lv.fruit.shop.model.Order;
import vn.lv.fruit.shop.model.OrderItem;
import vn.lv.fruit.shop.model.Product;
import vn.lv.fruit.shop.services.*;
import vn.lv.fruit.shop.utils.AppUtils;
import vn.lv.fruit.shop.utils.InstantUtils;
import vn.lv.fruit.shop.utils.ValidateUtils;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;


public class OrderView {//Single Responsibility Principle (SOLID)

    private final IProductService productService;//Dependency Inversion Principle (SOLID)


    private final IOrderService orderService; //Dependency Inversion Principle (SOLID)


    private final IOrderItemService orderItemService; //Dependency Inversion Principle (SOLID)
    private final Scanner scanner = new Scanner(System.in);

    public OrderView() {
        productService = ProductService.getInstance();
        orderService = OrderService.getInstance();
        orderItemService = OrderItemService.getInstance();
    }

    public OrderItem addOrderItems(long orderId) {
        orderItemService.findAll();
        ProductView productView = new ProductView();
        productView.showProducts(InputOption.ADD);
        long id = System.currentTimeMillis() / 1000;
        System.out.println("Nhập id sản phẩm: ");
        long fruitId = AppUtils.retryParseLong();
        while (!productService.existsById(fruitId)) {
            System.out.println("Id sản phẩm không tồn tại");
            System.out.println("Nhập id sản phẩm: ");
            System.out.print(" ⭆ ");
            fruitId = AppUtils.retryParseLong();
        }
        Product product = productService.findById(fruitId);
        double price = product.getPrice();
        double oldQuantity = product.getQuantity();
        System.out.println("Nhập số lượng: ");
        double quantity = AppUtils.retryParseDouble();
        while (!checkQualityFruit(product, quantity)) {
            System.out.println("Vượt quá số lượng! Vui lòng nhập lại");
            System.out.println("Nhập số lượng");
            quantity = AppUtils.retryParseDouble();
        }
        String fruitName = product.getTitle();
        double total = quantity * price;
        double currentQuantity = oldQuantity - quantity;
        product.setQuantity(currentQuantity);
        productService.update(product);
        Instant creatAt = Instant.now();// xem
        OrderItem orderItem = new OrderItem(id, price, quantity, orderId, fruitId, fruitName, total, creatAt);
        return orderItem;
    }

    public boolean checkQualityFruit(Product product, double quantity) {
        if (quantity <= product.getQuantity())
            return true;
        else
            return false;
    }

    public void addOrder() {
        try {
            orderService.findAll();
            long orderId = System.currentTimeMillis() / 1000;
            System.out.println("Nhập họ và tên (vd: Tui Khong Ngu) ");
            System.out.print(" ⭆ ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isNameValid(name)) {
                System.out.println("Tên " + name + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
                System.out.println("Nhập tên (vd: Ban Ngu) ");
                System.out.print(" ⭆ ");
                name = scanner.nextLine();
            }
            System.out.println("Nhập số điên thoại: ");
            System.out.print(" ⭆ ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0987654321)");
                System.out.print(" ⭆ ");
                phone = scanner.nextLine();
            }
            System.out.println("Nhập địa chỉ: ");
            String address = AppUtils.retryString();
            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address);
            orderItemService.add(orderItem);
            orderService.add(order);
            System.out.println("Tạo đơn hàng thành công!");
            do {
                System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                                  \033[1;94mOPTION\033[0m                                                                                      ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "║                                                                            [1] \033[0;95mNhấn 'y' để tạo tiếp đơn hàng\033[0m                                                                 ║\n" +
                        "║                                                                            [2] \033[0;95mNhấn 'q' để trở lại\033[0m                                                                           ║\n" +
                        "║                                                                            [3] \033[0;95mNhấn 'p' để in hoá đơn\033[0m                                                                        ║\n" +
                        "║                                                                            [4] \033[0;95mNhấn 't' để thoát\033[0m                                                                             ║\n" +
                        "║                                                                                                                                                                              ║\n" +
                        "╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y":
                        addOrder();
                        break;
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "p":
                        showPaymentInfo(orderItem, order);
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai. vui lòng nhập lại!");
        }
    }

//    public void showPaymentInfo(OrderItem orderItem, Order order) {
//        try {
//            System.out.println("----------------------------------------------------------HOÁ ĐƠN----------------------------------------------------------------");
//            System.out.printf("|%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n|", "   Id", "Tên khách hàng", "   SĐT", "Địa chỉ", "Tên sản phẩm", "Số lượng", "Giá", "Ngày tạo");
//            System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n|", order.getId(), order.getFullName(), order.getPhone(),
//                    order.getAddress(), orderItem.getProductName(), AppUtils.doubleToKg(orderItem.getQuantity()), AppUtils.doubleToVND(orderItem.getPrice()), InstantUtils.instantToString(orderItem.getCreatAt()));
//            System.out.println(" ------------------------------------------------------------------------------------------------- Tổng tiền:" +AppUtils.doubleToVND(orderItem.getTotal()));
//            System.out.println("---------------------------------------------SHOP TRÁI CÂY THỊ THUẬN-----------------------------------------------------------------");
//            boolean is = true;
//            do {
//                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
//                System.out.println("Nhấn ");
//                System.out.print(" ⭆ ");
//                String choice = scanner.nextLine();
//                switch (choice) {
//                    case "q":
//                        OrderViewLauncher.run();
//                        break;
//                    case "t":
//                        AppUtils.exit();
//                        break;
//                    default:
//                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
//                        is = false;
//                }
//            } while (!is);
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }
    //
    public void showPaymentInfo(OrderItem orderItem, Order order) {
        try {
            System.out.println("\t\t\t\t╔═══════════════════════════════════════════════════════════════════════════╗");
            System.out.println("\t\t\t\t║                                 HÓA ĐƠN                                   ║");
            System.out.println("\t\t\t\t╠═══════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("\t\t\t\t║\t%-20s\t %-25s %16s ║\n", "Tên đầy đủ   :          ║", order.getFullName(), "");
            System.out.printf("\t\t\t\t║\t%-20s\t %-25s %16s ║\n", "Số điện thoại:          ║", order.getPhone(), "");
            System.out.printf("\t\t\t\t║\t%-20s\t %-25s %16s ║\n", "Địa chỉ      :          ║", order.getAddress(), "");
            System.out.printf("\t\t\t\t║\t%-20s\t %-25s %16s ║\n", "Ngày tạo     :          ║", InstantUtils.instantToString(orderItem.getCreatAt()), "");
            System.out.println("\t\t\t\t╠════╦═══════════════════╦══╩══════════════════════════╦════════════════════╣");
            System.out.printf("\t\t\t\t║%-4s║%-17s\t ║%-28s ║%-19s ║\n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            System.out.println("\t\t\t\t╠════╬═══════════════════╬═════════════════════════════╬════════════════════╣");
            List<OrderItem> orderItems = orderItemService.findAll();
            double sum = 0;
            int count = 0;
            for (OrderItem orderItem1 : orderItems) {
                if (orderItem1.getOrderId() == order.getId()) {
                    sum += orderItem1.getTotal();
                    count++;
                    orderItem1.setTotal(sum);
                    orderItemService.update(orderItem1);
                    System.out.printf("\t\t\t\t║ %1s  ║  %-17s║\t %-25s ║  %-18s║\n",
                            count,
                            orderItem1.getProductName(),
                            orderItem1.getQuantity(),AppUtils.doubleToVND(orderItem1.getPrice()));
                }
            }
            System.out.println("\t\t\t\t╠════╩═══════════════════╩═════════════════════════════╩════════════════════╣");
            System.out.printf("\t\t\t\t║                                                  Tổng: %17s  ║\n",AppUtils.doubleToVND(sum));
            System.out.println("\t\t\t\t╚═══════════════════════════════════════════════════════════════════════════╝\n\n");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("Nhap khong dung! Vui long nhap lai.");
        }
    }

    public void showAllOrder() {
        List<Order> orders = orderService.findAll();
        List<OrderItem> orderItems = orderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        double sum = 0;
        try {
            System.out.println("===============================================================LIST ORDER===============================================================");
            System.out.printf("|%-15s %-15s %-12s %-15s %-15s %-10s %-10s %-15s %-15s    |\n", "   Id", "Tên khách hàng", "  SĐT", "Địa chỉ", "Tên sản phẩm", "Số lượng", "   Giá", "   Tổng" , "  Ngày tạo ");
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------|");
            for (Order order : orders) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId() == order.getId()) {
                        newOrderItem = orderItem;
                        break;
                    }
                }
                System.out.printf("|%-15s %-15s %-12s %-15s %-15s %-10s %-10s %-15s %-15s   |\n",
                        order.getId(),
                        order.getFullName(),
                        order.getPhone(),
                        order.getAddress(),
                        newOrderItem.getProductName(),
                        AppUtils.doubleToKg(newOrderItem.getQuantity()),
                        AppUtils.doubleToVND(newOrderItem.getPrice()),
                        AppUtils.doubleToVND(newOrderItem.getPrice() * newOrderItem.getQuantity()),
                        InstantUtils.instantToString(newOrderItem.getCreatAt())
                );
                sum += newOrderItem.getPrice() * newOrderItem.getQuantity();
            }
            Order order = new Order();
            order.setGrandTotal(sum);
            System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------|");

            System.out.printf("|%-100s Tổng tiền: %12s          |\n"," ",AppUtils.doubleToVND(order.getGrandTotal()));
            System.out.println("|======================================================================================================================================|\n\n");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
