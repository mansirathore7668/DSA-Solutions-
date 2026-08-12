class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stack=new Stack<>();
        for(char digit:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder result= new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();
        int index=0;
        while(index<result.length()-1 && result.charAt(index)=='0'){
            index++;
        }
        result = new StringBuilder(result.substring(index));
        return result.length()==0?"0":result.toString();
    }
}