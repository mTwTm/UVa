import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtwtm on 2016/3/21.
 */
public class Helper {
    private class Combination {
        private int[] chosen;
        private int size;
        Combination(int n, int r) {
            chosen = new int[r];
            size = n;
            for(int i=0 ; i<r ; i++) {
                chosen[i] = i;
            }
        }

        public int[] get() {
            return chosen;
        }

        public void next() {
            for(int i=chosen.length-1 ; i>=0 ; i--) {
                if(chosen[i]!=size-(chosen.length-i)) {
                    chosen[i]++;
                    for(int j=i+1 ; j<chosen.length ; j++) {
                        chosen[j] = chosen[j-1]+1;
                    }
                    break;
                }
            }
        }

        public boolean hasNext() {
            for(int i=chosen.length-1 ; i>=0 ; i--) {
                if(chosen[i]!=size-(chosen.length-i)) {
                    return true;
                }
            }
            return false;
        }
    }
    private class Permutation {
        private List<Integer> list;
        private boolean isIncrease;
        Permutation(int size, boolean isIncrease) {
            this.isIncrease = isIncrease;
            list = new ArrayList<>();
            int start = isIncrease ? 0 : size-1;
            int end = isIncrease ? size : -1;
            int increment = isIncrease ? 1 : -1;
            for(int i = start ; i != end ; i+=increment) {
                list.add(i);
            }
        }
        private int swapIndex(int comparingIndex) {
            int index = list.size()-1;
            boolean isSorted = isIncrease ? list.get(index) <= list.get(comparingIndex) : list.get(index) >= list.get(comparingIndex);
            while(isSorted) {
                index--;
                isSorted = isIncrease ? list.get(index) <= list.get(comparingIndex) : list.get(index) >= list.get(comparingIndex);
            }
            return index;
        }
        private int sortedCount() {
            int count = 1;
            boolean isSorted = isIncrease ? list.get(list.size()-1-count+1) <= list.get(list.size()-1-count) : list.get(list.size()-1-count+1) >= list.get(list.size()-1-count);
            while(isSorted) {
                count++;
                if(list.size()-1-count==-1) {
                    break;
                }
                isSorted = isIncrease ? list.get(list.size()-1-count+1) <= list.get(list.size()-1-count) : list.get(list.size()-1-count+1) >= list.get(list.size()-1-count);
            }
            return count;
        }
        public List<Integer> getNext() {
            int count = sortedCount();
            if(count==list.size()) {
                return null;
            } else {
                swap(list.size()-1-count, swapIndex(list.size()-1-count));
                if(count!=1) {
                    reverse(list.size()-count, list.size()-1);
                }
            }
            return getCurrent();
        }
        public void swap(int aIndex, int bIndex) {
            int temp = list.get(aIndex);
            list.set(aIndex, list.get(bIndex));
            list.set(bIndex, temp);
        }
        public void reverse(int aIndex, int bIndex) {
            int mid = (bIndex - aIndex + 1) / 2;
            for(int diff=0 ; diff<mid ; diff++) {
                swap(aIndex + diff , bIndex - diff);
            }
        }
        public List<Integer> getCurrent() {
            return list;
        }
    }
}
