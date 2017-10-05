package test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.fr.ut2j.m1ice.ootesting.ITranslation;
import main.fr.ut2j.m1ice.ootesting.MyPoint;

public class TestMyPoint {

	MyPoint p;

	@Before
	public void setUp() throws Exception {
		this.p = new MyPoint();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyPoint() {
		assertEquals(0, p.getX(), 0);
		assertEquals(0, p.getY(), 0);
	}

	@Test
	public void testMyPointDoubleDouble1() {
		MyPoint p1 = new MyPoint(2, 5);
		assertEquals(2, p1.getX(), 0);
		assertEquals(5, p1.getY(), 0);
	}

	@Test
	public void testMyPointDoubleDouble2() {
		MyPoint p2 = new MyPoint(8.2, 3.3);
		assertEquals(8.2, p2.getX(), 0.0001);
		assertEquals(3.3, p2.getY(), 0.0001);
	}

	@Test
	public void testMyPointCopy() {
		MyPoint point = new MyPoint(p);
		assertEquals(p.getX(), point.getX(), 0);
		assertEquals(p.getY(), point.getY(), 0);
	}

	@Test
	public void testMyPointCopy2() {
		MyPoint point = new MyPoint(9, 6.1);
		MyPoint point0 = new MyPoint(point);
		assertEquals(point.getX(), point0.getX(), 0.0001);
		assertEquals(point.getY(), point0.getY(), 0.0001);
	}

	@Test
	public void testMyPointCopy3() {
		MyPoint point = new MyPoint(null);
		assertEquals(0, point.getX(), 0);
		assertEquals(0, point.getY(), 0);
	}

	@Test
	public void testScale() {
		MyPoint point = new MyPoint(1, 2);
		MyPoint point1 = point.scale(3);
		assertEquals(3, point1.getX(), 0.0001);
		assertEquals(6, point1.getY(), 0.0001);
	}

	@Test
	public void testGetSetX() {
		double val = 4874.52;
		p.setX(val);
		assertEquals(val, p.getX(), 0.0001);
	}

	@Test
	public void testSetX() {
		double val = 4874.52;
		p.setX(val);
		p.setX(Double.NaN);
		assertEquals(val, p.getX(), 0.0001);
	}

	@Test
	public void testGetSetY() {
		double val = 829.589;
		p.setY(val);
		assertEquals(val, p.getY(), 0.0001);
	}

	@Test
	public void testSetY() {
		double val = 4874.52;
		p.setY(val);
		p.setY(Double.NaN);
		assertEquals(val, p.getY(), 0.0001);
	}

	@Test
	public void testHorizontalSymmetry1() {
		MyPoint p0 = new MyPoint(7, 4);
		MyPoint point = p0.horizontalSymmetry(p);
		assertEquals((-7), point.getX(), 0);
		assertEquals(4, point.getY(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetry2() {
		p.horizontalSymmetry(null);
	}

	@Test
	public void testComputeAngle1() {
		MyPoint point = new MyPoint(1, 1);
		double angle = p.computeAngle(point);
		assertEquals(0.78539, angle, 0.0001);
	}

	@Test
	public void testComputeAngle2() {
		MyPoint point = new MyPoint(0, 1);
		double angle = p.computeAngle(point);
		assertEquals(1.5708, angle, 0.0001);
	}

	@Test
	public void testComputeAngle3() {
		MyPoint point = new MyPoint(0, -1);
		double angle = p.computeAngle(point);
		assertEquals(-1.5708, angle, 0.0001);
	}

	@Test
	public void testComputeAngle4() {
		double angle = p.computeAngle(null);
		assertEquals(Double.NaN, angle, 0);
	}

	@Test
	public void testRotatePoint() {
		MyPoint point = new MyPoint(1, 1);
		MyPoint point2 = point.rotatePoint(p, 1.5708);
		assertEquals(-1, point2.getX(), 0.0001);
		assertEquals(1, point2.getY(), 0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymetry1() {
		p.centralSymmetry(null);
	}

	@Test
	public void testCentralSymetry2() {
		MyPoint point = new MyPoint(1, 1);
		MyPoint point2 = point.centralSymmetry(p);
		assertEquals(-1, point2.getX(), 0.0001);
		assertEquals(-1, point2.getY(), 0.0001);
	}

	@Test
	public void testGetMiddlePoint() {
		MyPoint point = new MyPoint(2, 2);
		MyPoint point2 = point.getMiddlePoint(p);
		assertEquals(1, point2.getX(), 0);
		assertEquals(1, point2.getY(), 0);
	}

	@Test
	public void testTranslate1() {
		p.translate(12, 3);
		assertEquals(12, p.getX(), 0);
		assertEquals(3, p.getY(), 0);
	}

	@Test
	public void testTranslate2() {
		p.translate(Double.NaN, 3);
		assertEquals(0, p.getX(), 0);
		assertEquals(0, p.getY(), 0);
	}

	@Test
	public void testTranslate3() {
		p.translate(12, Double.NaN);
		assertEquals(0, p.getX(), 0);
		assertEquals(0, p.getY(), 0);
	}

	@Test
	public void testTranslateI2() {
		p.translate(null);
		assertEquals(0, p.getX(), 0);
		assertEquals(0, p.getY(), 0);
	}

	@Test
	public void testSetPoint() {
		Random r1 = Mockito.mock(Random.class);
		Random r2 = Mockito.mock(Random.class);
		MyPoint point = new MyPoint();
		Mockito.when(r1.nextInt()).thenReturn(12);
		Mockito.when(r2.nextInt()).thenReturn(73);
		point.setPoint(r1, r2);
		assertEquals(12, point.getX(), 0.0001);
		assertEquals(73, point.getY(), 0.0001);

	}

}
