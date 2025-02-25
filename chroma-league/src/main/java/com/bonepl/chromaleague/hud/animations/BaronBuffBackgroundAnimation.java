package com.bonepl.chromaleague.hud.animations;

import com.bonepl.chromaleague.hud.colors.BackgroundBreathingColor;
import com.bonepl.razersdk.animation.AnimatedFrame;
import com.bonepl.razersdk.animation.Frame;
import com.bonepl.razersdk.animation.SimpleFrame;
import com.bonepl.razersdk.color.BreathingColor;
import com.bonepl.razersdk.color.StaticColor;
import com.bonepl.razersdk.sdk.RzKey;
import com.bonepl.razersdk.sdk.RzKeyJoiner;
import com.bonepl.razersdk.sdk.RzKeySelector;

import java.util.Set;

import static com.bonepl.razersdk.sdk.RzKey.*;

public class BaronBuffBackgroundAnimation extends AnimatedFrame {
    private final BreathingColor baronBuffColor = new BackgroundBreathingColor(new StaticColor(200, 0, 200));
    private static final Set<RzKey> BARON_AREA = buildBaronArea();

    @Override
    public Frame getFrame() {
        if (!hasFrame()) {
            extendAnimation();
        }
        return super.getFrame();
    }

    private void extendAnimation() {
        for (int i = 0; i < 20; i++) {
            addAnimationFrame(2, new SimpleFrame(BARON_AREA, baronBuffColor.getColor()));
        }
    }

    public static Set<RzKey> buildBaronArea() {
        return new RzKeyJoiner()
                .with(new RzKeySelector().withRowOf(RZKEY_Q).withColumnBetween(RZKEY_Q, RZKEY_U))
                .with(new RzKeySelector().withRowOf(RZKEY_A).withColumnBetween(RZKEY_A, RZKEY_H))
                .with(new RzKeySelector().withRowOf(RZKEY_Z).withColumnBetween(RZKEY_Z, RZKEY_B))
                .join();
    }
}
