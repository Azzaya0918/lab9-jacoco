package mn.edu.must.sqat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private ScholarshipCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new ScholarshipCalculator();
    }

    @Test
    void letterGradeA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGradeB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void gpaTwoGrades() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9);
    }

    @Test
    void scholarshipFull100() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipHalf50() {
        assertEquals(50, calc.scholarship(3.1, 10, false));
    }

    // ===== Хэсэг B: branch 100% =====

    @Test
    void letterGradeC() { assertEquals("C", calc.letterGrade(75)); }

    @Test
    void letterGradeD() { assertEquals("D", calc.letterGrade(65)); }

    @Test
    void letterGradeF() { assertEquals("F", calc.letterGrade(30)); }

    @Test
    void letterGradeNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGradeOver100Throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    void gpaAllGradeLetters() {
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 30}), 1e-9);
    }

    @Test
    void gpaNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpaEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void scholarshipNegativeGpaThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 10, false));
    }

    @Test
    void scholarshipGpaAboveFourThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
    }

    @Test
    void scholarshipNegativeCreditsThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    void scholarshipViolationGivesZero() { assertEquals(0, calc.scholarship(3.9, 16, true)); }

    @Test
    void scholarship70() { assertEquals(70, calc.scholarship(3.9, 14, false)); }

    @Test
    void scholarshipHighGpaLowCreditsFallsTo50() { assertEquals(50, calc.scholarship(3.9, 10, false)); }

    @Test
    void scholarshipMidGpaLowCreditsFallsTo50() { assertEquals(50, calc.scholarship(3.5, 11, false)); }

    @Test
    void scholarshipGpaBelow34Is50() { assertEquals(50, calc.scholarship(3.2, 20, false)); }

    @Test
    void scholarshipLowGpaIsZero() { assertEquals(0, calc.scholarship(2.5, 20, false)); }

    // ===== Хэсэг C: давталтын зааг (0 / 1 / 2+) =====
    // 0 удаа: gpaEmptyThrows, gpaNullThrows (Хэсэг B-д бичсэн)

    @Test
    void gpaSingleGrade() {
        assertEquals(4.0, calc.gpa(new double[]{95}), 1e-9);
    }

    @Test
    void gpaManyGrades() {
        assertEquals(2.5, calc.gpa(new double[]{95, 85, 75, 65}), 1e-9);
    }

    // ===== Хэсэг D: letterGrade-ийн зааг утгууд =====

    @Test
    void boundary0IsF() { assertEquals("F", calc.letterGrade(0)); }

    @Test
    void boundary59_99IsF() { assertEquals("F", calc.letterGrade(59.99)); }

    @Test
    void boundary60IsD() { assertEquals("D", calc.letterGrade(60)); }

    @Test
    void boundary69_99IsD() { assertEquals("D", calc.letterGrade(69.99)); }

    @Test
    void boundary70IsC() { assertEquals("C", calc.letterGrade(70)); }

    @Test
    void boundary79_99IsC() { assertEquals("C", calc.letterGrade(79.99)); }

    @Test
    void boundary80IsB() { assertEquals("B", calc.letterGrade(80)); }

    @Test
    void boundary89_99IsB() { assertEquals("B", calc.letterGrade(89.99)); }

    @Test
    void boundary90IsA() { assertEquals("A", calc.letterGrade(90)); }

    @Test
    void boundary100IsA() { assertEquals("A", calc.letterGrade(100)); }
}
