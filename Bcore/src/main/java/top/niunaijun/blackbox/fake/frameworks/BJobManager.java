package top.niunaijun.blackbox.fake.frameworks;

import android.app.job.JobInfo;
import android.os.RemoteException;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.entity.JobRecord;
import top.niunaijun.blackbox.core.system.ServiceManager;
import top.niunaijun.blackbox.core.system.am.IBJobManagerService;

/**
 * Created by Milk on 4/14/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class BJobManager {
    private static final BJobManager sJobManager = new BJobManager();

    public static BJobManager get() {
        return sJobManager;
    }

    private IBJobManagerService mService;

    public JobInfo schedule(JobInfo info) {
        try {
            return getService().schedule(info, BActivityThread.getUserId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JobRecord queryJobRecord(String processName, int jobId) {
        try {
            return getService().queryJobRecord(processName, jobId, BActivityThread.getUserId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cancelAll(String processName) {
        try {
            getService().cancelAll(processName, BActivityThread.getUserId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int cancel(String processName, int jobId) {
        try {
            return getService().cancel(processName, jobId, BActivityThread.getUserId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private IBJobManagerService getService() {
        if (mService != null && mService.asBinder().isBinderAlive()) {
            return mService;
        }
        mService = IBJobManagerService.Stub.asInterface(BlackBoxCore.get().getService(ServiceManager.JOB_MANAGER));
        return getService();
    }
}
