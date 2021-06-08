import java.util.Scanner;

class Underflow extends Exception{
    public Underflow(){
        super("Stack Underflow!");
    }
}
class Overflow extends Exception{
    public Overflow(){
        super("Stack Overflow!");
    }
}
class EmptyStack extends Exception{
    public EmptyStack(){ super("Stack is empty"); }
}

class Stack{
    int[] stackArray;
    int top;

    Stack(int size){
        stackArray = new int[size];
        top = -1;
    }

    void push(int x) throws Overflow{
        if (top == (stackArray.length - 1)){
            throw new Overflow();
        }
        stackArray[(top+1)] = x;
        top++;
    }

    int pop() throws Underflow{
        if (top == -1){
            throw new Underflow();
        }
        int poppedElement;
        poppedElement = stackArray[top];
        top--;
        return poppedElement;
    }

    void display() throws EmptyStack {
        if (top == -1){
            throw new EmptyStack();
        }
            System.out.print("The Stack is ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + "\t");
            }
            System.out.println();
    }

    void size(){
        System.out.println("The total elements in the Stack is " + (top+1));
        System.out.println("The size of the stack is " + stackArray.length);
    }
}

public class StackImplement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x;
        int choice;
        char repeat;
        int size;
        System.out.print("Enter the size of Stack [Default value: 5)]....");
        String sizeString = sc.nextLine();
        try {
            size = Integer.parseInt(sizeString);
        } catch (NumberFormatException e) {
            size = 5;
        }

        Stack stk = new Stack(size);

        do {
            System.out.println("Select any of these Options:");
            System.out.println("1. Push\n2. Pop\n3. Display Stack\n4. Display Stack Size\n");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1 -> {
                    try {
                        System.out.print("Enter the element you want to push: ");
                        x = sc.nextInt();
                        stk.push(x);
                    } catch (Overflow of) {
                        System.out.println(of.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.println(stk.pop() + " is popped from the Stack");
                    } catch (Underflow uf) {
                        System.out.println(uf.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        stk.display();
                    } catch (EmptyStack es) {
                        System.out.println(es.getMessage());
                    }
                }
                case 4 -> stk.size();
                default -> System.out.println("Wrong Choice!");
            }
            System.out.print("Do you want to return to main menu? Y/N: ");
            repeat = sc.next().charAt(0);
        }while (repeat == 'y' || repeat == 'Y');

    }
}
