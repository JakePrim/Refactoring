package refactoring.prim.com.refactoring.bean;

/**
 * @author prim
 * @version 1.0.0
 * @desc 租赁 bean类
 * @time 2018/8/16 - 下午4:55
 */
public class Rental {
    private Movie _movie;//租赁的影片
    private int _daysRental;//租赁的天数

    public Rental(Movie movie, int days) {
        this._movie = movie;
        this._daysRental = days;
    }

    public int getDaysRental() {
        return _daysRental;
    }

    public Movie getMovie() {
        return _movie;
    }

    /**
     * 租赁影片的费用
     * @return
     */
    public double getCharge(){
        //将租赁的天数传递给影片类中，费用交给影片类去计算，为以后到来的变动降到最低
        return _movie.getCharge(_daysRental);
    }

    /**
     * 计算单个影片的租赁积分
     * @return
     */
    public int getFrequentRenterPoints() {
        //因为租赁积分跟影片的类型有关，所以将积分的计算放入到影片的类中去，如果未来要改动积分，只需要改动影片类的逻辑即可
        return _movie.getFrequentRenterPoints(_daysRental);
    }
}
