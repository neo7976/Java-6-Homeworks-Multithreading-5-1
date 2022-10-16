import java.util.ArrayList;
import java.util.List;
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

    public String findByNumber(String number) {
       return phone.entrySet().stream().filter((x) -> x.getValue().equals(number)).map(Map.Entry::getKey).findFirst().get();
    }

    public String findByName(String name) {
       return phone.get(name);
    }


    public List<String> printAllNames() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : phone.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }
}
