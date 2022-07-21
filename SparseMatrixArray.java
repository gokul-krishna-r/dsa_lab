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
        t[0][0]=s[0][1];
        t[0][1]=s[0][0];
        t[0][2]=s[0][2];
        int k=1;
        for(int i=0;i<=s[0][1];i++){
            for(int j=1;j<=s[0][2];j++){
                if(s[j][1]==i){
                    t[k][0]=s[j][1];
                    t[k][1]=s[j][0];
                    t[k][2]=s[j][2];
                    k++;
                }
            }
        }
    }
    public void printsparse(){
        System.out.println("-----------");
        for(int i=0;i<count+1;i++){
            for(int j=0;j<3;j++){
                System.out.print(s[i][j]+" ");
            }
            System.out.println("");

        }
    }
    public void printTranspose(){
        System.out.println("-----------");

        for(int i=0;i<t[0][2]+1;i++){
            for(int j=0;j<3;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println("");

        }
    }
}

class SparseMatrixArray{
    public static void main(String args[]){
        SparseMatrix sp=new SparseMatrix(4, 3);
        sp.readMatrix();
        sp.CreateSparse();
        sp.printsparse();
        sp.sparseTranspose();
        sp.printTranspose();

    }
}
