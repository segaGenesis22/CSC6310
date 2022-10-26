import java.util.*; //imports the util package which includes the scanner and stack class

/**
 * This class takes a list of integers and places them in a stack in ascending order
 * using the stack class from java Collections Framework.
 * 
 * Previously, this class used to utilize a linked list instead of a stack. Due to using a stack as 
 * the data structure we will not be using an iterator as previously used with the linked list. This class
 * will now use the methods of a stack; push, pop, peek and search.
 */
public class sortedStack {
    /**
     * This is the main method where objects are created; a scanner and a stack in which the elements
     * will be sorted in ascending order. 
     * @param args none 
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //creates a new scanner obj
        Stack<Integer> stack = new Stack<Integer>(); //creates a new empty stack

        System.out.print("Enter the list of integers, using spaces for each entry: ");
        String intList = sc.nextLine();
        String[] arrList = intList.split(" "); //store list entry in an array to be added onto the stack 
        if(arrList.length <= 1){
            System.out.print("Enter the list of integers greater than 1, using spaces for each entry: ");
            intList = sc.nextLine();
            arrList = intList.split(" "); //store list entry in an array to be added onto the stack
        }
        for(int i = 0; i < arrList.length; i++){
            int element = Integer.parseInt(arrList[i]); //make each entry an integer 
            stack.push(element); //add to the stack
        }

        int i = 0; //front pointer counter
        int j = stack.size() - 1; //back pointer counter
        int temp; //for the swap
        Boolean unsorted = true;
        while(unsorted){//the implementation of the sorting algorithm is a Decrease and Conquer by a constant factor of 1
            if(stack.elementAt(i) > stack.elementAt(j)){ 
                //swap
                temp = stack.elementAt(i);
                stack.removeElementAt(i);
                stack.add(j, temp);
                temp = stack.elementAt(j - 1);
                stack.removeElementAt(j - 1);
                stack.add(i, temp);
            }
            i++;
            if(i == j || j == 0){
                if(j == 0){ //this happens when the stack has every element sorted from smallest to largest
                    unsorted = false; 
                    break;
                }
                else{
                    i = 0;
                    j--; //means last element is sorted so decrease the size of the problem by 1
                }
            }
        }
        //print the entire stack 
        System.out.println(stack.toString());
    }
    
}
