package mission;

import java.util.*;
class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> mostPlays = new ArrayList<>(genreMap.keySet());

        Collections.sort(mostPlays, (a,b) -> genreMap.get(b) - genreMap.get(a));
//        Collections.sort(mostPlays, Collections.reverseOrder());
        List<Integer> res = new ArrayList<>();

        for(String play : mostPlays) { // 100 * 10000
            Map<Integer, Integer> playMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (play.equals(genres[i])) {
                    playMap.put(i, plays[i]); // i: 고유 번호, plays[i]: 재생 시간
                }
            }

            List<Integer> index = new ArrayList<>(playMap.keySet()); // 4,1,3,0...

            Collections.sort(index, (a,b) -> playMap.get(b) - playMap.get(a));

            res.add(index.get(0));
            if (index.size() > 1) res.add(index.get(1));
        }

        int [] arr_res = new int[res.size()];
        for(int i = 0; i < res.size(); i++) arr_res[i] = res.get(i);
        return arr_res;
    }
}
