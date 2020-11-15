package personal.simulateui.ui;

import androidx.appcompat.app.AppCompatActivity;
import personal.simulateui.IMyAidlInterface;
import personal.simulateui.R;
import personal.simulateui.service.AIDLService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

/**
 * 工作中遇到一个难题：<BR>
 * 运行在另一个进程中的APP需要和主进程共享隐私协议的签署状态<BR>
 * 主进程却因为在后台，不符合隐私规则无法弹出，切换账号之后需要让主进程知道APP的前后台状态<BR>
 * 本来是通过发广播的形式通知，但是normal级别的自定义权限，安全部门又说不合规，不允许发布<BR>
 * 升级到signatureOrSystem之后，同事又报告说将来会上一些签名和主进程不同的APP，需要提前做兼容<BR>
 * 直接把广播这条路堵死了<BR>
 * 还是用AIDL来做吧，先做个DEMO熟悉熟悉<BR>
 *
 * 这个场景下消息不需要携带数据，所以可以跳过数据bean这一步<BR>
 * AIDL文件，互相通信的进程都需要持有，本例是自己和自己通信所以只有一份
 * 如果有数据bean的话，两边也是要各自持有数据bean.java的
 */
public class AidlActivity extends AppCompatActivity {
    private boolean connected = false;

    private IMyAidlInterface myAidlInterface;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            connected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        Button button = findViewById(R.id.btnSendMsg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myAidlInterface != null && connected) {
                    try {
                        myAidlInterface.startCheckPrivacy();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Intent serviceIntent = new Intent();
        serviceIntent.setPackage("personal.simulateui");
        serviceIntent.setAction("android.intent.action.personalAction");
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
}
