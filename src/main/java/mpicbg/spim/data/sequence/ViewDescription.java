package mpicbg.spim.data.sequence;


/**
 * TODO
 *
 * @param <T>
 *            {@link TimePoint} type
 * @param <V>
 *            {@link ViewSetup} type
 *
 * @author Tobias Pietzsch <tobias.pietzsch@gmail.com>
 */
public class ViewDescription< T extends TimePoint, V extends ViewSetup > extends ViewId
{
	/**
	 * TODO
	 */
	protected boolean present;

	protected final SequenceDescription< ? extends T, ? extends V > sequenceDescription;

	/**
	 * TODO
	 *
	 * @return
	 */
	public boolean isPresent()
	{
		return present;
	}

	public T getTimePoint()
	{
		return sequenceDescription.getTimePoints().getTimePointList().get( timepoint );
	}

	public V getViewSetup()
	{
		return sequenceDescription.getViewSetups().get( setup );
	}

	public ViewDescription( final SequenceDescription< ? extends T, ? extends V > sequenceDescription, final boolean present, final int timepointId, final int setupId )
	{
		super( timepointId, setupId );
		this.present = present;
		this.sequenceDescription = sequenceDescription;
	}
	
	@Override
	public int hashCode() 
	{
		return getViewSetupId() + getTimePointId() * sequenceDescription.getViewSetups().size();
	}
}
