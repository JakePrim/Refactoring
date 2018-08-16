package refactoring.prim.com.refactoring.bean;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author prim
 * @version 1.0.0
 * @desc 顾客
 * @time 2018/8/16 - 下午4:58
 */
public class Customer {
    //顾客的名称
    private String _name;
    //顾客的租赁信息列表
    private Vector<Rental> _rentals = new Vector<>();//相当于线程安全的ArrayList

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    //添加租赁
    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    /**
     * 如何重构 statement
     * 1 找出函数内的局部变量和参数 rental thisAmount
     *
     * @return
     */
    public String statement() {
//        double totalAmount = 0;//总金额 去掉临时变量，添加查询函数

//        int fequentRenterPoints = 0;//积分 去掉临时变量，添加查询函数

        //Enumeration 可以遍历列表
        Enumeration<Rental> elements = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {//遍历租赁信息列表
//            double thisAmount = 0; 尽量删除临时变量，因为这些临时变量往往会引发问题

            //获取租赁信息 从第0个开始 return elementData(count++);
            Rental rental = elements.nextElement();

            //租赁费用计算 模块
//            thisAmount = rental.getCharge();//这里显然是多余的部分

            // 优化抽离常客积分模块，我们可以在租赁的bean中计算积分
//            fequentRenterPoints = rental.getFrequentRenterPoints();

            //租赁积分+1
//            fequentRenterPoints ++;
//
//            //如果租赁新的影片 并且租赁天数大于 1天 积分+1
//            if ((rental.getMovie().get_priceCode() == Movie.NEW_REGLEASE) && rental.getDaysRental() > 1){
//                fequentRenterPoints++;
//            }

            //注意这里 rental.getCharge() 被计算了两次，我们需要去rental 中去优化它

            //显示返回结果
            result += "\t" + rental.getMovie().get_title() + "\t" + String.valueOf(rental.getCharge()) + "\n";

            //计算总的租赁费用
//            totalAmount += rental.getCharge();
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 整体重构后的代码，可以与上面的代码进行对比
     * @return
     */
    public String htmlStatement(){
        Enumeration<Rental> elements = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (elements.hasMoreElements()){
            Rental rental = elements.nextElement();
            result += "\t" + rental.getMovie().get_title() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 去除临时变量，添加查询函数，干净整洁的设计,可以提供外部调用，而不需要清楚这些租赁费用计算的逻辑，就可以直接使用
     * 但是while循环增加了性能上的消耗
     * @return
     */
    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> elements = _rentals.elements();
        while (elements.hasMoreElements()) {
            Rental rental = elements.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    /**
     * 去除临时变量，添加查询函数，干净整洁的设计，而不需要清楚这些租赁积分计算的逻辑，就可以直接使用，提供外部调用
     * 但是while循环增加了性能上的消耗
     * @return
     */
    public double getTotalRenterPoints(){
        double result =0;
        Enumeration<Rental> elements = _rentals.elements();
        while (elements.hasMoreElements()){
            Rental rental = elements.nextElement();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }


}
