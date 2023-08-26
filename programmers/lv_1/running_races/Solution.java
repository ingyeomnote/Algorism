package Algorism.programmers.lv_1;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
    * 달리기 경주
    *
    * @param String[] players 매개변수는 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열이다.
    * @param String[] callilngs 매개변수는 해설진이 부른 이름을 담은 문자열 배열이다.
    * @return 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 정렬한 배열을 반환한다.
    */
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        /*
         * Map<String, Integer> playerRank 변수는 선수들의 순위를 반환한다.
         * Map<Integer, String> playerName 변수는 선수들의 이름을 반환한다.
         */
        Map<String, Integer> playerRank = new HashMap<String, Integer>();
        Map<Integer, String> playerName = new HashMap<Integer, String>();
        
        for(int i=0; i<players.length; i++){
            playerRank.put(players[i], i);
            playerName.put(i, players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            /* 
            * int currentRank 변수는 해설진이 부른 선수의 현재 순위를 저장한다.
            * String currentPlayer 변수는 현재 해설진이 부르고 있는 선수의 이름을 저장한다.
            * String highPlayer 변수는 currentPlayer 보다 순위가 한 단계 높은 선수의 이름을 저장한다.
            */ 
            
            int currentRank = playerRank.get(callings[i]);
            String currentPlayer = callings[i];
            String highPlayer = playerName.get(currentRank - 1);
            
            playerRank.put(currentPlayer, currentRank - 1);
            playerRank.put(highPlayer, currentRank);
            
            playerName.put(currentRank -1, currentPlayer);
            playerName.put(currentRank, highPlayer);
        }      
        
        for(int i=0; i<players.length; i++){
            answer[i] = playerName.get(i);
        }
        
        return answer;
    }
}