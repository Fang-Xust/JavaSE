import java.util.Scanner;
public class day25Main{
    public static double getScorePoint(int score){
        if(score >= 90 && score <= 100){
            return 4.0;
        }else if(score >= 85 && score <=89){
            return 3.7;
        }else if(score >= 82 && score <= 84){
            return 3.3;
        }else if(score >= 78 && score <= 81){
            return 3.0;
        }else if(score >= 75 && score <= 77){
            return 2.7;
        }else if(score >= 72 && score <= 74){
            return 2.3;
        }else if(score >= 68 && score <= 71){
            return 2.0;
        }else if(score >= 64 && score <= 67){
            return 1.5;
        }else if(score >= 60 && score <= 63){
            return 1.0;
        }else{
            return 0.0;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
                count += arr[i];
            }
            double countGPA = 0;
            double scorePoint = 0;
            for(int i = 0; i < arr.length; i++){
                int score = sc.nextInt();
                scorePoint = getScorePoint(score) * arr[i];
                countGPA += scorePoint;
            }
            double GPA = countGPA / count;
            System.out.printf("%.2f", GPA);
        }
    }
}