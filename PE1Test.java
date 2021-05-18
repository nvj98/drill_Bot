package ProgrammingExam1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class PE1Test {
	Draw blankCanvas = new Draw("Programmign Exam1");

	@Test
	void testNestedCircle_1() {
		String expected = "[0.4, 0.35, 0.3, 0.25, 0.2, 0.15, 0.1, 0.05, 0.0]";
		String actual = PE1.nestedCircle (0.5, 0.5, 0.4, 0.05,  blankCanvas, "");
		String message = "\"" + expected+ "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";

		assertEquals(expected, actual, message);
	}

	@Test
	void testNestedCircle_2() {
		String expected = "[0.0]";
		String actual = PE1.nestedCircle (0.5, 0.5, 0, 0.05,  blankCanvas, "");
		String message = "\"" + expected+ "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";

		assertEquals(expected, actual, message);
	}
	
	@Test
	void testNestedCircle_3() {
		String expected = "[]";
		String actual = PE1.nestedCircle (0.5, 0.5, -0.1, 0.05,  blankCanvas, "");
		String message = "\"" + expected+ "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";

		assertEquals(expected, actual, message);
	}
	@Test
	void testNestedCircle_4() {
		String expected = "[3.0, 2.95, 2.9, 2.85, 2.8, 2.75, 2.7, 2.65, 2.6, 2.55, 2.5, 2.45, 2.4, 2.35, 2.3, 2.25, 2.2, 2.15, 2.1, 2.05, 2.0, 1.95, 1.9, 1.85, 1.8, 1.75, 1.7, 1.65, 1.6, 1.55, 1.5, 1.45, 1.4, 1.35, 1.3, 1.25, 1.2, 1.15, 1.1, 1.05, 1.0, 0.95, 0.9, 0.85, 0.8, 0.75, 0.7, 0.65, 0.6, 0.55, 0.5, 0.45, 0.4, 0.35, 0.3, 0.25, 0.2, 0.15, 0.1, 0.05, 0.0]";
		String actual = PE1.nestedCircle (0.1, 0.1, 3, 0.05,  blankCanvas, "");
		String message = "\"" + expected+ "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";

		assertEquals(expected, actual, message);
	}
	
	@Test
	void testSquares_1() {
		String[] expected = {"[0.7, 0.7]", "[0.7, 0.3]", "[0.3, 0.7]", "[0.3, 0.3]"};
		String actual = PE1.squares(0.5, 0.5, 0.2, 2, blankCanvas);
		String message = "\""; 
		for (int i = 0; i < expected.length; i++)
			message = message + expected[i]; 
		message = message + "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";
		boolean equal = true; 
		for (int i = 0; i < expected.length; i++)
			if (!actual.contains(expected[i])) {
				equal = false; 
				break;
			}
		
		assertTrue(equal, message);
	}

	@Test
	void testSquares_2() {
		String[] expected = {"[0.5, 0.5]"};
		String actual = PE1.squares(0.5, 0.5, 0.2, 1, blankCanvas);
		String message = "\""; 
		for (int i = 0; i < expected.length; i++)
			message = message + expected[i]; 
		message = message + "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";
		boolean equal = true; 
		for (int i = 0; i < expected.length; i++) {
			if (!actual.contains(expected[i])) {
				equal = false; 
				break;
			}
		}
		
		assertTrue(equal, message);
	}
	@Test
	void testSquares_3() {
		String[] expected = {"[]"};
		String actual = PE1.squares(0.5, 0.5, 0.2, 0, blankCanvas);
		String message = "\"null or []\" is expected but \"" + actual+ "\""+ "is given!";
		boolean equal = true; 
		if (!(actual.contains("[]") || actual.contains("")))
				equal = false; 
	
		assertTrue(equal, message);
	}
	

		@Test
		void testSquares_4() {
			String[] expected = {"[0.8, 0.8]","[0.8, 0.7]","[0.7, 0.8]","[0.7, 0.7]",
								"[0.8, 0.6]","[0.8, 0.5]","[0.7, 0.6]","[0.7, 0.5]",
								"[0.6, 0.8]","[0.6, 0.7]","[0.5, 0.8]","[0.5, 0.7]",
								"[0.6, 0.6]","[0.6, 0.5]","[0.5, 0.6]","[0.5, 0.5]",
								"[0.8, 0.4]","[0.8, 0.3]","[0.7, 0.4]","[0.7, 0.3]",
								"[0.8, 0.2]","[0.8, 0.1]","[0.7, 0.2]","[0.7, 0.1]",
								"[0.6, 0.4]","[0.6, 0.3]","[0.5, 0.4]","[0.5, 0.3]",
								"[0.6, 0.2]","[0.6, 0.1]","[0.5, 0.2]","[0.5, 0.1]",
								"[0.4, 0.8]","[0.4, 0.7]","[0.3, 0.8]","[0.3, 0.7]",
								"[0.4, 0.6]","[0.4, 0.5]","[0.3, 0.6]","[0.3, 0.5]",
								"[0.2, 0.8]","[0.2, 0.7]","[0.1, 0.8]","[0.1, 0.7]",
								"[0.2, 0.6]","[0.2, 0.5]","[0.1, 0.6]","[0.1, 0.5]",
								"[0.4, 0.4]","[0.4, 0.3]","[0.3, 0.4]","[0.3, 0.3]",
								"[0.4, 0.2]","[0.4, 0.1]","[0.3, 0.2]","[0.3, 0.1]",
								"[0.2, 0.4]","[0.2, 0.3]","[0.1, 0.4]","[0.1, 0.3]",
							    "[0.2, 0.2]","[0.2, 0.1]","[0.1, 0.2]","[0.1, 0.1]"};
			String actual = PE1.squares(0.5, 0.5, 0.2, 4, blankCanvas);
			String message = "\""; 
			for (int i = 0; i < expected.length; i++)
				message = message + expected[i]; 
			message = message + "\""+ "expected but " + "\"" + actual+ "\""+ "is given!";
			boolean equal = true; 
			for (int i = 0; i < expected.length; i++)
				if (!actual.contains(expected[i])) {
					equal = false; 
					break;
				}
			
			assertTrue(equal, message);
		}
		
		@Test
		void testDrillPoints_1() {
			ArrayList<String> expected = new ArrayList<String>(); 
			expected.add("[0.1, 0.1]"); 
			expected.add("[0.9, 0.1]"); 
			expected.add("[0.5, 0.9]"); 
			Point p1 = new Point (0.1, 0.1);
			Point p2 = new Point(0.9, 0.1);
			Point p3 = new Point (0.5, 0.9);
			String message = "";
			ArrayList<String> actual = new ArrayList<String>(); 
			actual = PE1.drillPoints(p1, p2, p3, 1, blankCanvas, actual);
			boolean equal = (expected.size() == actual.size()) && expected.containsAll(actual);
		
			if (expected.size() ==  actual.size()) 
				message = "The expected points are not found."; 
			else
				message = "The number of points is not as expected."; 
			
			assertTrue(equal, message);
		}


		@Test
		void testDrillPoints_2() {
			ArrayList<String> expected = new ArrayList<String>(); 
			expected.add("[0.1, 0.1]");
			expected.add("[0.5, 0.1]");
			expected.add("[0.3, 0.5]");
			expected.add("[0.9, 0.1]");
			expected.add("[0.7, 0.5]");
			expected.add("[0.5, 0.9]");

			Point p1 = new Point (0.1, 0.1);
			Point p2 = new Point(0.9, 0.1);
			Point p3 = new Point (0.5, 0.9);
			String message = "";
			ArrayList<String> actual = new ArrayList<String>(); 
			actual = PE1.drillPoints(p1, p2, p3, 2, blankCanvas, actual);
			boolean equal = (expected.size() == actual.size()) && expected.containsAll(actual);
		
			if (expected.size() ==  actual.size()) 
				message = "The expected points are not found."; 
			else
				message = "The number of points is not as expected."; 
			
			assertTrue(equal, message);
		}
		@Test
		void testDrillPoints_3() {
			Point p1 = new Point (0.1, 0.1);
			Point p2 = new Point(0.9, 0.1);
			Point p3 = new Point (0.5, 0.9);
			String message = "";
			ArrayList<String> actual = new ArrayList<String>(); 
			actual = PE1.drillPoints(p1, p2, p3, 0, blankCanvas, actual);
			boolean equal = (actual.size() == 0);
		
			message = "The list should be empty."; 
			
			assertTrue(equal, message);
		}
		@Test	
		void testDrillPoints_4() {
			ArrayList<String> expected = new ArrayList<String>(); 
			expected.add("[0.1, 0.1]");
			expected.add("[0.2, 0.1]");
			expected.add("[0.15, 0.2]");
			expected.add("[0.3, 0.1]");
			expected.add("[0.25, 0.2]");
			expected.add("[0.2, 0.3]");
			expected.add("[0.4, 0.1]");
			expected.add("[0.35, 0.2]");
			expected.add("[0.5, 0.1]");
			expected.add("[0.45, 0.2]");
			expected.add("[0.4, 0.3]");
			expected.add("[0.3, 0.3]");
			expected.add("[0.25, 0.4]");
			expected.add("[0.35, 0.4]");
			expected.add("[0.3, 0.5]");
			expected.add("[0.6, 0.1]");
			expected.add("[0.55, 0.2]");
			expected.add("[0.7, 0.1]");
			expected.add("[0.64, 0.2]");
			expected.add("[0.6, 0.3]");
			expected.add("[0.8, 0.1]");
			expected.add("[0.75, 0.2]");
			expected.add("[0.9, 0.1]");
			expected.add("[0.85, 0.2]");
			expected.add("[0.8, 0.3]");
			expected.add("[0.7, 0.3]");
			expected.add("[0.64, 0.4]");
			expected.add("[0.75, 0.4]");
			expected.add("[0.7, 0.5]");
			expected.add("[0.4, 0.5]");
			expected.add("[0.35, 0.6]");
			expected.add("[0.5, 0.5]");
			expected.add("[0.45, 0.6]");
			expected.add("[0.4, 0.7]");
			expected.add("[0.6, 0.5]");
			expected.add("[0.55, 0.6]");
			expected.add("[0.64, 0.6]");
			expected.add("[0.6, 0.7]");
			expected.add("[0.5, 0.7]");
			expected.add("[0.45, 0.8]");
			expected.add("[0.55, 0.8]");
			expected.add("[0.5, 0.9]");

			Point p1 = new Point (0.1, 0.1);
			Point p2 = new Point(0.9, 0.1);
			Point p3 = new Point (0.5, 0.9);
			String message = "";
			ArrayList<String> actual = new ArrayList<String>(); 
			actual = PE1.drillPoints(p1, p2, p3, 4, blankCanvas, actual);
			boolean equal = (expected.size() == actual.size()) && expected.containsAll(actual);
		
			if (expected.size() ==  actual.size()) 
				message = "The expected points are not found."; 
			else
				message = "The number of points is not as expected."; 
			
			assertTrue(equal, message);
		}
	
}

