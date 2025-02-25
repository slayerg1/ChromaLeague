package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.hud.parts.ProgressBar;
import com.bonepl.chromaleague.state.GameStateHelper;
import com.bonepl.razersdk.animation.AnimatedFrame;
import com.bonepl.razersdk.animation.Frame;
import com.bonepl.razersdk.color.StaticColor;

public class RenektonFuryBar extends AnimatedFrame {
    @Override
    public Frame getFrame() {
        final int resourcePercentage = GameStateHelper.getResourcePercentage();
        if (resourcePercentage < 50) {
            addAnimationFrame(new ProgressBar(ResourceBars.getResourceBarKeys(),
                    resourcePercentage, StaticColor.WHITE));
        } else {
            addAnimationFrame(new ProgressBar(ResourceBars.getResourceBarKeys(),
                    resourcePercentage, StaticColor.RED));
        }
        return super.getFrame();
    }
}
