import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {

    @Test

    public void LengthGreaterThanZero() {
        Main mort = new Main();
        String text = mort.readFile("prospects.txt");
        Assert.assertTrue("Empty string was returned",text.length() > 0);
    }

    @Test
    public void AddsCorrectAmmountOfCustomers(){
        ArrayList list = new ArrayList();
        Main mort = new Main();
        list.add(new Prospect("bill", 10000, 15, 2 ));
        list.add(new Prospect("bill", 10000, 15, 2 ));
        list.add(new Prospect("bill", 10000, 15, 2 ));
        list.add(new Prospect("bill", 10000, 15, 2 ));

        Assert.assertTrue(list.size() == 4);


    }

}
