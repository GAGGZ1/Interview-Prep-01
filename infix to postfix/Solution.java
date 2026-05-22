import java.util.Stack;
public class Solution {
  static int precedence(char c){
    if(c=='^'){
      return 3;
    }
    else if(c=='*'|| c=='/'){
      return 2;
    }
    else if(c=='+' || c=='-'){
      return 1;
    }
    return -1;
  }

  static String infixToPostfix(String exp){
    StringBuilder sb=new StringBuilder();
    Stack<Character>st=new Stack<>();
    for(char c:exp.toCharArray()){

      // 1. operand
      if(Character.isLetterOrDigit(c)){
        sb.append(c);
      }

      // 2. '('
      else if(c=='('){
      st.push(c);}

      // 3. ')''
      else if(c==')'){
        while(!st.isEmpty() && st.peek()!='('){
          sb.append(st.pop());
        }
        st.pop();//remove '('
      }

      // 4. operator
      else{
        while(!st.isEmpty() && precedence(st.peek())>=(precedence(c))){
          sb.append(st.pop());
        }
        st.push(c);
      }
     
    }
     // 5. remaing operators
     while(!st.isEmpty()){
      sb.append((st.pop()));
     }
    return sb.toString();
  }
  public static void main(String args[]){
    String exp="(A+B)*C";
    System.out.print("Postfix= "+infixToPostfix(exp));
  }
}
