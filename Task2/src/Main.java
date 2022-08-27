public class Main {
    public static void main(String[] args) {
        int[] a= {5,6,3,2,5,1,4,9};
        boolean isSort = false;
        int buffer;
        while(!isSort) {
            isSort = true;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    isSort = false;
                    buffer = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buffer;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }

    }
}