import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 3, 4, 5, 1, 5, 4};
        System.out.print(Arrays.toString(array) + " -> " + numberIdenticalValues(List.of(array)));
        System.out.print(Arrays.toString(array) + " -> " + getStringMap(List.of(array)));
    }

    public static Map<Object, Integer> numberIdenticalValues(List<Object> list) {
        Map<Object, Integer> map = new HashMap<>();
        for (Object element : list) {
            Integer count = map.get(element);
            if (count == null) {
                map.put(element, 1);
            } else {
                map.put(element, count + 1);
            }
        }
        return map;
    }

    private static String getStringMap(List<Object> list) {
        Map<Object, Integer> map = numberIdenticalValues(list);
            List<Map.Entry<Object, Integer>> entries = new ArrayList<>(map.entrySet());
            String result = "";
            if (entries.size() > 0) {
                result = getEntryString(entries.get(0));
            }
        for (int i = 0; i < entries.size(); i++) {
            result += ", " + getEntryString(entries.get(i));
        }
        return "{" + result + "}";
    }

    private static String getEntryString(Map.Entry<Object, Integer> entry) {
        return entry.getKey() + " : " + entry.getValue();
    }
}