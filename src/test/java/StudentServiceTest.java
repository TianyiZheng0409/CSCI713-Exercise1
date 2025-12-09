import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    // Newly added tests below

    @Test
    void testGetTopStudentWithEmptyList() {
        StudentService service = new StudentService();

        Student top = service.getTopStudent();
        assertNull(top);
    }

    @Test
    void testGetTopStudentSingleElement() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        service.addStudent(s1);

        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testCalculateAverageGpaEmptyList() {
        StudentService service = new StudentService();
        double avg = service.calculateAverageGpa();

        // Expected: return 0.0
        assertEquals(0.0, avg, 0.001);
    }

    @Test
    void testRemoveStudentByName() {
        StudentService service = new StudentService();

        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);
        service.addStudent(s1);
        service.addStudent(s2);

        service.removeStudentByName("Bob");

        // After removal, top student should be Alice
        Student top = service.getTopStudent();
        assertEquals("Alice", top.getName());
    }

    @Test
    void testRemoveStudentByNameNotFound() {
        StudentService service = new StudentService();

        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.9));

        // Removing someone not in list should not affect average
        double beforeAvg = service.calculateAverageGpa();
        service.removeStudentByName("Charlie");
        double afterAvg = service.calculateAverageGpa();

        assertEquals(beforeAvg, afterAvg, 0.001);
    }
}
