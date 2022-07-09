// Task 2
import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradebookTester extends TestCase {

	// Task 3.1
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;
	
	@BeforeEach
	protected void setUp() throws Exception {
		// Task 3.1
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook1.addScore(87.5);
		gradeBook1.addScore(60.1);
		
		gradeBook2.addScore(95.0);
		gradeBook2.addScore(74.5);
		gradeBook2.addScore(25.3);
		gradeBook2.addScore(88.8);
		gradeBook2.addScore(66.0);
		
		super.setUp();
	}
	@AfterEach
	protected void tearDown() throws Exception {
		
		// Task 3.2
		gradeBook1 = null;
		gradeBook2 = null;
		
		super.tearDown();
	}

	// Task 4.1
	@Test
	public void testAddScore() {
		assertTrue(gradeBook1.toString().equals("87.5 60.1 "));
		assertTrue(gradeBook2.toString().equals("95.0 74.5 25.3 88.8 66.0 "));
		
		assertEquals(gradeBook1.getScoreSize(), 2);
		assertEquals(5, gradeBook2.getScoreSize(), 5);
	}
	// Task 4.2
	@Test
	public void testSum() {
		assertEquals(147.6, gradeBook1.sum(), .0001);
		assertEquals(349.6, gradeBook2.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(60.1, gradeBook1.minimum(), .0001);
		assertEquals(25.3, gradeBook2.minimum(), .0001);
	}
	
	@Test
	public void testFinalScore() {
		assertEquals(87.5, gradeBook1.finalScore(), .0001);
		assertEquals(324.3, gradeBook2.finalScore(), .0001);
	}

}
