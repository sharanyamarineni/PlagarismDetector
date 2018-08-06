import java.util.*;
import java.lang.*;
class lcs{
    public static void main(String args[]){
        String s1="my name is xyz";
        String s2="my name is xyz";
        int i;
        int j;
        int k=0;
        int temp=0;
        //int arr[]=new int[50];
        System.out.println(s1.charAt(2));
        for(i=0;i<s1.length();i++){
            int res[]=new int[50];
            for(j=0;j<s2.length();j++){
                char x=s1.charAt(i);
                char y=s2.charAt(j);
                if(x==y){
                    res[k]=j;
                    k=k+1;
                }
                //System.out.println(Arrays.toString(arr));

            }
            for(int u=0;u<k;u++){
                char l[]=new char[50];
                int p=0;
                int v=0;
                int z=res[u];
                while((i+p<s1.length()&&(z+p<s2.length())&&(s1.charAt(i+p)==s2.charAt(z+p)))){
                    l[v]=s2.charAt(z+p);
                    v=v+1;
                    p=p+1;
                }
                if(v>=temp){
                    temp=v;
                }
            }


        }
        int r=temp;
        //System.out.println(r);
        float e=(s1.length()+s2.length());
        float q=(r*2/e)*100;
        System.out.println(q);

        //System.out.println(Arrays.toString(arr));

    }
}