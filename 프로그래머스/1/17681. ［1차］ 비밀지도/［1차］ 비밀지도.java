class Solution {
    public String toResult(int value, int n) {
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < n; i++) {
        sb.append(" ");
    }
    
    int idx = n - 1;
    while (value > 0 && idx >= 0) {
        if (value % 2 == 1) {
            sb.setCharAt(idx, '#');
        }
        value /= 2;
        idx--;
    }
    
    return sb.toString();
}
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0;i<arr1.length;i++){
            int result = arr1[i]|arr2[i];
            answer[i]=toResult(result,n);
        }
        return answer;
    }
}

//비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
//숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
//1과 2를 겹쳐서 얻을 수 있다
//정수 배열로 암호화되어 있다.
