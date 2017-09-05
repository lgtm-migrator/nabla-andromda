// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!!
// Generated by DaoDefaultException.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * This class represents a task for which time allocations need to be tracked.
 */
public class TaskDaoException
    extends Exception
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -3879870166098131074L;

    /**
     * The default constructor.
     */
    public TaskDaoException()
    {}

    /**
     * Constructs a new instance of TaskDaoException
     *
     * @param throwable the parent Throwable
     */
    public TaskDaoException(Throwable throwable)
    {
        super(findRootCause(throwable));
    }

    /**
     * Constructs a new instance of TaskDaoException
     *
     * @param message the throwable message.
     */
    public TaskDaoException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new instance of TaskDaoException
     *
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public TaskDaoException(String message, Throwable throwable)
    {
        super(message, findRootCause(throwable));
    }

    /**
     * Finds the root cause of the parent exception
     * by traveling up the exception tree
     */
    private static Throwable findRootCause(Throwable th)
    {
        if (th != null)
        {
            // Lets reflectively get any JMX or EJB exception causes.
            try
            {
                Throwable targetException = null;
                // java.lang.reflect.InvocationTargetException
                // or javax.management.ReflectionException
                String exceptionProperty = "targetException";
                if (PropertyUtils.isReadable(th, exceptionProperty))
                {
                    targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                }
                else
                {
                    exceptionProperty = "causedByException";
                    //javax.ejb.EJBException
                    if (PropertyUtils.isReadable(th, exceptionProperty))
                    {
                        targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                    }
                }
                if (targetException != null)
                {
                    th = targetException;
                }
            }
            catch (Exception ex)
            {
                // just print the exception and continue
                ex.printStackTrace();
            }

            if (th.getCause() != null)
            {
                th = th.getCause();
                th = findRootCause(th);
            }
        }
        return th;
    }
}
