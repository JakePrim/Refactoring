package refactoring.prim.com.refactoring;

import org.junit.Test;

import refactoring.prim.com.refactoring.bean.Customer;
import refactoring.prim.com.refactoring.bean.Movie;
import refactoring.prim.com.refactoring.bean.Rental;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){

        Customer prim = new Customer("Prim");


        Movie movie1 = new Movie("西红柿首富", Movie.NEW_REGLEASE);

        Rental rental = new Rental(movie1, 1);

        Rental rental1 = new Rental(new Movie("我不是药神",Movie.NEW_REGLEASE),3);

        Rental rental2 = new Rental(new Movie("光头强", Movie.CHILDREND), 3);

        Rental rental3 = new Rental(new Movie("火影忍着", Movie.REGULAR), 3);

        prim.addRental(rental);

        prim.addRental(rental1);

        prim.addRental(rental2);
        prim.addRental(rental3);

        String statement = prim.htmlStatement();

        System.out.println(statement);
    }
}