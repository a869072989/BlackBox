package top.niunaijun.blackbox.proxy;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

import androidx.annotation.Nullable;

import top.niunaijun.blackbox.app.dispatcher.AppServiceDispatcher;

/**
 * Created by Milk on 3/30/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class ProxyService extends Service {
    public static final String TAG = "StubService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return AppServiceDispatcher.get().onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppServiceDispatcher.get().onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AppServiceDispatcher.get().onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        AppServiceDispatcher.get().onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        AppServiceDispatcher.get().onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        AppServiceDispatcher.get().onTrimMemory(level);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        AppServiceDispatcher.get().onUnbind(intent);
        return false;
    }

    public static class P0 extends ProxyService {

    }

    public static class P1 extends ProxyService {

    }

    public static class P2 extends ProxyService {

    }

    public static class P3 extends ProxyService {

    }

    public static class P4 extends ProxyService {

    }

    public static class P5 extends ProxyService {

    }

    public static class P6 extends ProxyService {

    }

    public static class P7 extends ProxyService {

    }

    public static class P8 extends ProxyService {

    }

    public static class P9 extends ProxyService {

    }

    public static class P10 extends ProxyService {

    }

    public static class P11 extends ProxyService {

    }

    public static class P12 extends ProxyService {

    }

    public static class P13 extends ProxyService {

    }

    public static class P14 extends ProxyService {

    }

    public static class P15 extends ProxyService {

    }

    public static class P16 extends ProxyService {

    }

    public static class P17 extends ProxyService {

    }

    public static class P18 extends ProxyService {

    }

    public static class P19 extends ProxyService {

    }

    public static class P20 extends ProxyService {

    }

    public static class P21 extends ProxyService {

    }

    public static class P22 extends ProxyService {

    }

    public static class P23 extends ProxyService {

    }

    public static class P24 extends ProxyService {

    }

    public static class P25 extends ProxyService {

    }

    public static class P26 extends ProxyService {

    }

    public static class P27 extends ProxyService {

    }

    public static class P28 extends ProxyService {

    }

    public static class P29 extends ProxyService {

    }

    public static class P30 extends ProxyService {

    }

    public static class P31 extends ProxyService {

    }

    public static class P32 extends ProxyService {

    }

    public static class P33 extends ProxyService {

    }

    public static class P34 extends ProxyService {

    }

    public static class P35 extends ProxyService {

    }

    public static class P36 extends ProxyService {

    }

    public static class P37 extends ProxyService {

    }

    public static class P38 extends ProxyService {

    }

    public static class P39 extends ProxyService {

    }

    public static class P40 extends ProxyService {

    }

    public static class P41 extends ProxyService {

    }

    public static class P42 extends ProxyService {

    }

    public static class P43 extends ProxyService {

    }

    public static class P44 extends ProxyService {

    }

    public static class P45 extends ProxyService {

    }

    public static class P46 extends ProxyService {

    }

    public static class P47 extends ProxyService {

    }

    public static class P48 extends ProxyService {

    }

    public static class P49 extends ProxyService {

    }

    public static class P50 extends ProxyService {

    }

    public static class P51 extends ProxyService {

    }

    public static class P52 extends ProxyService {

    }

    public static class P53 extends ProxyService {

    }

    public static class P54 extends ProxyService {

    }

    public static class P55 extends ProxyService {

    }

    public static class P56 extends ProxyService {

    }

    public static class P57 extends ProxyService {

    }

    public static class P58 extends ProxyService {

    }

    public static class P59 extends ProxyService {

    }

    public static class P60 extends ProxyService {

    }

    public static class P61 extends ProxyService {

    }

    public static class P62 extends ProxyService {

    }

    public static class P63 extends ProxyService {

    }

    public static class P64 extends ProxyService {

    }

    public static class P65 extends ProxyService {

    }

    public static class P66 extends ProxyService {

    }

    public static class P67 extends ProxyService {

    }

    public static class P68 extends ProxyService {

    }

    public static class P69 extends ProxyService {

    }

    public static class P70 extends ProxyService {

    }

    public static class P71 extends ProxyService {

    }

    public static class P72 extends ProxyService {

    }

    public static class P73 extends ProxyService {

    }

    public static class P74 extends ProxyService {

    }

    public static class P75 extends ProxyService {

    }

    public static class P76 extends ProxyService {

    }

    public static class P77 extends ProxyService {

    }

    public static class P78 extends ProxyService {

    }

    public static class P79 extends ProxyService {

    }

    public static class P80 extends ProxyService {

    }

    public static class P81 extends ProxyService {

    }

    public static class P82 extends ProxyService {

    }

    public static class P83 extends ProxyService {

    }

    public static class P84 extends ProxyService {

    }

    public static class P85 extends ProxyService {

    }

    public static class P86 extends ProxyService {

    }

    public static class P87 extends ProxyService {

    }

    public static class P88 extends ProxyService {

    }

    public static class P89 extends ProxyService {

    }

    public static class P90 extends ProxyService {

    }

    public static class P91 extends ProxyService {

    }

    public static class P92 extends ProxyService {

    }

    public static class P93 extends ProxyService {

    }

    public static class P94 extends ProxyService {

    }

    public static class P95 extends ProxyService {

    }

    public static class P96 extends ProxyService {

    }

    public static class P97 extends ProxyService {

    }

    public static class P98 extends ProxyService {

    }

    public static class P99 extends ProxyService {

    }
}
