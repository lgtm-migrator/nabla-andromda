// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.andromda.timetracker.vo.TimeAllocationVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * <p>
 * Base EJB3 DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>TimeAllocation</code>.
 * </p>
 *
 * @see TimeAllocationDao
 */
//@javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
//@javax.ejb.Local({TimeAllocationDao.class})
public abstract class TimeAllocationDaoBase implements TimeAllocationDao
{

    private static final Logger logger = Logger.getLogger(TimeAllocationDaoBase.class);

    /** Session Context Injection */
    @Resource
    protected SessionContext context;

    /**
     * Inject persistence context timetracker-ejb3     */
    @PersistenceContext(unitName = "timetracker-ejb3")    protected EntityManager entityManager;

    /**
     * Inject Hibernate Session
     */
    @PersistenceContext(unitName = "timetracker-ejb3")    protected Session hibernateSession;

    /**
     * @see TimeAllocationDao#load
     */
    @Override
    public Object load(final int transform, final Long id) throws TimeAllocationDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("TimeAllocation.load - 'id' can not be null");
        }
        try
        {
                        final TimeAllocation entity = this.entityManager.find(TimeAllocation.class, id);
            return transformEntity(transform, entity);
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * @see TimeAllocationDao#load( Long)
     */
    @Override
        public TimeAllocation load( final Long id) throws TimeAllocationDaoException
    {
        return (TimeAllocation)this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see TimeAllocationDao#loadAll()
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Collection<TimeAllocation> loadAll() throws TimeAllocationDaoException
    {
        return this.loadAll(TRANSFORM_NONE);
    }

    /**
     * @see TimeAllocationDao#loadAll(int)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Collection loadAll(final int transform) throws TimeAllocationDaoException
    {
        try
        {
            TypedQuery<TimeAllocation> query = this.entityManager.createNamedQuery("TimeAllocation.findAll", TimeAllocation.class);

            List<TimeAllocation> results = query.getResultList();
            this.transformEntities(transform, results);
            return results;
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * Create TimeAllocation with no VO transformation
     * @see TimeAllocationDao#create(TimeAllocation)
     */
    @Override
    public TimeAllocation create(TimeAllocation timeAllocation) throws TimeAllocationDaoException
    {
        return (TimeAllocation)this.create(TRANSFORM_NONE, timeAllocation);
    }

    /**
     * Create TimeAllocation with VO transformation
     * @see TimeAllocationDao#create(int, TimeAllocation)
     */
    @Override
    public Object create(final int transform, final TimeAllocation timeAllocation) throws TimeAllocationDaoException
    {
        if (timeAllocation == null)
        {
            throw new IllegalArgumentException("TimeAllocation.create - 'timeAllocation' can not be null");
        }

        try
        {
            this.entityManager.persist(timeAllocation);
            this.entityManager.flush();
            return this.transformEntity(transform, timeAllocation);
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * Create a Collection of TimeAllocation with no VO transformation
     * @see TimeAllocationDao#create(Collection)
     */
    @Override
    //@SuppressWarnings({"unchecked"})
    public Collection<TimeAllocation> create(final Collection<TimeAllocation> entities) throws TimeAllocationDaoException
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * Create a Collection of TimeAllocation with VO transformation
     * @see TimeAllocationDao#create(int, Collection)
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Collection create(final int transform, final Collection<TimeAllocation> entities) throws TimeAllocationDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("TimeAllocation.create - 'entities' can not be null");
        }
        Collection results = new ArrayList();
        try
        {
            for (final TimeAllocation entity : entities)
            {
                results.add(create(transform, entity));
            }
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
        return results;
    }

    /**
     * Create Entity TimeAllocation using instance attributes with no VO transformation
     * @see TimeAllocationDao#create(TimePeriod)
     */
    @Override
    public TimeAllocation create(TimePeriod timePeriod) throws TimeAllocationDaoException
    {
        return (TimeAllocation)this.create(TRANSFORM_NONE, timePeriod);
    }

    /**
     * Create Entity TimeAllocation using instance attributes with VO transformation
     * @see TimeAllocationDao#create(int, TimePeriod)
     * composite=false identifiers=1
     */
    @Override
    public Object create(final int transform, TimePeriod timePeriod) throws TimeAllocationDaoException
    {
        TimeAllocation entity = new TimeAllocation();
        entity.setTimePeriod(timePeriod);
        return this.create(transform, entity);
    }

    /**
     * Create Entity TimeAllocation using required properties with no VO transformation
     * @see TimeAllocationDao#create(Task, Timecard, TimePeriod)
     */
    @Override
    public TimeAllocation create(Task task, Timecard timecard, TimePeriod timePeriod) throws TimeAllocationDaoException
    {
        return (TimeAllocation)this.create(TRANSFORM_NONE, task, timecard, timePeriod);
    }

    /**
     * Create Entity TimeAllocation using required properties with VO transformation
     * @see TimeAllocationDao#create(int, Task, Timecard, TimePeriod)
     */
    @Override
    public Object create(final int transform,Task task, Timecard timecard, TimePeriod timePeriod) throws TimeAllocationDaoException
    {
        TimeAllocation entity = new TimeAllocation();
        // task $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setTask(task);
        // timecard $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setTimecard(timecard);
        // timePeriod $propertyType.fullyQualifiedName identifier=$propertyType.identifier false
        entity.setTimePeriod(timePeriod);
        return this.create(transform, entity);
    }

    /**
     * @see TimeAllocationDao#update(TimeAllocation)
     */
    @Override
    public void update(TimeAllocation timeAllocation) throws TimeAllocationDaoException
    {
        if (timeAllocation == null)
        {
            throw new IllegalArgumentException("TimeAllocation.update - 'timeAllocation' can not be null");
        }
        try
        {
            this.entityManager.merge(timeAllocation);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * @see TimeAllocationDao#update(Collection)
     */
    @Override
    public void update(final Collection<TimeAllocation> entities) throws TimeAllocationDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("TimeAllocation.update - 'entities' can not be null");
        }
        try
        {
            for (final TimeAllocation entity : entities)
            {
                update(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * @see TimeAllocationDao#remove(TimeAllocation)
     */
    @Override
    public void remove(TimeAllocation timeAllocation) throws TimeAllocationDaoException
    {
        if (timeAllocation == null)
        {
            throw new IllegalArgumentException("TimeAllocation.remove - 'timeAllocation' can not be null");
        }
        try
        {
            this.entityManager.remove(timeAllocation);
            this.entityManager.flush();
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * @see TimeAllocationDao#remove(Long)
     */
    @Override
    public void remove(Long id) throws TimeAllocationDaoException
    {
        if (id == null)
        {
            throw new IllegalArgumentException("TimeAllocation.remove - 'id' can not be null");
        }
        try
        {
            final TimeAllocation entity = this.load(id);
            if (entity != null)
            {
                this.remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * @see TimeAllocationDao#remove(Collection)
     */
    @Override
    public void remove(Collection<TimeAllocation> entities) throws TimeAllocationDaoException
    {
        if (entities == null)
        {
            throw new IllegalArgumentException("TimeAllocation.remove - 'entities' can not be null");
        }
        try
        {
            for (final TimeAllocation entity : entities)
            {
                remove(entity);
            }
        }
        catch (Exception ex)
        {
            throw new TimeAllocationDaoException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>TimeAllocationDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link TimeAllocation} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link TimeAllocationVO} - {@link #TRANSFORM_TIMEALLOCATIONVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link TimeAllocationDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,Collection)
     */
    protected Object transformEntity(final int transform, final TimeAllocation entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case TimeAllocationDao.TRANSFORM_TIMEALLOCATIONVO :
                    target = toTimeAllocationVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int, TimeAllocation)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * Transforms into the same collection as the argument, but this time containing the transformed entities
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>TimeAllocationDao</code>
     * @param entities the collection of entities to transform
     * @see #transformEntity(int, TimeAllocation)
     */
    protected void transformEntities(final int transform, final Collection<TimeAllocation> entities)
    {
        switch (transform)
        {
            case TimeAllocationDao.TRANSFORM_TIMEALLOCATIONVO :
                toTimeAllocationVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see TimeAllocationDao#toTimeAllocationVOCollection(Collection)
     */
    @Override
    public final void toTimeAllocationVOCollection(Collection entities)
    {
        if (entities != null)
        {
            CollectionUtils.transform(entities, this.TIMEALLOCATIONVO_TRANSFORMER);
        }
    }

    /**
     * Default implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link TimeAllocationDaoImpl} class if you intend to use reporting queries.
     * @param row Object[] Array of TimeAllocation to transform
     * @return target TimeAllocationVO
     * @see TimeAllocationDao#toTimeAllocationVO(TimeAllocation)
     */
    protected TimeAllocationVO toTimeAllocationVO(Object[] row)
    {
        TimeAllocationVO target = null;
        if (row != null)
        {
            final int numberOfObjects = row.length;
            for (int ctr = 0; ctr < numberOfObjects; ctr++)
            {
                final Object object = row[ctr];
                if (object instanceof TimeAllocation)
                {
                    target = this.toTimeAllocationVO((TimeAllocation)object);
                    break;
                }
            }
        }
        return target;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link TimeAllocationVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private Transformer TIMEALLOCATIONVO_TRANSFORMER =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof TimeAllocation)
                {
                    result = toTimeAllocationVO((TimeAllocation)input);
                }
                else if (input instanceof Object[])
                {
                    result = toTimeAllocationVO((Object[])input);
                }
                return result;
            }
        };

    /**
     * @see TimeAllocationDao#timeAllocationVOToEntityCollection(Collection)
     */
    @Override
    public final void timeAllocationVOToEntityCollection(Collection instances)
    {
        if (instances != null)
        {
            for (final Iterator iterator = instances.iterator(); iterator.hasNext();)
            {
                // - remove objects that are null or not of the correct instance
                if (!(iterator.next() instanceof TimeAllocationVO))
                {
                    iterator.remove();
                }
            }
            CollectionUtils.transform(instances, this.TimeAllocationVOToEntityTransformer);
        }
    }

    private final Transformer TimeAllocationVOToEntityTransformer =
        new Transformer()
        {
            @Override
            public Object transform(Object input)
            {
                return timeAllocationVOToEntity((TimeAllocationVO)input);
            }
        };

    /**
     * @see TimeAllocationDao#toTimeAllocationVO(TimeAllocation, TimeAllocationVO)
     */
    @Override
    public void toTimeAllocationVO( TimeAllocation source, TimeAllocationVO target)
    {
        target.setId(source.getId());
    }

    /**
     * @see TimeAllocationDao#toTimeAllocationVO(TimeAllocation)
     */
    @Override
    public TimeAllocationVO toTimeAllocationVO(final TimeAllocation entity)
    {
        final TimeAllocationVO target = new TimeAllocationVO();
        this.toTimeAllocationVO(entity, target);
        return target;
    }

    /**
     * @see TimeAllocationDao#timeAllocationVOToEntity(TimeAllocationVO, TimeAllocation, boolean)
     */
    @Override
    public void timeAllocationVOToEntity( TimeAllocationVO source, TimeAllocation target, boolean copyIfNull)
    {
    }


    // For unit testing outside of container - persistence context not injected
    /**
     * @return the context
     */
    public SessionContext getContext()
    {
        return this.context;
    }

    /**
     * @param contextIn the context to set
     */
    public void setContext(SessionContext contextIn)
    {
        this.context = contextIn;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    /**
     * @param entityManagerIn the entityManager to set
     */
    public void setEntityManager(EntityManager entityManagerIn)
    {
        this.entityManager = entityManagerIn;
    }

    /**
     * @return the hibernateSession
     */
    public Session getHibernateSession()
    {
        return this.hibernateSession;
    }

    /**
     * @param hibernateSessionIn the hibernateSession to set
     */
    public void setHibernateSession(Session hibernateSessionIn)
    {
        this.hibernateSession = hibernateSessionIn;
    }
}
