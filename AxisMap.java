import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The purpose of the AxisMap class is to maintain the explicit coordinates in sorted order. The AxisMap has a private
 * Map<S, Integer> (where S is the generic coordinate type) that associates to each coordinate value its index among
 * coordinates. For example, if the only coordinates are 2 and 5, then the index of 2 is 0 and the index of 5 is 1.
 *
 * @author ari
 */
public final class AxisMap<S>
{
	private Map<S, Integer> index;

	/**
	 * Creates a new AxisMap. An AxisMap can only be instantiated from one of its Factory methods
	 *
	 * @param index
	 */
	private AxisMap(Map<S, Integer> index)
	{
		this.index = index;
	}

	/**
	 * @param value value to get the index of
	 * @return the index of the given value, or null if the value does not have an index
	 */
	Integer flatIndexOf(S value)
	{
		return index.get(value);
	}

	/**
	 * @return the number of points in the index
	 */
	public int size()
	{
		return index.size();
	}

	/**
	 * @param value the value to get the index of
	 * @return the index of the given value, or null if either the value is null or the value doesn't have an index
	 */
	public Optional<Integer> indexOf(S value)
	{
		return Optional.ofNullable(index.get(value));
	}

	/**
	 * @param coordinates
	 * @return a new AxisMap starting from the given coordinates
	 * @param <S>
	 */
	static<S> AxisMap<S> from(Collection<S> coordinates)
	{
		Map<S, Integer> map = new HashMap<>(coordinates.size());


		/*
		for (S coordinate : coordinates)
			map.put(coordinate, count++);

		Stream.of(coordinates).map(coordinates);
		 */

		//return new AxisMap<>(coordinates.stream().collect(Collectors.toMap(cord -> coordinates, cord)));
		return null;
	}
}
