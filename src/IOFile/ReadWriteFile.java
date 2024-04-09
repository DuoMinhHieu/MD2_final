package IOFile;
import controller.StudentProduct;

import java.util.List;

public interface ReadWriteFile {
    List<StudentProduct> readFile();
    void writeFile(List<StudentProduct> studentList);
}