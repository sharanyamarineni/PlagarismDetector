import java.io.*;
import java.util.*;
import java.lang.*;
public class bagofwords3 {
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

                String p[] = new String[100];
                String v[] = new String[100];
                double eu1, eu2;
                int dot;
                double percent;
                //here the object is created for the freq class
                freq f1= new freq();
                //splitting method is called to split the strings into words 
                v = f1.spliting(s1);
                p = f1.spliting(s2);
                //hashmap is created here

                HashMap<String, Integer> r = new HashMap<String, Integer>();
                HashMap<String, Integer> e = new HashMap<String, Integer>();
                //here the method mapht is called to count the frequencies of the words
                r = f1.mapht(v);
                e = f1.mapht(p);
                //here the method is called with respect to the object to  calculate the euclidian
               eu1 = f1.euclidian(r);
               eu2 = f1.euclidian(e);
               dot = f1.dotproduct(r, e);
               percent = f1.percentmatched(eu1, eu2, dot);
               System.out.printf("\t"+"%.2f",(percent * 100));
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

        }
class freq {
    String[] spliting(String s) {
        String x[] = new String[100];
        //here we are using split function to split according to the spaces
        x = s.split(" ");
        // System.out.println(a[2]);
        return x;
    }

    HashMap<String, Integer> mapht(String t[]) {
        HashMap<String, Integer> ht = new HashMap<String, Integer>();
        int i;
        String s;
        //int e=t.length();
        for (i = 0; i < t.length; i++) {
            s = t[i];
            if (ht.containsKey(s)) {
                //here it checks if the key is present in the hash map
                ht.put(s, ht.get(s) + 1);
                //if it is present then the count is increased

            } else {
                //if not present it gives the count as one
                ht.put(s, 1);
            }
        }
        return ht;
    }

    double euclidian(HashMap<String, Integer> r) {
        double s = 0;
        for (double i : r.values()) {
            //it iterates i in values and all the square of frequencies are added
           
            s = s + Math.pow(i, 2);
          
        }
        return Math.sqrt(s);
    }

    int dotproduct(HashMap<String, Integer> x, HashMap<String, Integer> y) {
        int m = 0;
        for (String i : x.keySet()) {
            //iterates keys in first hash map
            for (String j : y.keySet()) {
                //iterates values in second hash map
                if (i.equals(j)) {
                    //if the keys are equal then their frequencies are multiplied
                   
                    m = m + (x.get(i) * y.get(j));

                }
            }
        }
       
        return m;

    }

    double percentmatched(double eu1, double eu2, int dot) {
        //this method is used to calculate the total % matched
        double s = dot / (eu1 * eu2);
        return s;
    }
}





