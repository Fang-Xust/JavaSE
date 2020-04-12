public class day12Main {
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
    public String[] getGray(int n) {
        if(n == 1){
            return new String[]{"0", "1"};
        }else{
            String[] tmp = getGray(n - 1);
            String[] ret = new String[tmp.length * 2];
            for(int i = 0; i < tmp.length; i++){
                ret[i] = "0" + tmp[i];
            }
            int i, j;
            for(i = 0, j = tmp.length - 1; i < tmp.length && j >= 0; i++, j--){
                ret[i + tmp.length] = "1" + tmp[j];
            }
            return ret;
        }
    }
}
