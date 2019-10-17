public class Hanoi {
    public static void move(char pos1,char pos2){
        System.out.println(pos1 + "->" + pos2);
    }
    public static void hanoiTower(int n,char pos1,char pos2,char pos3){
        if(n == 1){
            move(pos1,pos3);
        }
        else{
            hanoiTower(n - 1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanoiTower(n - 1,pos2,pos1,pos3);
        }
    }
    public static void main(String[] args) {
        hanoiTower(4,'A','B','C');
    }
}
