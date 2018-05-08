package com.example.huoxuebin.login1512s.model;

import com.example.huoxuebin.login1512s.Bean.JoinBean;
import com.example.huoxuebin.login1512s.model.IM.IMJoinModel;
import com.example.huoxuebin.login1512s.presenter.JoinPresenter;
import com.example.huoxuebin.login1512s.utils.BaseObserver;
import com.example.huoxuebin.login1512s.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/5/8.
 */

public class JoinModel {

    private  IMJoinModel imJoinModel;

    public JoinModel(IMJoinModel imJoinModel) {
        this.imJoinModel=imJoinModel;
    }

    public void getjoin(String url, String name, String pass) {

        Map<String,String> map = new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        RetrofitManager.post(url, map, new BaseObserver<JoinBean>() {
            @Override
            public void success(JoinBean joinBean) {
                imJoinModel.getjoin(joinBean);

            }

            @Override
            public void failure(int code) {

            }
        });

    }
}
