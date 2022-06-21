package vn.lv.fruit.shop;

import vn.lv.fruit.shop.model.Order;
import vn.lv.fruit.shop.model.OrderItem;
import vn.lv.fruit.shop.utils.InstantUtils;
import vn.lv.fruit.shop.views.MainLauncher;
import vn.lv.fruit.shop.views.MemberView;
import vn.lv.fruit.shop.views.OrderView;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
//        MainLauncher.launch();
//        OrderView orderView = new OrderView();
//        orderView.showPaymentInfo(new OrderItem(1655787202,33000.0,10.0,1655787194,1655718973,"Chuối",330000.0, Instant.now()),
//                new Order(1655787194,"Lộc Võ","0987654321","Huế"));
        MemberView.launch();
    }
}
