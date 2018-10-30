import java.io.File;
import java.io.IOException;

public class makeDir {
    public static void main(String[] args) throws IOException {
        //循环创建文件夹
        for (int j = 101; j <= 110; j++) {
            String filename = "/home/jion1/contract/contract" + j;
            System.out.println(filename);
            File file = new File(filename);
            if (!file.exists()) {
                try {
                    file.mkdir();
                    System.out.println("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
