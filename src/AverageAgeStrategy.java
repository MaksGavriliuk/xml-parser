import java.util.List;

public class AverageAgeStrategy implements StatisticsStrategy {
    @Override
    public void calculateStatistics(List<Student> students) {
        int totalAge = 0;
        int studentCount = students.size();

        for (Student student : students) {
            totalAge += student.getAge();
        }

        double averageAge = (double) totalAge / studentCount;
        System.out.println("Средний возраст студентов: " + averageAge);
    }

}