import shape.Rectangle;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public final class PlaneMap<S>
{
	private AxisMap<S> x;
	private AxisMap<S> y;

	private PlaneMap(AxisMap<S> x, AxisMap<S> y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * @param value the value to get the index of
	 * @return the index of the given value, or null if either the value is null or the value doesn't have an index
	 * for the x-axis
	 */
	public Optional<Integer> xIndexOf(S value)
	{
		return x.indexOf(value);
	}

	/**
	 * @param value the value to get the index of
	 * @return the index of the given value, or null if either the value is null or the value doesn't have an index
	 * for the y-axis
	 */
	public Optional<Integer> yIndexOf(S value)
	{
		return y.indexOf(value);
	}

	/**
	 * @return the number of points in the index for the x-axis
	 */
	public int xSize()
	{
		return x.size();
	}

	/**
	 * @return the number of points in the index for the y-axis
	 */
	public int ySize()
	{
		return y.size();
	}

	/**
	 * @param value      value to get the index of
	 * @param horizontal true for x-axis, false for y-axis
	 * @return an index if it exists and null otherwise
	 */
	Integer indexOf(S value, boolean horizontal)
	{
		// TODO: Determine if the conditional statement can be removed
		if (horizontal)
			return Optional.of(x.indexOf(value)).get().orElse(null);
		return Optional.of(y.indexOf(value)).get().orElse(null);
	}

	/**
	 * @param rectangles
	 * @return a new PlaneMap whose axes correspond to the border coordinates that appear explicitly in the Rectangles
	 * @param <S>
	 */
	public static<S> PlaneMap<S> from(Set<Rectangle> rectangles)
	{
		return null;
	}

	/**
	 * @param x
	 * @param y
	 * @param <S>
	 * @return a new AxisPlane which consists of 2 AxisMaps
	 */
	public static <S> PlaneMap<S> of(Collection<S> x, Collection<S> y)
	{
		return new PlaneMap<>(AxisMap.from(x), AxisMap.from(y));
	}
}
