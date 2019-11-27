package mcafee.android.com.shrishailkumarmcafeetask.presenter;

import android.content.Context;

import mcafee.android.com.shrishailkumarmcafeetask.model.ThreadSafeSingelton;

/**
 * Created by Shrishailkumar Maddaraki on 11/25/2019.
 */
public class HomePresenter {

    HomeVieDelegate mHomeVieDelegate;
    public HomePresenter(Context ctx){
        this.mHomeVieDelegate = (HomeVieDelegate) ctx;
    }

    public void createClonableTaskOb() throws CloneNotSupportedException {
        ThreadSafeSingelton mThreadSafeSingelton = ThreadSafeSingelton.getmThreadSafeSingelton();
        ThreadSafeSingelton mThreadSafeSingeltonOb2 = (ThreadSafeSingelton) mThreadSafeSingelton.clone();
        if (mThreadSafeSingelton.hashCode()==mThreadSafeSingeltonOb2.hashCode()){
            System.out.println(">>>> hashcodes equal");
        }else{
            System.out.println(">>>> error");
        }
    }

    public void startCounter() {
        mHomeVieDelegate.startCounter();
    }

    public interface HomeVieDelegate{

       void onClickofStartButton();
       void startCounter();
    }

    public void onClickOfStart(){
        mHomeVieDelegate.onClickofStartButton();
    }

}
