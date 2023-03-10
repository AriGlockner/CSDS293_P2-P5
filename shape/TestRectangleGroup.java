package shape;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * This class tests the RectangleGroup class
 *
 * @author ari
 */
public class TestRectangleGroup
{
	/**
	 * This method tests the RectangleGroup class
	 */
	@Test
	public void testRectangleGroup()
	{
		// Create Sets
		Set<Rectangle<Integer>> rectangleSet1 = new LinkedHashSet<>();
		Set<Rectangle<Integer>> rectangleSet2 = new LinkedHashSet<>();

		// Add Rectangles to set
		rectangleSet1.add(Rectangle.of(1, 2, 1, 2));
		rectangleSet1.add(Rectangle.of(0, 3, 4, 5));
		rectangleSet1.add(Rectangle.of(1, 2, 1, 2));
		rectangleSet1.add(Rectangle.of(1, 3, 2, 4));

		rectangleSet2.add(Rectangle.of(1, 2, 1, 2));
		rectangleSet2.add(Rectangle.of(0, 3, 4, 5));

		// Create RectangleGroups
		RectangleGroup<Integer> rectangleGroup1 = RectangleGroup.from(rectangleSet1);
		RectangleGroup<Integer> rectangleGroup2 = RectangleGroup.from(rectangleSet2);

		// Test getSet
		assertEquals(rectangleSet1, rectangleGroup1.getSet());
		assertEquals(rectangleSet2, rectangleGroup2.getSet());

		// Test getPlaneMap
		assertEquals("{0=0, 1=1, 2=2, 3=3} {1=0, 2=1, 4=2, 5=3}", rectangleGroup1.getPlaneMap().toString());
		assertEquals("{0=0, 1=1, 2=2, 3=3} {1=0, 2=1, 4=2, 5=3}", rectangleGroup2.getPlaneMap().toString());

		// Test Matrix Grid
		assertEquals("{(0, 0)=0, (0, 1)=0, (0, 2)=1, (0, 3)=1, (1, 0)=2, (1, 1)=3, (1, 2)=2, (1, 3)=1, " +
						"(2, 0)=2, (2, 1)=3, (2, 2)=2, (2, 3)=1, (3, 0)=0, (3, 1)=1, (3, 2)=2, (3, 3)=1}",
				rectangleGroup1.toString());
		assertEquals("{(0, 0)=0, (0, 1)=0, (0, 2)=1, (0, 3)=1, (1, 0)=1, (1, 1)=1, (1, 2)=1, (1, 3)=1, " +
						"(2, 0)=1, (2, 1)=1, (2, 2)=1, (2, 3)=1, (3, 0)=0, (3, 1)=0, (3, 2)=1, (3, 3)=1}",
				rectangleGroup2.toString());

		// Test Overlapping
		assertTrue(rectangleGroup1.isOverlapping());
		assertFalse(rectangleGroup2.isOverlapping());

		// Test working with other types than just integers
		Set<Rectangle<String>> set = new LinkedHashSet<>();
		set.add(Rectangle.of("bar", "foo", "bar", "foo"));
		set.add(Rectangle.of("a", "b", "c", "d"));

		RectangleGroup<String> rectangleGroup = RectangleGroup.from(set);
		assertEquals("{(0, 0)=0, (0, 1)=1, (0, 2)=1, (0, 3)=0, (1, 0)=0, (1, 1)=1, (1, 2)=1, (1, 3)=0, " +
						"(2, 0)=1, (2, 1)=1, (2, 2)=1, (2, 3)=1, (3, 0)=1, (3, 1)=1, (3, 2)=1, (3, 3)=1}",
				rectangleGroup.toString());
	}

	/**
	 * This method tests the isConnected method in the RectangleGroup class
	 */
	@Test
	public void testIsConnected()
	{
		// Integer Tests
		// Create Rectangle sets with Integers
		Set<Rectangle<Integer>> rectangleSet1 = new LinkedHashSet<>();
		Set<Rectangle<Integer>> rectangleSet2 = new LinkedHashSet<>();

		// Add rectangles to sets
		rectangleSet1.add(Rectangle.of(1, 2, 1, 2));
		rectangleSet2.add(Rectangle.of(1, 2, 1, 2));
		rectangleSet2.add(Rectangle.of(5, 10, 5, 10));

		// Create RectangleGroups from Rectangles
		RectangleGroup<Integer> rectangleGroup1 = RectangleGroup.from(rectangleSet1);
		RectangleGroup<Integer> rectangleGroup2 = RectangleGroup.from(rectangleSet2);

		// Test isConnected method
		assertTrue(rectangleGroup1.isConnected());
		assertFalse(rectangleGroup2.isConnected());

		// String Tests
		// Create Sets of Rectangles
		Set<Rectangle<String>> rectangleStringSet1 = new LinkedHashSet<>();
		Set<Rectangle<String>> rectangleStringSet2 = new LinkedHashSet<>();
		Set<Rectangle<String>> rectangleStringSet3 = new LinkedHashSet<>();

		// Add Rectangles to sets
		// Test 1 - Not connected
		rectangleStringSet1.add(Rectangle.of("bar", "foo", "bar", "foo"));
		rectangleStringSet1.add(Rectangle.of("(555) 555-5556", "<b>", "(555) 555-5556", "<b>"));

		// Test 2 - Multiple connected Rectangles
		rectangleStringSet2.add(Rectangle.of("crap", "fuck", "damn", "shit"));
		rectangleStringSet2.add(Rectangle.of("crap", "damn", "fuck", "shit"));

		// Test 3 - 1 Rectangle
		rectangleStringSet3.add(Rectangle.of("bar", "foo", "bar", "foo"));

		// Create RectangleGroups from Rectangles
		RectangleGroup<String> rectangleStringGroup1 = RectangleGroup.from(rectangleStringSet1);
		RectangleGroup<String> rectangleStringGroup2 = RectangleGroup.from(rectangleStringSet2);
		RectangleGroup<String> rectangleStringGroup3 = RectangleGroup.from(rectangleStringSet3);

		// Test isConnected
		assertFalse(rectangleStringGroup1.isConnected());
		assertTrue(rectangleStringGroup2.isConnected());
		assertTrue(rectangleStringGroup3.isConnected());
	}
}
