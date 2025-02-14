package top.niunaijun.blackbox.fake.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

import java.lang.reflect.Method;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethod;
import top.niunaijun.blackbox.fake.provider.FileProviderHandler;
import top.niunaijun.blackbox.utils.ComponentUtils;
import top.niunaijun.blackbox.utils.MethodParameterUtils;
import top.niunaijun.blackbox.utils.compat.BuildCompat;
import top.niunaijun.blackbox.utils.compat.StartActivityCompat;

import static android.content.pm.PackageManager.GET_META_DATA;

/**
 * Created by Milk on 4/21/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class ActivityManagerCommonProxy {
    public static final String TAG = "CommonStub";

    @ProxyMethod(name = "startActivity")
    public static class StartActivity extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            Object arg = args[getIntentIndex()];
            if (arg instanceof Intent) {
                Intent intent = (Intent) arg;
                if (intent.getParcelableExtra("_VM_|_target_") != null) {
                    return method.invoke(who, args);
                }
                if (ComponentUtils.isRequestInstall(intent)) {
                    intent.setData(FileProviderHandler.convertFileUri(BActivityThread.getApplication(), intent.getData()));
                    return method.invoke(who, args);
                }
                String dataString = intent.getDataString();
                if (dataString != null && dataString.equals("package:" + BActivityThread.getAppPackageName())) {
                    intent.setData(Uri.parse("package:" + BlackBoxCore.getHostPkg()));
                }

                ResolveInfo resolveInfo = BlackBoxCore.getBPackageManager().resolveActivity(
                        intent,
                        GET_META_DATA,
                        StartActivityCompat.getResolvedType(args),
                        BActivityThread.getUserId());
                if (resolveInfo == null) {
                    return method.invoke(who, args);
                }

                intent.setExtrasClassLoader(who.getClass().getClassLoader());
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                BlackBoxCore.getBActivityManager().startActivityAms(BActivityThread.getUserId(),
                        StartActivityCompat.getIntent(args),
                        StartActivityCompat.getResolvedType(args),
                        StartActivityCompat.getResultTo(args),
                        StartActivityCompat.getResultWho(args),
                        StartActivityCompat.getRequestCode(args),
                        StartActivityCompat.getFlags(args),
                        StartActivityCompat.getOptions(args));
                return 0;
            }
            return method.invoke(who, args);
        }

        private int getIntentIndex() {
            if (BuildCompat.isR()) {
                return 3;
            } else {
                return 2;
            }
        }
    }

    @ProxyMethod(name = "startActivities")
    public static class StartActivities extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            Intent[] intents = (Intent[]) args[2];
            String[] resolvedTypes = (String[]) args[3];
            IBinder resultTo = (IBinder) args[4];
            Bundle options = (Bundle) args[5];
            // todo ??
            if (!ComponentUtils.isSelf(intents)) {
                return method.invoke(who, args);
            }

            for (Intent intent : intents) {
                intent.setExtrasClassLoader(who.getClass().getClassLoader());
            }
            return BlackBoxCore.getBActivityManager().startActivities(BActivityThread.getUserId(),
                    intents, resolvedTypes, resultTo, options);
        }
    }

    @ProxyMethod(name = "activityResumed")
    public static class ActivityResumed extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            BlackBoxCore.getBActivityManager().onActivityResumed((IBinder) args[0]);
            return method.invoke(who, args);
        }
    }

    @ProxyMethod(name = "activityDestroyed")
    public static class ActivityDestroyed extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            BlackBoxCore.getBActivityManager().onActivityDestroyed((IBinder) args[0]);
            return method.invoke(who, args);
        }
    }

    @ProxyMethod(name = "finishActivity")
    public static class FinishActivity extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            BlackBoxCore.getBActivityManager().onFinishActivity((IBinder) args[0]);
            return method.invoke(who, args);
        }
    }

    @ProxyMethod(name = "getAppTasks")
    public static class GetAppTasks extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            MethodParameterUtils.replaceFirstAppPkg(args);
            return method.invoke(who, args);
        }
    }
}
