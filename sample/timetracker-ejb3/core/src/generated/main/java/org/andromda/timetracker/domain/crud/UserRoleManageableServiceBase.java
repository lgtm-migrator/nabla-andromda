// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by crud/ManageableServiceBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.domain.UserRole;

/**
 * Autogenerated EJB manageable session bean class UserRoleManageableService.
 */
/**
 * Do not specify the javax.ejb.${manageable.type} annotation
 * Instead, define the session bean in the ejb-jar.xml descriptor
 * javax.ejb.${manageable.type}
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Remote({UserRoleManageableService.class})
public final class UserRoleManageableServiceBase
    implements UserRoleManageableService
{
    // ------ Session Context Injection ------

    @Resource
    protected SessionContext context;

    // ------ Persistence Context Injection --------

    /**
     * Inject persistence context timetracker-ejb3
     */
    @PersistenceContext(unitName = "timetracker-ejb3")
    protected EntityManager emanager;

    // ------------ Private Operations ----------

    private List<UserRole> findUserRoleByIds(Long[] ids)
        throws UserRoleReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from UserRole as entity where entity.id in (:id)");
            query.setParameter("id", Arrays.asList(ids));
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
    }

    private List<User> findUserByIds(Long[] ids)
        throws UserRoleReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from User as entity where entity.id in (:id)");
            query.setParameter("id", Arrays.asList(ids));
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
    }

    // ------------ CRUD Operations -------------

    /**
     * Create operations
     *
     * @return UserRoleVO
     * @throws UserRoleCreateManageableException
     */
    public UserRoleVO create(Role role, Boolean isConditional, Long id, Long[] groups)
        throws UserRoleCreateManageableException
    {
        if (role == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserRoleManageableService.create(Role role, Boolean isConditional, Long id, Long[] groups) - 'role' can not be null");
        }

        final UserRole entity = new UserRole();
        entity.setRole(role);
        entity.setIsConditional(isConditional);
        entity.setId(id);

        try
        {
            final List<UserRole> groupsEntities =
                (groups != null && groups.length > 0)
                    ? this.findUserRoleByIds(groups)
                        : Collections.EMPTY_LIST;


            if (groupsEntities != null)
            {
                entity.setGroups(new TreeSet<UserRole>(groupsEntities));
                // we ought to be setting the other end of the many2many association here
                // but the navigability on the other end has been disabled, therefore doing
                // the following would break compilation: element.getRoles()
                // the result is that only one end of this association will be set
            }


            emanager.persist(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new UserRoleCreateManageableException(ex);
        }
    }


     /**
     * Entity read operation
     *
     * @return UserRoleVO
     * @throws UserRoleReadManageableException
     */
    public UserRoleVO readById(Long id)
        throws UserRoleReadManageableException
    {
        try{
            return toValueObject((UserRole)emanager.find(UserRole.class, id));
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
    }

    /**
     * Read operation
     *
     * @return List
     * @throws UserRoleReadManageableException
     */
    public List<UserRoleVO> read(Role role, Boolean isConditional, Long id, Long[] groups)
        throws UserRoleReadManageableException
    {
        String logicalOperator = "";
        StringBuilder buf = new StringBuilder("from UserRole as entity");
        buf.append(" join entity.groups as UserRole ");
        buf.append(" where ");
        if (role != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.role = :role");
            logicalOperator = " and ";
        }
        if (isConditional != null)
        {
            buf.append(logicalOperator);
            if (isConditional.booleanValue())
            {
                buf.append("entity.isConditional is true");
            }
            else
            {
                buf.append("entity.isConditional is not true");
            }
            logicalOperator = " and ";
        }
        if (id != null)
        {
            buf.append(logicalOperator);
            buf.append("entity.id = :id");
            logicalOperator = " and ";
        }
        if (groups != null && groups.length > 0)
        {
            buf.append(logicalOperator);
            buf.append("UserRole IN (:groups)");
            logicalOperator = " and ";
        }

        try
        {
            final Query query = emanager.createQuery(buf.toString());
            if (isConditional != null)
            {
                query.setParameter("isConditional", isConditional);
            }
            if (groups != null && groups.length > 0)
            {
                query.setParameter("groups", Arrays.asList(groups));
            }
            query.setMaxResults(250);
            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
    }

    /**
     * Read all operation
     *
     * @return List
     * @throws UserRoleReadManageableException
     */
    public List<UserRoleVO> readAll()
        throws UserRoleReadManageableException
    {
        try
        {
            Query query = emanager.createQuery("select entity from UserRole as entity left join fetch entity.groups");
            query.setMaxResults(250);
            List<UserRole> entities = query.getResultList();
            return toValueObjects(entities);
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
    }

    /**
     * Read backing list operation
     *
     * @return Map
     * @throws UserRoleReadManageableException
     */
    public Map readBackingLists()
        throws UserRoleReadManageableException
    {
        final Map lists = new HashMap();

        try
        {
            lists.put("groups", emanager.createQuery("select item.id, item.id from UserRole as item order by item.id").getResultList());
        }
        catch (Exception ex)
        {
            throw new UserRoleReadManageableException(ex);
        }
        return lists;
    }

    /**
     * Update Operation
     *
     * @return UserRoleVO
     * @throws UserRoleUpdateManageableException
     */
    public UserRoleVO update(Role role, Boolean isConditional, Long id, Long[] groups)
        throws UserRoleUpdateManageableException
    {
        if (role == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserRoleManageableService.update(Role role, Boolean isConditional, Long id, Long[] groups) - 'role' can not be null");
        }

        final UserRole entity = (UserRole)emanager.find(UserRole.class, id);
        entity.setRole(role);
        entity.setIsConditional(isConditional);

        try
        {
            final List<UserRole> groupsEntities =
                (groups != null && groups.length > 0)
                    ? this.findUserRoleByIds(groups)
                        : Collections.EMPTY_LIST;


            if (groupsEntities != null)
            {
                entity.setGroups(new TreeSet<UserRole>(groupsEntities));
                // we ought to be setting the other end of the many2many association here
                // but the navigability on the other end has been disabled, therefore doing
                // the following would break compilation: element.getRoles()
                // the result is that only one end of this association will be set
            }

            emanager.merge(entity);
            emanager.flush();
            return toValueObject(entity);
        }
        catch (Exception ex)
        {
            throw new UserRoleUpdateManageableException(ex);
        }
    }

    /**
     * Delete operation
     *
     * @throws UserRoleDeleteManageableException
     */
    public void delete(Long[] ids)
        throws UserRoleDeleteManageableException
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "org.andromda.timetracker.domain.crud.UserRoleManageableService.delete(Long[] ids) - 'ids' can not be null");
        }

        try
        {
            final Query queryObject = emanager.createQuery("delete from UserRole where id in (:ids)");
            queryObject.setParameter("ids", Arrays.asList(ids));
            queryObject.executeUpdate();
        }
        catch (Exception ex)
        {
            throw new UserRoleDeleteManageableException(ex);
        }
    }

    private static List<UserRoleVO> toValueObjects(Collection<UserRole> entities)
    {
        final List<UserRoleVO> list = new ArrayList<UserRoleVO>();

        for (Iterator<UserRole> iterator = entities.iterator(); iterator.hasNext();)
        {
            list.add(toValueObject(iterator.next()));
        }

        return list;
    }

    private static UserRoleVO toValueObject(UserRole entity)
    {
        final UserRoleVO valueObject = new UserRoleVO();

        valueObject.setRole(entity.getRole());
        valueObject.setIsConditional(entity.getIsConditional());
        valueObject.setId(entity.getId());

        final Collection<UserRole> groups = entity.getGroups();
        if (groups == null || groups.isEmpty())
        {
            valueObject.setGroups(null);
        }
        else
        {
            final Long[] values = new Long[groups.size()];
            int counter = 0;
            for (final Iterator<UserRole> iterator = groups.iterator(); iterator.hasNext();counter++)
            {
                final UserRole element = iterator.next();
                values[counter] = element.getId();
            }
            valueObject.setGroups(values);
        }

        return valueObject;
    }
}
