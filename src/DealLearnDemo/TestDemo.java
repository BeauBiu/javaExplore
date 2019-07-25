package DealLearnDemo;

import java.io.*;
/*测试序列化及反序列化方法*/
public class TestDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user=new User();
        user.setUsername("刘斌");
        user.setPassword("Simple0119");
        user.setIdcard("360731199812037673");
        user.setBirthday(19981203);
        user.setAddress("江西省赣州时于都县梓山镇");
        System.out.println(user.toString());
        /*序列化处理*/
        /*try {
            ObjectOutputStream filebyte01=new ObjectOutputStream(new FileOutputStream("temp"));
            filebyte01.writeObject(user);
            filebyte01.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*反序列化处理*/
        File file=new File("temp");
        ObjectInputStream osi=new ObjectInputStream(new FileInputStream(file));
        User user01=(User)osi.readObject();
        System.out.println(user01.toString());
    }
}
