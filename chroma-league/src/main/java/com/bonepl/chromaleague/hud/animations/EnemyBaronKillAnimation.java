package com.bonepl.chromaleague.hud.animations;

import com.bonepl.razersdk.color.StaticColor;

import static com.bonepl.chromaleague.hud.PredefinedKeySets.BLACKWIDOW_FUNCTIONAL;

public class EnemyBaronKillAnimation extends StaticPartialBlinkingAnimation {
    public EnemyBaronKillAnimation() {
        super(BLACKWIDOW_FUNCTIONAL, 8, StaticColor.PURPLE);
    }
}
