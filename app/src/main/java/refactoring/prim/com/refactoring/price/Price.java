package refactoring.prim.com.refactoring.price;

import refactoring.prim.com.refactoring.bean.Movie;

/**
 * @author prim
 * @version 1.0.0
 * @desc 影片价格的抽象类基类
 * @time 2018/8/16 - 下午6:40
 */
public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRental);

    /**
     * 超类 - 默认返回 1 ，子类可以重写此方法，积分计算的逻辑自己去实现
     * @param daysRental
     * @return
     */
    public int getFrequentRenterPoints(int daysRental){
        return 1;
    }
}
