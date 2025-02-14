package Knights_Path.Data_Structures;
import java.util.Arrays;
import java.util.Iterator;

public class Dynamic_Array <T> implements Iterable <T>{

   private T [] arr ;
   private int len =0;
   private int  capacity =0; 

   public Dynamic_Array() { 
      this(10); // well call the paramter constractore
   }

   @SuppressWarnings("unchecked")
   public Dynamic_Array(int capacity) {
      if (capacity < 0) {
         throw new IllegalArgumentException("illegeal capacity" + capacity);
      }
      this.capacity = capacity;
      this.arr  = (T[]) new Object [this.capacity];
   }

   @Override
   public Iterator<T> iterator() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'iterator'");
   }

   public int size() {
      return this.len;
   }
   

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public T get(int indx) {
      return this.arr[indx];
   }

   public void set(T el, int indx) {
      if (indx < 0 || indx > this.len ) 
         throw new IllegalArgumentException("illegeal index ----> " + indx);
      this.arr[indx] = el;
   }
   
   public void clear() {
      for (T t : this.arr) {
         t = null;
      }
      this.len = 0;
   }

   public void add(T el) {
      if (this.len == this.capacity) {
         this.recize();
         } 
         this.arr[this.len++] = el;
   }

   private void recize() {
      int newCapacity = this.capacity << 1;
      this.arr = Arrays.copyOf(arr, newCapacity);
   }


   public T removeAt(int indx) {
      if (indx >= len || indx < 0)
         throw new IllegalArgumentException("Invalid index");

      T element = arr[indx];
      T[] newArr = (T[]) new Object[len - 1];

      for (int i = 0, j = 0; i < len; i++) {
         if (i == indx)
            continue;
         newArr[j++] = arr[i];
      }

      arr = newArr;
      len--;

      return element;
   }
   
   public boolean remove(T el) {
      int index = -1;
      for (T element : this.arr) {
         index++;
         if (el.equals(element)) {
            this.removeAt(index);
            return true;
         }
      }
      return false;
   }
   

   public void printArray() {
      System.out.print("[ ");
      for (int i = 0; i < this.len; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println("]");
   }

   public static void main(String[] args) {
      Dynamic_Array<Integer> dArray = new Dynamic_Array<>(2);
      dArray.add(234);
      dArray.add(65);
      dArray.add(898);

      // dArray.removeAt(0);
      // dArray.removeAt(1);

      dArray.remove(234);

      dArray.printArray();
   }

}
