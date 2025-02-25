package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.hud.colors.BackgroundBreathingColor;
import com.bonepl.razersdk.color.BreathingColor;
import com.bonepl.chromaleague.hud.parts.ProgressBar;
import com.bonepl.chromaleague.state.GameStateHelper;
import com.bonepl.razersdk.animation.AnimatedFrame;
import com.bonepl.razersdk.color.Color;
import com.bonepl.razersdk.animation.Frame;
import com.bonepl.razersdk.color.StaticColor;

public class YasuoWindBar extends AnimatedFrame {
    public static final BreathingColor WIND_SHIELD_READY_COLOR = new BackgroundBreathingColor(StaticColor.WHITE);
    public static final StaticColor WIND_SHIELD_COLOR = StaticColor.GRAY;

    @Override
    public Frame getFrame() {
        final int resourcePercentage = GameStateHelper.getResourcePercentage();
        Color color;
        if (resourcePercentage == 100) {
            color = WIND_SHIELD_READY_COLOR.getColor();
        } else {
            color = WIND_SHIELD_COLOR;
        }
        addAnimationFrame(new ProgressBar(ResourceBars.getResourceBarKeys(), resourcePercentage, color));
        return super.getFrame();
    }
}
