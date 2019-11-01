
import com.mymavenexperiments.paddlinglogbook.application.*;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Descents d = new Descents();
        System.out.println(d.countDescents());
        d.addDescent(new Descent(2, LocalDate.of(2016, Month.APRIL, 20), "Modena", "Panaro", "cava"));
        d.addDescent(new Descent(3, LocalDate.of(2016, Month.APRIL, 25), "Bologna", "Limentra", "classico"));
        d.addDescent(new Descent(2, LocalDate.of(2016, Month.APRIL, 22), "Bologna", "Santerno", "basso"));
        d.addDescent(new Descent(4, LocalDate.of(2016, Month.JULY, 10), "Trentino", "Noce", "gole"));
        System.out.println(d.countDescents());
        System.out.println(d.listAllDescents());
    }

}
