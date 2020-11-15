package personal.simulateui.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import personal.simulateui.IMyAidlInterface;
import personal.simulateui.util.Logger;

public class AIDLService extends Service {
    public AIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    // AIDL文件里面不支持使用/** 注释 */
    // 万一使用了会导致自动生成失败
    private final IMyAidlInterface.Stub stub = new IMyAidlInterface.Stub() {
        @Override
        public void startCheckPrivacy() throws RemoteException {
            Logger.i("收到了来自另一进程的消息");
        }
    };
}
