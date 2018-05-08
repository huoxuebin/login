package com.example.huoxuebin.login1512s.model;

import com.example.huoxuebin.login1512s.Bean.LoginBean;
import com.example.huoxuebin.login1512s.model.IM.IMloginModel;
import com.example.huoxuebin.login1512s.presenter.LoginPresenter;
import com.example.huoxuebin.login1512s.utils.BaseObserver;
import com.example.huoxuebin.login1512s.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huoxuebin on 2018/5/8.
 */

public class LoginModel {

    private  IMloginModel iMloginModel;

    public LoginModel(IMloginModel iMloginModel) {
        this.iMloginModel=iMloginModel;

    }

    public void getlogin(String url, String sname, String password) {

        Map<String, String> map = new HashMap<>();
        map.put("mobile", sname);
        map.put("password", password);

        RetrofitManager.post("user/login", map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                iMloginModel.success(loginBean);

            }

            @Override
            public void failure(int code) {

            }
        });

    }
}
