package 크레인_인형뽑기_게임;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/64061
// 배열써서 해결함. 밑에 코드는 다른사람 코드

public class Main {

	public static void main(String[] args) {
		
		int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[] = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
		
	} // end main()
	
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> nums = new ArrayList<Integer>();

        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i]-1] != 0){
                    nums.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        
        for(int k = 0; k < nums.size(); k++){
            if(k != (nums.size()-1)) {
                if(nums.get(k) == nums.get(k+1)) {
                    nums.remove(k);
                    nums.remove(k);
                    answer += 2;
                    k = -1;
                }
            }
        }

        return answer;
    }
	
} // end Main
