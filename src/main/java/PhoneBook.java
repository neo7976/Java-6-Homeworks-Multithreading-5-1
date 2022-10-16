import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    Map<String, String> phone = new TreeMap<>();

    public int add(String name, String number) {
        if (!phone.containsKey(name)) {
            phone.put(name, number);
        }
        return phone.size();
    }
}
