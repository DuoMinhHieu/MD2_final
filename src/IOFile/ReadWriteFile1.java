package IOFile;

import controller.StudentProduct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile1 implements ReadWriteFile {
    public static final String PATHNAME_STUDENT = "src/data/data.csv";

    public void writeFile(List<StudentProduct> students){
        File fileStudent = new File(PATHNAME_STUDENT);
        try {
            OutputStream opsStudent = new FileOutputStream(fileStudent);
            ObjectOutputStream oosStudent =  new ObjectOutputStream(opsStudent);
            oosStudent.writeObject(students);
            oosStudent.close();
            opsStudent.close();
            oosStudent.writeObject(students);
        } catch (IOException e) {
            System.out.println("Saved");
        }
    }

    public List<StudentProduct> readFile(){
        File file = new File(PATHNAME_STUDENT);
        if (!file.exists()) {
            return getStudent();
        }
        try {
            InputStream isStudent = new FileInputStream(file);
            ObjectInputStream oisStudent = new ObjectInputStream(isStudent);
            Object object = oisStudent.readObject();
            return (List<StudentProduct>) object;
        } catch (FileNotFoundException e) {
            System.out.println("Xay ra loi" + e.getMessage());
            return getStudent();
        } catch (IOException e) {
            System.out.println("Xay ra loi" + e.getMessage());
            return getStudent();
        } catch (ClassNotFoundException e) {
            System.out.println("Xay ra loi" + e.getMessage());
            return getStudent();
        }
    }
    public List<StudentProduct> getStudent(){
        List<StudentProduct> listStudent = new ArrayList<>();
        writeFile(listStudent);
        return listStudent;
    }
}
