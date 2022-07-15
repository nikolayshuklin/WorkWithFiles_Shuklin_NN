import java.io.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file1 = new File("C:\\Users\\Николай\\Documents\\Professional","1.txt"); //ПУТЬ К ФАЙЛУ 1
        File file2 = new File("C:\\Users\\Николай\\Documents\\Professional","2.txt"); //ПУТЬ К ФАЙЛУ 2
        // Создаем файлы
        boolean f1 = file1.createNewFile();
        boolean f2 = file2.createNewFile();
        // Строки для записи в файлы, по две в каждый
        String str1 = "В лесу родилась елочка!\n";
        String str2 = "В лесу она росла.\n";
        String str3 = "Зимой и летом стройная,\n";
        String str4 = "Зеленая была!!!\n";
        // Пишем строки в файлы
        FileWriter fileWriter1 = new FileWriter(file1,true);
        FileWriter fileWriter2 = new FileWriter(file2, true);
        fileWriter1.write(str3);
        fileWriter1.flush();
        fileWriter1.write(str4);
        fileWriter1.flush();
        fileWriter1.close();
        fileWriter2.write(str1);
        fileWriter2.flush();
        fileWriter2.write(str2);
        fileWriter2.flush();
        fileWriter2.close();
        // Читаем из первого файла строки, сцепляем с длиной строки и символом переноса строки. Пишем это во второй файл
        FileReader fileReader1 = new FileReader(file1);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        String line = bufferedReader1.readLine();
        int lengthLine;
        FileWriter fw = new FileWriter(file2, true);
        while (line != null) {
            lengthLine = line.length();
            line = line + lengthLine + "\n";
            fw.write(line);
            line = bufferedReader1.readLine();
        }
        // Закрываем потоки
        fw.close();
        fileReader1.close();
    }
}
