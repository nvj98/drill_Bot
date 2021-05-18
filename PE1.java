package ProgrammingExam1;
import java.awt.Color;
import java.util.ArrayList; 



public class PE1 {
	public static void main(String[] args) {
		
		/* A canvas should be created for drawing.
		 * All the shapes should be drawn on the canvas.
		 * The bottom left coordinate of the canvas is (0,0)
		 * The top right coordinates of the canvas is (1, 1) 
		 * The input parameter to Draw() constructor is the 
		 * title of the canvas.
		 */
        Draw blankCanvas = new Draw("Programmign Exam 1");
        
        /* To draw a point, point function is called with proper parameters: 
         * point(x_coordinate_of_point, y_coordinate_of_point)
         */
        blankCanvas.point(0.5, 0.5);
        
        /* To draw a circle, circle function is called with proper parameters: 
         * circle(x_coordinate_of_center, y_coordinate_of_center, radius)
         */
        blankCanvas.circle(0.5, 0.5, 0.5);

        /* To draw a square, square function is called with proper parameters: 
         * square(x_coordinate_of_center, y_coordinate_center, sides_half_length)
        */
        blankCanvas.square(0.5,  0.5, 0.4);
        
        /*
         * To change the color of the pen, setPenColor is used with three numbers that are in [0, 255] range.
         * All the colors can be made as a combination of red, green and blue. 
         * The parameters show the richness of red, green and blue of a color. 
         * For example setPenColor(new Color(0, 0, 0) sets the color of the pen
         * to black and setPenColor(new Color(255, 255, 255) sets the color to 
         * white.
         */
         blankCanvas.setPenColor(new Color(150, 150, 150));
         
         /* To draw a line, line function is called 
          * with proper parameters: 
          * line(x_coordinate_of_center, y_coordinate_center, sides_half_length)
         */
         blankCanvas.line(0.0, 0.5, 1, 0.5);
         Point p1 = new Point(0.1, 0.1);
         Point p2 = new Point(0.9, 0.1);
         Point p3 = new Point(0.5, 0.9);
         ArrayList<String> array = new ArrayList<String>(); 
         System.out.println(drillPoints(p1, p2, p3, 2, blankCanvas, array));
         String radiusList = "";
         System.out.println(nestedCircle (0.2, 0.2, 0.72, 0.05,  blankCanvas, radiusList));
         
 
	}

	
	/**
	 * This method draws a number of circles that share the same center, as long as the radius is positive.
	 * @param x is the x-coordinate of the circles
	 * @param y is the y-coordinate of the circles. 
	 * @param radius is the radius of a circle. 
	 * 		The function is called with the radius that is cut to two decimal points. 
	 * 		For example 0.39876543210 must be cut to 0.39
	 * @param diff is the difference between the radius of a circle and its immediate inner circle.
	 * @param page is the canvas on which the circles are drawn.
	 * @param radiusList is an accumulated list of the radius of the circles that were drawn. 
	 * @return a list of all the circles' radius that were drawn. 
	 */
	public static String nestedCircle (double x, double y, double radius, double diff,  Draw page, String radiusList) {
		
		if (radius <0) return "["+radiusList.substring(radiusList.indexOf(' ')+ 1)+"]";
		return nestedCircle (x, y, radius - diff , diff, page, radiusList + ", "+ Double.toString(((int)(radius*100))/100.0));
	}
	/**
	 * This method recursively draws 4 squares, whose center falls on a corner of 
	 * previously drawn square. The side of the square is half as much as the side of the 
	 * square that is drawn in previous round. 
	 * @param x is the x-coordinate of the square
	 * @param y is the y-coordinate of the square
	 * @param halfLength is half the size of the square's side
	 * @param order is the number of the rounds by which a set of squares is drawn
	 * @param page is the canvas on which the squares are drawn.
	 * @return a list of the center of smallest squares that are drawn.. 
	 * 		The coordinates should be cut to one decimal point. For example:
	 * 		 0.39876543210 is cut to 0.3 
	 */
	public static String squares (double x, double y, double halfLength, int order, Draw page) {
		if (order == 0) return "[]";
		if (order ==  1 ) {
			page.square(x, y, halfLength);
			return "[" + (int)(x*10)/10.0 + ", " +  (int)(y*10)/10.0+ "]";
		}
		page.square(x, y, halfLength);
		double x1 = x + halfLength; 
		double y1 = y + halfLength;
		String coordinate1 = squares(x1, y1, halfLength /2 , order - 1, page);				
		x1 = x + halfLength; 
		y1 = y - halfLength;
		String coordinate2 = squares(x1, y1, halfLength /2 , order - 1, page);				
		x1 = x - halfLength; 
		y1 = y + halfLength;
		String coordinate3 = squares(x1, y1, halfLength /2, order - 1, page);				
		x1 = x - halfLength; 
		y1 = y - halfLength;
		String coordinate4 =squares(x1, y1, halfLength /2, order - 1, page);
		return coordinate1 + coordinate2 + coordinate3 + coordinate4;
	}
	/**
	 * This method specifies which coordinates should be drilled. It also draw the 
	 * horizontal line of each triangle. No duplicate point should be added to the output. 
	 * @param p1 is one of the vertex of the triangle
	 * @param p2 is the second vertex of the triangle
	 * @param p3 is the third vertex of the triangle
	 * @param order is the number of times a nested triangle should be drawn. 
	 * 			<code> order >= 0 </code>, however if it is zero, nothing should be drawn
	 * @param page is the canvas on which this method draws.
	 * @param array is the list of the points that should be drilled. To add to this list point.toString() must be added.
	 * @return an array that contains all the points that should be drilled. this method should not have any duplicate points in it. 
	 */
	public static ArrayList<String> drillPoints(Point p1, Point p2, Point p3, int order, Draw page, ArrayList<String> array) {
		if (order != 0)  
			if (order == 1) {
				page.setPenColor(Color.RED);
				page.line(p1.x,  p1.y, p2.x, p2.y); 
				page.setPenColor(Color.BLACK);
		        page.point(p3.x,  p3.y); 
		        page.point(p2.x,  p2.y); 
		        page.point(p1.x,  p1.y);
		        if (!array.contains(p1.toString()))
		        	array.add(p1.toString()); 
		        if (!array.contains(p2.toString()))
		        	array.add(p2.toString());
		        if (!array.contains(p3.toString()))
					array.add(p3.toString());
			} 
		    else {
		        Point m12 = Point.midpoint(p1, p2);
		        Point m23 = Point.midpoint(p2, p3);
		        Point m13 = Point.midpoint(p1, p3);
		        drillPoints(p1, m12, m13, order - 1,  page, array);
		        drillPoints(m12, p2, m23, order - 1, page, array );
		        drillPoints(m13, m23, p3,order - 1,  page, array);
		    }
		return array;
	}

}
/**
 * This class creates a point. 
 *
 */
class Point {
	double x; 
	double y; 
	/**
	 * This is the constructor that builds a point
	 * @param x is the x-coordinate of the point
	 * @param y is the y-coordinate of the point
	 */
	public Point(double x, double y) {
		this.x = x; 
		this.y = y; 
	}
	/**
	 * This method returns the mid point of a line, 
	 * whose two ends are given.
	 * @param p1 is one end of the line
	 * @param p2 is the other end of the line
	 * @return the mid point of the line. Both the 
	 * coordinates are cut to two decimal points. 
	 * e.g. 0.37654 is cut to 0.37
	 */
	public static Point midpoint(Point p1, Point p2) {
		double  x = (int) ((p1.x + p2.x)/2 * 100)/ 100.0; 
		double y = (int) ((p1.y + p2.y)/2 * 100)/ 100.0; 
		return new Point(x, y);
	}
	@Override
	/**
	 * This method returns the coordinate of this object as a string.
	 */
	public String toString() {
		return "["+this.x + ", "+ this.y +"]";
	}
	
}
