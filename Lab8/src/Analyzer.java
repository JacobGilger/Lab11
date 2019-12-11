public class Analyzer {
    public static void main(String[] args) {
        linSearch("not_here");
        binSearch("not_here");
        linSearch("mzzzz");
        binSearch("mzzzz");
        linSearch("aaaaa");
        binSearch("aaaaa");
    }
    public static int linearSearch(String[] dataSet, String element) {
        for(int i=0;i<dataSet.length;i++) {
            if(dataSet[i].equals(element))
                return i;
        }
        return -1;
    }
    public static int binarySearch(String[] dataSet, String element) {
        int start=0;
        int end=dataSet.length-1;
        while(start<=end) { //run halves until find
            int mid=start+(end-start)/2;
            int compare=element.compareTo(dataSet[mid]);
            if(compare==0)
                return mid;
            if(compare>0) //ignore left half
                start=mid+1;
            else //ignore right half
                end=mid-1;
        }
        return -1;
    }
    public static int linSearch(String element) {
        long beginning=System.nanoTime();
        int index=linearSearch(StringData.getData(),element);
        long ending=System.nanoTime();
        ending=ending-beginning;
        System.out.println("The index of '"+element+"' is "+index+". It took "+ending+" nanoseconds to execute using linear search.");
        return index;
    }
    public static int binSearch(String element) {
        long beginning=System.nanoTime();
        int index=binarySearch(StringData.getData(),element);
        long ending=System.nanoTime();
        ending=ending-beginning;
        System.out.println("The index of '"+element+"' is "+index+". It took "+ending+" nanoseconds to execute using binary search.");
        return index;
    }
}
