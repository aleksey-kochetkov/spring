package e;

import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MainTest {
    @Test
    public void whenSimple() {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      try (PrintStream o = new PrintStream(out)) {
        new Main().run(o);
      }
      try (Scanner in = new Scanner(
                          new ByteArrayInputStream(out.toByteArray()))) {
        String result = in.nextLine();
        assertEquals("Person{name:Dick,age:39,height:170.000000,"
                           + "programmer:true,id:700700700700}", result);
        result = in.nextLine();
        assertEquals("Person{name:Mara,age:36,height:150.000000,"
                          + "programmer:false,id:600000000000}", result);
      }
    }
}
