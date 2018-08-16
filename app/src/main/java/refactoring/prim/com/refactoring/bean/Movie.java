package refactoring.prim.com.refactoring.bean;

import refactoring.prim.com.refactoring.price.ChildrensPrice;
import refactoring.prim.com.refactoring.price.NewReleasePrice;
import refactoring.prim.com.refactoring.price.Price;
import refactoring.prim.com.refactoring.price.RegularPrice;

/**
 * @author prim
 * @version 1.0.0
 * @desc 影片 分为三种影片 普通片 儿童片 新片
 * @time 2018/8/16 - 下午4:48
 */
public class Movie {
    public static final int CHILDREND = 2;
    public static final int REGULAR = 0;
    public static final int NEW_REGLEASE = 1;

    private String _title;//影片的名称

//    private int _priceCode;//影片的种类

    //保存Price 变量 而不是在保存_priceCode了

    /**
     * 这样的写的好处：如果要修改任何与价格有关的行为，或者添加新的定价标准，或者加入其他取决于价格的行为，
     * 或者改变常客积分
     * 程序代码的修改会容易很多
     */
    private Price _price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        //this._priceCode=_priceCode;
        //将这里改动一下，并且不会影响之前的逻辑,非常好的设计思路
        set_priceCode(_priceCode);
    }

    public String get_title() {
        return _title;
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    /**
     * 设置不同的影片类型
     * @param _priceCode
     */
    public void set_priceCode(int _priceCode) {
        switch (_priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDREND:
                _price = new ChildrensPrice();
                break;
            case NEW_REGLEASE:
                _price = new NewReleasePrice();
                break;
        }
    }

    /**
     * 影片的费用计算应当放到 影片相关的类中去。
     * 运用多态 取代与价格相关的条件逻辑
     * getCharge 应该放到movie类中去 如果增加了新的影片类型，这样可以最低限度的减少影片类型变动或者价格变动带来的影响
     * new: 运用多态实现每个影片的类型，在每个影片的类型中去计算费用。
     * @return
     */
    public double getCharge(int daysRental) {
        //将switch 逻辑移到Price 类，将case语句移到具体的Price类中去覆盖getCharge，将switch完全取代掉。
        //若影片的类型价格有变动 只需要改动具体的Price类即可
        return _price.getCharge(daysRental);
    }

    /**
     * 计算租赁积分，为什么将它放入到影片相关的类中？
     * 因为租赁积分和影片的类型有关，如果将来影片的类型变动，积分不同这样可以将代码变动的影响降到最低
     * new:同理，运用多态实现每个影片的类型，在每个影片的类型中去计算积分
     * @param daysRental
     * @return
     */
    public int getFrequentRenterPoints(int daysRental) {
        //将积分的计算，分到每个具体的影片类型中去，为将来存在的变动，将代码的变动影响到最低
        return _price.getFrequentRenterPoints(daysRental);
    }
}
