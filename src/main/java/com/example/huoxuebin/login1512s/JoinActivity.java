package com.example.huoxuebin.login1512s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huoxuebin.login1512s.Bean.JoinBean;
import com.example.huoxuebin.login1512s.presenter.IM.IMJoinPresenter;
import com.example.huoxuebin.login1512s.presenter.JoinPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JoinActivity extends AppCompatActivity implements IMJoinPresenter {

    @BindView(R.id.joinname)
    EditText joinname;
    @BindView(R.id.joinpass)
    EditText joinpass;
    private JoinPresenter joinPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        ButterKnife.bind(this);
    }

    //注册
    public void join(View view) {

        //获取内容
        String name = joinname.getText().toString();
        String pass = joinpass.getText().toString();

        //初始化对象
        joinPresenter = new JoinPresenter(this);
        joinPresenter.getjoin("user/reg",name,pass);

    }

    //接收数据
    @Override
    public void getjoin(JoinBean joinBean) {

        String msg = joinBean.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        if(msg.equals("注册成功")){
            Intent intent = new Intent(JoinActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //解绑 销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        joinPresenter.jiebang();
    }
}
