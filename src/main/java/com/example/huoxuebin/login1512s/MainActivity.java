package com.example.huoxuebin.login1512s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huoxuebin.login1512s.Bean.LoginBean;
import com.example.huoxuebin.login1512s.presenter.IM.IMloginPresenter;
import com.example.huoxuebin.login1512s.presenter.LoginPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMloginPresenter {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //登录
    public void Login(View view) {

       //实例化对象
        loginPresenter = new LoginPresenter(this);
        //获取输入内容
        String sname = name.getText().toString();
        String password = pass.getText().toString();
        loginPresenter.getlogin("mobile",sname,password);
    }

    //注册
    public void zhuce(View view) {

        Intent intent = new Intent(MainActivity.this,JoinActivity.class);
        startActivity(intent);

    }
    @Override
    public void success(LoginBean loginBean) {

        String msg = loginBean.getMsg();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.zhikong();
    }
}
