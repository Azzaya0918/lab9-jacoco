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
}