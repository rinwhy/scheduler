import com.solvd.scheduler.bin.Course;
import com.solvd.scheduler.bin.Subject;
import com.solvd.scheduler.bin.Teacher;

import java.time.LocalTime;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Teacher teacher = new Teacher(1,"Tom", List.of(Subject.ALGEBRA), 3, 45);

        Course course = new Course(Subject.ALGEBRA, LocalTime.of(9,0,0), LocalTime.of(10,0,0), teacher);

        System.out.println("start time "  + course.getStartTime()  );
        System.out.println("end time "  + course.getEndTime()  );


    }
}
