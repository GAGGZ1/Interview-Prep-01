class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(true){
            if(isBalance(num)){
                return num;
            }
            num++;
        }
    }
  public  boolean isBalance(int num){
        int freq[]=new int[10];
        int temp=num;
        while(temp>0)
        {
            int d=temp%10;
            freq[d]++;
            temp=temp/10;
        }

        for(int i=0;i<=9;i++){
           if(freq[i] != 0 && freq[i] != i)
                return false;
            
        }
        return true;
    }
}