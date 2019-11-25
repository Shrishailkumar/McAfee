package mcafee.android.com.shrishailkumarmcafeetask.model;

/**
 * Created by Shrishailkumar Maddaraki on 11/25/2019.
 */
public class ThreadSafeSingelton implements Cloneable{

    private static ThreadSafeSingelton mThreadSafeSingelton;

    private ThreadSafeSingelton(){}

    public final static synchronized ThreadSafeSingelton getmThreadSafeSingelton() {
        if (mThreadSafeSingelton!=null){
            return new ThreadSafeSingelton();
        }
        else
            return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}
