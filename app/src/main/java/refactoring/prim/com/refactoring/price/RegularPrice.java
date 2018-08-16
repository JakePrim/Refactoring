package refactoring.prim.com.refactoring.price;

import refactoring.prim.com.refactoring.bean.Movie;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/8/16 - 下午6:44
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRental) {
        //抽离租赁费用计数 计算当个影片的租赁费用
        double result = 2;
        if (daysRental > 2) {//如果租赁天数大于2天按1.5 的优惠价格
            result += (daysRental - 2) * 1.5;
        }
        return result;
    }
}
