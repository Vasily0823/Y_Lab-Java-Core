public class Main {
    public static void main(String[] args) {
        int MAX_VALUE=10;
        int[][] a =new int[10][10];

        if(MAX_VALUE>0) {
            int min = MAX_VALUE;
            int max = 0;
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = (int) (Math.random() * MAX_VALUE);
                    if (a[i][j] < min) min = a[i][j];
                    if (a[i][j] > max) max = a[i][j];
                    sum += a[i][j];
                }
            }
            System.out.println("Maximum value: " + max);
            System.out.println("Minimum value: " + min);
            System.out.println("Average value:" + sum / (a.length * a.length));
        }
    }
}
