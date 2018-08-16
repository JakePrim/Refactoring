package refactoring.prim.com.refactoring.price;

import refactoring.prim.com.refactoring.bean.Movie;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/8/16 - 下午6:43
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_REGLEASE;
    }

    @Override
    public double getCharge(int daysRental) {
        //抽离租赁费用计数 计算当个影片的租赁费用
        return (double) (daysRental * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRental) {
        return daysRental > 1 ? 2 : 1;
    }
}
