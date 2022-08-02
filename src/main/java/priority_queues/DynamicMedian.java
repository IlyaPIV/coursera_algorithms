package priority_queues;

import java.util.*;

public class DynamicMedian {

    private static class Structure{

       private final ArrayList<Integer> left = new ArrayList<>();
       private final ArrayList<Integer> right = new ArrayList<>();

       private int mediane = 0;

       private void moveLeftToRight(){
           right.add(0, left.get(left.size()-1));
           left.remove(left.size()-1);
       }

       private void moveRightToLeft(){
           left.add(right.get(0));
           right.remove(0);
       }

       public int returnMIN(){
           if (left.size()==0) return Integer.MIN_VALUE;
           return left.get(0);
       }

       public int returnMAX(){
           if (right.size()==0) {
               if (left.size()==0) return Integer.MAX_VALUE;
                else return left.get(left.size()-1);
           }

           return right.get(right.size()-1);
       }

       public void addValue(int val) {
           if (right.size()==0) {
               right.add(val);
              // Collections.sort(left);
           } else {

               if (val <= right.get(0)) {
                   //addToLeft
//                   if (left.size() > right.size()) moveLeftToRight();
                   left.add(val);
                   Collections.sort(left);
                   if ((left.size() - right.size())==2) moveLeftToRight();
               } else {
                   //addToRight
                  // if (right.size() > left.size()) moveRightToLeft();
                   right.add(val);
                   Collections.sort(right);
                   if ((right.size() - left.size())==2) moveRightToLeft();
               }
           }

           calculateMediane();
          // mediane = (left.get(left.size()-1) + right.size()==0 ? 0 : right.get(0)) / 2;
       }

       private void calculateMediane(){
           if (left.size()==0) {
               mediane = right.get(0);
           } else {
              mediane = (left.get(left.size()-1)+right.get(0)+1) / 2;
           }

       }

        @Override
        public String toString() {
            return left.toString() + " | " + mediane + " | " + right.toString();
        }
    }

    public static void main(String[] args) {
        Structure structure = new Structure();
        structure.addValue(3);
        structure.addValue(10);
        structure.addValue(2);
        structure.addValue(5);
        structure.addValue(3);
        structure.addValue(7);
        System.out.println(structure);
    }

}
