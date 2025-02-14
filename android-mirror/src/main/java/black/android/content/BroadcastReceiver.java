package black.android.content;

import android.os.Bundle;
import android.os.IBinder;

import top.niunaijun.blackreflection.annotation.BClassName;
import top.niunaijun.blackreflection.annotation.BConstructor;
import top.niunaijun.blackreflection.annotation.BField;
import top.niunaijun.blackreflection.annotation.BMethod;

@BClassName("android.content.BroadcastReceiver")
public interface BroadcastReceiver {
    @BMethod
    PendingResult getPendingResult();

    @BMethod
    void setPendingResult(PendingResult PendingResult0);

    @BClassName("android.content.BroadcastReceiver$PendingResult")
    interface PendingResultMNC {
        @BConstructor
        PendingResultMNC _new(int int0, String String1, Bundle Bundle2, int int3, boolean boolean4, boolean boolean5, IBinder IBinder6, int int7, int int8);

        @BField
        boolean mAbortBroadcast();

        @BField
        boolean mFinished();

        @BField
        int mFlags();

        @BField
        boolean mInitialStickyHint();

        @BField
        boolean mOrderedHint();

        @BField
        int mResultCode();

        @BField
        String mResultData();

        @BField
        Bundle mResultExtras();

        @BField
        int mSendingUser();

        @BField
        IBinder mToken();

        @BField
        int mType();
    }

    @BClassName("android.content.BroadcastReceiver$PendingResult")
    interface PendingResultJBMR1 {
        @BConstructor
        PendingResultJBMR1 _new(int int0, String String1, Bundle Bundle2, int int3, boolean boolean4, boolean boolean5, IBinder IBinder6, int int7);

        @BField
        boolean mAbortBroadcast();

        @BField
        boolean mFinished();

        @BField
        boolean mInitialStickyHint();

        @BField
        boolean mOrderedHint();

        @BField
        int mResultCode();

        @BField
        String mResultData();

        @BField
        Bundle mResultExtras();

        @BField
        int mSendingUser();

        @BField
        IBinder mToken();

        @BField
        int mType();
    }

    @BClassName("android.content.BroadcastReceiver$PendingResult")
    interface PendingResult {
        @BConstructor
        PendingResult _new(int int0, String String1, Bundle Bundle2, int int3, boolean boolean4, boolean boolean5, IBinder IBinder6);

        @BField
        boolean mAbortBroadcast();

        @BField
        boolean mFinished();

        @BField
        boolean mInitialStickyHint();

        @BField
        boolean mOrderedHint();

        @BField
        int mResultCode();

        @BField
        String mResultData();

        @BField
        Bundle mResultExtras();

        @BField
        IBinder mToken();

        @BField
        int mType();
    }
}
