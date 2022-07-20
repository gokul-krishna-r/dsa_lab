import java.util.Scanner;

class SparseMatrix{
    int a[][],s[][],t[][];
    int m,n;
    int count;

    public SparseMatrix(int x,int y){
        m=x;
        n=y;
        a=new int[m][n];
        count=0;
    }
    public void readMatrix(){
        Scanner scn=new Scanner(System.in);
        int k;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                k=scn.nextInt();
                if(k!=0){
                    count++;
                }
                a[i][j]=k;
            }
        }
        scn.close();
    }

    public void CreateSparse(){
        s=new int[count+1][3];
        s[0][0]=m;
        s[0][1]=n;
        s[0][2]=count;
        int k=1;
        System.out.println(count);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=0){
                    s[k][0]=i;
                    s[k][1]=j;
                    s[k][2]=a[i][j];
                    k++;
                }
    }
}
    }
    public void sparseTranspose(){
        t=new int[count+1][3];
        for(int i=0;i<=count;i++){
            for(int j=0;j<2;j++){
                t[i][j]=s[j][i];
            }
        }
    }
    public void printsparse(){
        
        for(int i=0;i<count+1;i++){
            for(int j=0;j<3;j++){
                System.out.print(s[i][j]+" ");
            }
            System.out.println("");

        }
    }
}

class test{
    public static void main(String args[]){
        SparseMatrix sp=new SparseMatrix(4, 3);
        sp.readMatrix();
        sp.CreateSparse();
        sp.printsparse();

    }
}
