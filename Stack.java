package sr.unasat.A.D;

class Stack {

    int top;
    int Max = 10;
    int[] arr;

    public Stack() { // constructor
        arr = new int[Max];     // hoeveel elementen je array kan hebben.
        top = -1;   //wijst je dat je nog geen items hebt.
    }

    public void push(int val) {  //als je een item wilt zeggen in je stack
        arr[++top] = val;   //increment
    }

    public int pop() {
        return arr[top--];  //decrement
    }

    public int peek() {
        return arr[top];        //je kan zien wat boven is.
    }

    public boolean isEmpty() {
        return (top == -1);     //als er geen items meer zijn.
    }
}

