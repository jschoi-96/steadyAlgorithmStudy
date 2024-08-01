package mission;

import java.util.*;
class 의상 {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], new ArrayList<>());
        }

        for (String[] cloth : clothes) {
            map.get(cloth[1]).add(cloth[0]);
        }

        List<String> list = new ArrayList<>(map.keySet());

        int res = 1;

        for (String key : list) {
            List<String> cloth = map.get(key);
            res *= (cloth.size() + 1); // 옷을 안입는 경우를 포함하여 + 1을 해줌
        }

        return res - 1;
    }
}
