package shape;

/**
 * The IndexPair class keeps track of the x and y coordinates for a point in the Grid class
 *
 * @param xIndex x-coordinate
 * @param yIndex y-coordinate
 */
record IndexPair(Integer xIndex, Integer yIndex) implements Comparable<IndexPair>
{
	/**
	 * @param direction Direction to increment
	 * @return the next index pair in the given direction
	 */
	public IndexPair increment(Direction direction)
	{
		if (direction.horizontal)
			return direction == Direction.RIGHT ?
					new IndexPair(xIndex + 1, yIndex) : new IndexPair(xIndex - 1, yIndex);
		else
			return direction == Direction.TOP ?
					new IndexPair(xIndex, yIndex + 1) : new IndexPair(xIndex, yIndex - 1);
	}

	/**
	 * @param o the IndexPair to be compared.
	 * @return the comparison between this point (p1 = (x1, y1)) and the point o (p2 = (x2, y2)). If x1 > x2 then
	 * p1 > p2, and if x1 < p1 then p1 < p2. In case of ties, x1 = x2, then the comparison uses the vertical coordinate
	 */
	@Override
	public int compareTo(IndexPair o)
	{
		// Make the xIndex matter more than the yIndex in the weight for determining which to return
		return 2 * Integer.compare(xIndex, o.xIndex) + Integer.compare(yIndex, o.yIndex);
	}

	/**
	 * @return (xIndex, yIndex)
	 */
	@Override
	public String toString()
	{
		return "(" + xIndex + ", " + yIndex + ")";
	}
}
