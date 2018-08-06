import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
public class Fp{
        public static void main(String args[])throws FileNotFoundException {
            //here the commandLine arguements are taken from the user
            File folder=new File(args[0]);
            int k=0;
            File [] listoffiles=folder.listFiles();
            File[] file_name=new File[listoffiles.length];
            for(int i=0; i<listoffiles.length;++i)
            {
                //here it counts the number of  text files present in the folder
                File file=listoffiles[i];
                if(file.getName().endsWith(".txt")){
                    file_name[k]=file;
                    k++;
                }
            }
            if(k==0){
                //if thers are no files then empty directory is printed
                System.out.println("empty directory");
            }
            System.out.printf("%10s"," ");
            for(int i=0;i<k;i++){
                //this for loop is used to print the file names in a row
                System.out.printf("%10s",file_name[i].getName());
            }
           System.out.println("\n");
            for(int i=0;i<k;i++){
                //this for loop is used to print the file names in a column

                System.out.printf("%10s",file_name[i].getName());
                for(int j=0;j<k;j++){
                    //here the file is opened and converts the upper case to lowercase if any, and stores to the s1 and s2
                    String s1=Fileopen(file_name[i]).toLowerCase();
                    String s2=Fileopen(file_name[j]).toLowerCase();
       // String s1;
       // String s2;
        int i1,j1=0,i2,j2=0,p1,p2;
       // s1="to be or not to be";
       // s2="doubt truth to  be a liar";
        double y1[]=new double[50];
        double y2[]=new double[50];
        char c1[]=new char[s1.length()];
        char c2[]=new char[s2.length()];
        Scanner s=new Scanner(System.in);
      //  System.out.println(s1);
      //  System.out.println(s2);
        String a1[]=new String[50];
        String a2[]=new String[50];
        char s3[]=new char[s1.length()];
        char s4[]=new char[s2.length()];
        s3=s1.toCharArray();
        s4=s2.toCharArray();
        for(i1=0;i1<s1.length();i1++){
            if (s3[i1]!=32){
                c1[j1]=s3[i1];
                j1=j1+1;
            }
        }
        for(i2=0;i2<s2.length();i2++){
            if (s4[i2]!=32){
                c2[j2]=s4[i2];
                j2=j2+1;
            }
        }

        //for(i=0;i<j;i++){
        //    System.out.println(c[i]);
        //}
        String t1=String.valueOf(c1);
        String t2=String.valueOf(c2);
        for(i1=0;i1<j1-3;i1++){
            a1[i1]=t1.substring(i1,i1+4);
        }
        for(i2=0;i2<j2-3;i2++){
            a2[i2]=t2.substring(i2,i2+4);
        }

        for(p1=0;p1<i1;p1++){
            double x1=hashvalue(a1[p1]);
            y1[p1]=x1;

        }
      // System.out.println(Arrays.toString(y1));
        for(p2=0;p2<i2;p2++){
            double x2=hashvalue(a2[p2]);
            y2[p2]=x2;
        }
     //  System.out.println(Arrays.toString(y2));
        double r=countofcommon(y1,y2,p1,p2);
      //  System.out.println("r value"+r);
      //  System.out.println("p1 value"+p1);
     //   System.out.println("p2 value"+p2);
        System.out.print("\t"+Math.round(((r*2)/((p1)+(p2)))*100));
                }
                System.out.println();
            }
        }
    public static String Fileopen(File f)throws FileNotFoundException
    {
        //this function is used to read the files
        String s=String.valueOf(f);
        int c=0;
        File file= new File(s);
        String s1="";

        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            s1+=sc.nextLine();
            s1=s1.replace("\n","");

            c=c+1;
        }
        //here the file is closed
        sc.close();
        //
        return s1;
    }




        public static double hashvalue(String s){
        char m[]=s.toCharArray();
        double sum=0.0;
            for(int i=0;i<4;i++){
               sum=sum+((double)m[i]*(Math.pow(10,4-(i-1))));
            }
            return sum%10007;
        }
        public static int countofcommon(double y1[],double y2[],int p1,int p2){
            int c=0;
            for(int i=0;i<p1;i++){
                for (int j=0;j<p2;j++){
                    if (y1[i]==y2[j]){
                        c=c+1;
                        break;
                    }
                }
            }
            return c;
        }
        }









