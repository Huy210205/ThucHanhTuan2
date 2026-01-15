import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lớp kiểm thử cho StudentAnalyzer
 */
public class StudentAnalyzerTest {
    
    private StudentAnalyzer analyzer;
    
    @BeforeEach
    public void setUp() {
        analyzer = new StudentAnalyzer();
    }
    
    // ========== TEST CHO countExcellentStudents() ==========
    
    /**
     * Test trường hợp bình thường: danh sách có nhiều điểm hợp lệ và không hợp lệ
     */
    @Test
    public void testCountExcellentStudents_MixedValidAndInvalid() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), 
            "Phải đếm được 2 học sinh giỏi (9.0 và 8.5), bỏ qua điểm không hợp lệ");
    }
    
    /**
     * Test trường hợp bình thường: danh sách toàn bộ hợp lệ
     */
    @Test
    public void testCountExcellentStudents_AllValid() {
        List<Double> scores = Arrays.asList(9.5, 8.0, 7.5, 8.8, 6.0);
        assertEquals(3, analyzer.countExcellentStudents(scores),
            "Phải đếm được 3 học sinh giỏi (9.5, 8.0, 8.8)");
    }
    
    /**
     * Test trường hợp biên: danh sách trống
     */
    @Test
    public void testCountExcellentStudents_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()),
            "Danh sách trống phải trả về 0");
    }
    
    /**
     * Test trường hợp biên: danh sách null
     */
    @Test
    public void testCountExcellentStudents_NullList() {
        assertEquals(0, analyzer.countExcellentStudents(null),
            "Danh sách null phải trả về 0");
    }
    
    /**
     * Test trường hợp biên: điểm 0 và 10
     */
    @Test
    public void testCountExcellentStudents_BoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0, 8.0);
        assertEquals(2, analyzer.countExcellentStudents(scores),
            "Điểm 10.0 và 8.0 là học sinh giỏi, điểm 0.0 không phải");
    }
    
    /**
     * Test trường hợp ngoại lệ: điểm âm
     */
    @Test
    public void testCountExcellentStudents_NegativeScores() {
        List<Double> scores = Arrays.asList(-5.0, 9.0, -2.0, 8.5);
        assertEquals(2, analyzer.countExcellentStudents(scores),
            "Phải bỏ qua điểm âm, chỉ đếm 9.0 và 8.5");
    }
    
    /**
     * Test trường hợp ngoại lệ: điểm > 10
     */
    @Test
    public void testCountExcellentStudents_ScoresAboveTen() {
        List<Double> scores = Arrays.asList(11.0, 9.0, 15.0, 8.5, 12.5);
        assertEquals(2, analyzer.countExcellentStudents(scores),
            "Phải bỏ qua điểm > 10, chỉ đếm 9.0 và 8.5");
    }
    
    /**
     * Test trường hợp không có học sinh giỏi
     */
    @Test
    public void testCountExcellentStudents_NoExcellent() {
        List<Double> scores = Arrays.asList(5.0, 6.5, 7.0, 7.9);
        assertEquals(0, analyzer.countExcellentStudents(scores),
            "Không có học sinh nào đạt loại giỏi");
    }
    
    /**
     * Test trường hợp tất cả là học sinh giỏi
     */
    @Test
    public void testCountExcellentStudents_AllExcellent() {
        List<Double> scores = Arrays.asList(8.0, 8.5, 9.0, 9.5, 10.0);
        assertEquals(5, analyzer.countExcellentStudents(scores),
            "Tất cả 5 học sinh đều đạt loại giỏi");
    }
    
    /**
     * Test trường hợp điểm đúng bằng 8.0 (điểm biên)
     */
    @Test
    public void testCountExcellentStudents_ExactlyEight() {
        List<Double> scores = Arrays.asList(7.9, 8.0, 8.1);
        assertEquals(2, analyzer.countExcellentStudents(scores),
            "Điểm 8.0 và 8.1 là giỏi, 7.9 không phải");
    }
    
    // ========== TEST CHO calculateValidAverage() ==========
    
    /**
     * Test trường hợp bình thường: danh sách có điểm hợp lệ và không hợp lệ
     */
    @Test
    public void testCalculateValidAverage_MixedValidAndInvalid() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01,
            "Trung bình của 9.0, 8.5, 7.0 là 8.166...");
    }
    
    /**
     * Test trường hợp bình thường: danh sách toàn bộ hợp lệ
     */
    @Test
    public void testCalculateValidAverage_AllValid() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 7.0, 6.0);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.01,
            "Trung bình của 8.0, 9.0, 7.0, 6.0 là 7.5");
    }
    
    /**
     * Test trường hợp biên: danh sách trống
     */
    @Test
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01,
            "Danh sách trống phải trả về 0.0");
    }
    
    /**
     * Test trường hợp biên: danh sách null
     */
    @Test
    public void testCalculateValidAverage_NullList() {
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01,
            "Danh sách null phải trả về 0.0");
    }
    
    /**
     * Test trường hợp biên: chỉ có điểm 0
     */
    @Test
    public void testCalculateValidAverage_OnlyZero() {
        List<Double> scores = Arrays.asList(0.0, 0.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01,
            "Trung bình của các số 0 là 0.0");
    }
    
    /**
     * Test trường hợp biên: chỉ có điểm 10
     */
    @Test
    public void testCalculateValidAverage_OnlyTen() {
        List<Double> scores = Arrays.asList(10.0, 10.0, 10.0);
        assertEquals(10.0, analyzer.calculateValidAverage(scores), 0.01,
            "Trung bình của các số 10 là 10.0");
    }
    
    /**
     * Test trường hợp ngoại lệ: tất cả điểm đều không hợp lệ
     */
    @Test
    public void testCalculateValidAverage_AllInvalid() {
        List<Double> scores = Arrays.asList(-5.0, 11.0, -2.0, 15.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01,
            "Không có điểm hợp lệ nào, phải trả về 0.0");
    }
    
    /**
     * Test trường hợp ngoại lệ: có điểm âm lẫn điểm > 10
     */
    @Test
    public void testCalculateValidAverage_NegativeAndAboveTen() {
        List<Double> scores = Arrays.asList(-3.0, 8.0, 12.0, 6.0, -1.0);
        assertEquals(7.0, analyzer.calculateValidAverage(scores), 0.01,
            "Chỉ tính trung bình của 8.0 và 6.0");
    }
    
    /**
     * Test trường hợp một điểm duy nhất hợp lệ
     */
    @Test
    public void testCalculateValidAverage_SingleValidScore() {
        List<Double> scores = Arrays.asList(-5.0, 8.5, 15.0);
        assertEquals(8.5, analyzer.calculateValidAverage(scores), 0.01,
            "Chỉ có 8.5 là hợp lệ");
    }
    
    /**
     * Test trường hợp điểm biên 0 và 10
     */
    @Test
    public void testCalculateValidAverage_BoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.01,
            "Trung bình của 0.0 và 10.0 là 5.0");
    }
}
