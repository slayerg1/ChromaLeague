package com.bonepl.chromaleague.razer;

import com.bonepl.chromaleague.razer.effects.animation.Frame;
import com.bonepl.chromaleague.razer.effects.keyboard.SDKKeyboardEffect;
import com.bonepl.chromaleague.razer.sdk.RzChromaSDK64;
import com.bonepl.chromaleague.razer.sdk.RzKeyboardEffectType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RazerSDKClient implements AutoCloseable {
    private static final Logger logger = LogManager.getLogger();
    private final RzChromaSDK64 rzChromaSDK64;

    public RazerSDKClient() {
        rzChromaSDK64 = Native.load("RzChromaSDK64", RzChromaSDK64.class);
        init();
    }

    /**
     * Initialization requires about 1s before accepting effect
     * or it drops frames (?)
     */
    private void init() {
        rzChromaSDK64.Init();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createKeyboardEffect(Frame frame) {
        createKeyboardEffect(frame.toCustomEffect());
    }

    private void createKeyboardEffect(SDKKeyboardEffect effect) {
        int result = rzChromaSDK64.CreateKeyboardEffect(
                RzKeyboardEffectType.CUSTOM.getRzSDKKeyboardEffectType(),
                effect.getEffect(), Pointer.NULL);
        if (result != 0) {
            logger.error("Creating keyboard effect returned error " + result);
        }
    }

    @Override
    public void close() {
        rzChromaSDK64.UnInit();
    }
}
