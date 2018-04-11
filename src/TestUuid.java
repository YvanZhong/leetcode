import java.util.UUID;

public class TestUuid {

    public static void main(String[] args) {
        int i = 0;
        while (i < 100000) {
            System.out.println(UUID.randomUUID().toString());
            i++;
        }
    }

}
