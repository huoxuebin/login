package com.example.huoxuebin.login1512s.presenter;

import com.example.huoxuebin.login1512s.Bean.JoinBean;
import com.example.huoxuebin.login1512s.JoinActivity;
import com.example.huoxuebin.login1512s.model.IM.IMJoinModel;
import com.example.huoxuebin.login1512s.model.JoinModel;
import com.example.huoxuebin.login1512s.presenter.IM.IMJoinPresenter;

/**
 * Created by huoxuebin on 2018/5/8.
 */

public class JoinPresenter implements IMJoinModel {

    private  JoinModel joinModel;
    private  IMJoinPresenter imJoinPresenter;

    public JoinPresenter(IMJoinPresenter imJoinPresenter) {
        joinModel = new JoinModel(this);
        this.imJoinPresenter=imJoinPresenter;
    }

    public void getjoin(String url, String name, String pass) {
        joinModel.getjoin(url,name,pass);

    }

    //置空
    public void jiebang(){
        if(imJoinPresenter!=null){
            imJoinPresenter=null;
        }
    }

    @Override
    public void getjoin(JoinBean joinBean) {
        imJoinPresenter.getjoin(joinBean);

    }
}
