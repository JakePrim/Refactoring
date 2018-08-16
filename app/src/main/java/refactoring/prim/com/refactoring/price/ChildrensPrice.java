package refactoring.prim.com.refactoring.price;

import refactoring.prim.com.refactoring.bean.Movie;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/8/16 - 下午6:43
 */
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREND;
    }

    @Override
    public double getCharge(int daysRental) {
        //抽离租赁费用计数 计算当个影片的租赁费用
        double result = 1.5;
        if (daysRental > 3) {//如果租赁天数大于3天，按1.5的优惠价格
            result += (daysRental - 3) * 1.5;
        }
        return result;
    }
}
