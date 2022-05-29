package arraylist;


public class Array_List {

    private Object[] Array_List;        //Stores Objects in an array

    private int NumOfElementsInArray;

    //Default Constructor for the array list with default value
    public Array_List() {
        this(10);                       //Sets the default size of the array to 10
    }

    //Alternative Constructor for the array list with user specified size
    public Array_List(int size) {

        if(size <= 0){
            System.out.println("The size of the array must be greater than 0!");
            return;
        }

        this.Array_List = new Object[size];
        this.NumOfElementsInArray = 0;
    }

    //Adds an object to the array
    public void add(Object obj) {

    }

    //Removes an object from the array
    public void remove(Object obj) {
        for(int i = 0; i < NumOfElementsInArray; i++) {
            if(obj.equals(this.Array_List[i])) {
                this.Array_List[i] = null;
                this.NumOfElementsInArray--;
                this.CopyArray(0);
                return;
            }
        }

    }

    public int find(Object obj) {

        for (int i = 0; i < this.Array_List.length; i++) {
            if(obj.equals(this.Array_List[i])) {
                return 1;
            }
        }

        return -1;
    }

    public int size(){
        return this.NumOfElementsInArray;
    }

    public boolean CheckIfFull() {
        return this.Array_List.length == this.NumOfElementsInArray;
    }

    private void CopyArray(int size){

        size = IncreaseArraySize(size);

        Object[] tmpArray = new Object[size];

        int tmpElem = 0;

        for(int i = 0; i < this.Array_List.length; i++, tmpElem++) {
            if(this.Array_List[i] == null){
                tmpElem--;
                continue;
            }

            tmpArray[tmpElem] = this.Array_List[i];
        }

        this.Array_List = null;
        this.Array_List = new Object[tmpArray.length];
        this.Array_List = tmpArray;
    }

    private int IncreaseArraySize(int size){
        size = this.Array_List.length + size;

        return size;
    }


}
