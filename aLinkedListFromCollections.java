import java.util.*; //imports the util package which includes the scanner and linked list classes

/**
 * This class takes a list of integers and places them in a linked list in ascending order
 * using the LinkedList from java Collections Framework. 
 */
public class aLinkedListFromCollections {

    /**
     * This is the main method where objects are created, a scanner, linked list and an iterator, in order to 
     * sort a list of integers into a linked list in ascending order. 
     * @param args none 
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //creates a new scanner obj
        LinkedList<Integer> ll = new LinkedList<>(); //creates a linked list

        System.out.print("Enter the list of integers, using spaces for each entry: ");
        String intList = sc.nextLine();
        String[] arrList = intList.split(" "); //store list entry in an array to be added onto the linked list 
        if(arrList.length <= 1){
            System.out.print("Enter the list of integers greater than 1, using spaces for each entry: ");
            intList = sc.nextLine();
            arrList = intList.split(" "); //store list entry in an array to be added onto the linked list
        }
        for(int i = 0; i < arrList.length; i++){
            int element = Integer.parseInt(arrList[i]); //make each entry an integer 
            ll.add(element);
        }

        ListIterator<Integer> listIter = ll.listIterator(); //creates an iterator for the linked list
        int llElement = listIter.next();
        int sizeOfLinkedList = ll.size(); //determine the size of the linked list in order to know how to the stopping condition 
        int swapIndex;
        int iterNext;
        int i = 0; //this is the index to set elements into the linked list 
        Boolean check = true;
        while(check){//the implementation of the sorting algorithm is a Decrease and Conquer by a constant factor of 1
            if(sizeOfLinkedList != 0){
                if(listIter.hasNext()){
                    swapIndex = listIter.nextIndex(); //temp variable to make swap later 
                    iterNext = listIter.next(); 
                    if(llElement > iterNext){ //compare and set the elements in the linked list in ascending order 
                        ll.set(i, iterNext);
                        ll.set(swapIndex, llElement);
                    }
                    llElement = ll.get(i); //update the elelemt to be compared 
                }
                else{
                    listIter = ll.listIterator(); //reset the iterator
                    if(i < sizeOfLinkedList){
                        i++; //increase i because the previous i is guaranteed to be less than every element in the list 
                    }
                    //update the swap index and iterNext
                    for(int j = 0; j < i; j++){
                        swapIndex = listIter.nextIndex(); //update swap index depending on the remaining size of the problem 
                        iterNext = listIter.next(); //update the next iterator pointer depending on the size of the remaining problem 
                    } 
                    sizeOfLinkedList--; //decrease the size of the problem by 1
                    llElement = ll.get(i); //update the element to be compared 
                }
            }
            else{
                check = false; //this happens when the linked list has every element sorted from smallest to largest 
            }
        }
        //print the entire linked list 
        System.out.println(ll.toString());
    }
}
