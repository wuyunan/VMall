package cn.a17xiezuo.vmall.Presenter.impl;

import android.content.Context;

import cn.a17xiezuo.vmall.Presenter.IMainviewPresenter;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.logic.IPersonInteractor;
import cn.a17xiezuo.vmall.logic.impl.PersonInteractorImpl;
import cn.a17xiezuo.vmall.ui.view.IServiceView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class MainviewPresenterImpl implements IMainviewPresenter, IPersonInteractor.OnPersonFinishedListener {

    IServiceView mainView;
    IPersonInteractor personInteractor;
    Context mComtext;

    public MainviewPresenterImpl(Context context, IServiceView mainView) {
        this.mainView = mainView;
        this.personInteractor = new PersonInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getPersionInfo() {
        if (mainView != null) {
            mainView.showProgress();
        }
        this.personInteractor.getPersonInfo(mComtext, this);
    }


    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (mainView != null) {
            mainView.setPerson(person);
        }
    }

}
