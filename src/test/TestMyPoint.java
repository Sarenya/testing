package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}
