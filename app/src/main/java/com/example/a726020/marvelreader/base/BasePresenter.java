package com.example.a726020.marvelreader.base;

public abstract class BasePresenter<V extends BaseView> {

    BaseView unsafeView = null;

    public V getUnsafeView() {
        return (V)unsafeView;
    }

    public void attach(BaseView v) {
        this.unsafeView = v;
    }

    void detach() {
        unsafeView = null;
    }

}
