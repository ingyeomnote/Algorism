package Algorism.programmers.lv_1.memory_score;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 추억 점수
     * 
     * @param String[] name 매개변수는 그리워하는 사람의 이름을 담은 문자열 배열이다
     * @param int[] yearning 매개변수는 각 사람별 그리움 점수를 담은 정수 배열이다
     * @param String[][] photo 매개변수는 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열이다
     * @return 사진들의 추억 점수를 주어진 순서대로 배열에 담아 반환한다
     */
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<yearning.length; i++){
            map.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++){
            for(String person : photo[i]){
                if(map.get(person) != null)
                    answer[i] += map.get(person);
            }
        }

        return answer;
    }
}
