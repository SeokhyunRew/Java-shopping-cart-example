package CheckBracket;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        System.out.print("괄호'(',')'가 올바른지 검사할 구문을 입력하시오 :");
        String inputStirng = sc.nextLine();
        boolean result = true;

        for (char i: inputStirng.toCharArray()) {
            if(i=='('){
                stack.push(i);
            }
            if(i==')'){
                try{
                    stack.pop();
                }catch(EmptyStackException e){
                    result = false;
                    System.out.println(result);
                    System.out.println("')'가 나오기 전에 '('가 먼저 나와야 합니다.");
                };
            }
        }
        if(result == true){
            if(!stack.isEmpty()){
                result = false;
                System.out.println(result);
                System.out.println(")의 개수가 부족합니다");
            }else{
                System.out.println(result);
                System.out.println("괄호의 개수와 순서가 올바릅니다");
            }
        }
    }
}
