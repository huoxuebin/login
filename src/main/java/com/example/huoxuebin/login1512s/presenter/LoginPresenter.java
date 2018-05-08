package com.example.huoxuebin.login1512s.presenter;

import com.example.huoxuebin.login1512s.Bean.LoginBean;
import com.example.huoxuebin.login1512s.MainActivity;
import com.example.huoxuebin.login1512s.model.IM.IMloginModel;
import com.example.huoxuebin.login1512s.model.LoginModel;
import com.example.huoxuebin.login1512s.presenter.IM.IMloginPresenter;

/**
 * Created by huoxuebin on 2018/5/8.
 */

public class LoginPresenter implements IMloginModel {

    private  IMloginPresenter iMloginPresenter;
    public  LoginModel loginModel;

    public LoginPresenter(IMloginPresenter iMloginPresenter) {
        loginModel = new LoginModel(this);
        this.iMloginPresenter=iMloginPresenter;

    }
    //解绑
    public void zhikong(){
        if(loginModel!=null){
            loginModel=null;
        }
    }

    public void getlogin(String url, String sname, String password) {
        loginModel.getlogin(url,sname,password);


    }

    @Override
    public void success(LoginBean loginBean) {
        iMloginPresenter.success(loginBean);

    }
}
