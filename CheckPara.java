import java.util.Scanner;

class CheckPara {
    int top = -1;
    int x;
    char[] arr;

    public CheckPara(int x) {
        this.x = x;
        this.arr = new char[x];
    }

    public boolean isFull() {
        if (top == (x - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(char n) {
        if (isFull() == true) {
            System.out.println("Stack is overflowing");
        } else {
            top++;
            arr[top] = n;
        }
    }

    public char pop() {
        if (isEmpty() == true) {
            return 0;
        } else {
            char temp_var = arr[top];
            top--;
            return temp_var;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        System.out.println("Enter the Brackets Sequence for paranthesis checking");
        String para_chek = sc.nextLine();
        CheckPara cp = new CheckPara(para_chek.length());

        if (para_chek.length() % 2 != 0) {
            System.out.println(para_chek + " is not balanced");
        } else {
            for (int i = 0; i < para_chek.length()/2; i++) {
                cp.push(para_chek.charAt(i));
            }

            for (int i = para_chek.length() / 2; i < para_chek.length(); i++) {
                char temp = cp.pop();
                 if(para_chek.charAt(i) == ')' && temp == '(') {
                  count++;
                 } 
                 else if (para_chek.charAt(i) == ']' && temp == '[') {
                  count++;
                 } 
                 else if (para_chek.charAt(i) == '}' && temp == '{') {
                  count++;
                 } 
                 else {
                  count--;
                 }
                 

            }
        }

        
         if (count == para_chek.length() / 2) {
          System.out.println(para_chek + " is balanced");
         }
         else {
          System.out.println(para_chek + " is not balanced");
         }

    }
}