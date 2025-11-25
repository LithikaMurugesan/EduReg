import java.util.HashMap;
import java.util.Map;

public class GradeCard {
    private Student student;
    private Map<Course,String> grades;

    public  GradeCard(Student student){
        this.student=student;
        this.grades = new HashMap<>();
    }
    public void addGrade(Course course,String grade){
        grades.put(course,grade);
    }
    public Map<Course,String>viewGrades(){
        return  grades;
    }

}
