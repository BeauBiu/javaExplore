package ToolsDemo;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int flag=1;
        while (flag == 1){
            String string=scanner.nextLine();
            System.out.println(string);
            System.out.println("这是标识符flag："+flag);
            flag--;
        }
    }
}
