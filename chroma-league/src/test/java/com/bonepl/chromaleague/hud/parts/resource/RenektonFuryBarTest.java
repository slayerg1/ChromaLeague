package com.bonepl.chromaleague.hud.parts.resource;

import com.bonepl.chromaleague.IntSteps;
import com.bonepl.chromaleague.hud.animations.AnimationTester;
import org.junit.jupiter.api.Test;

import static com.bonepl.chromaleague.GameStateMocks.mockResource;

class RenektonFuryBarTest {

    @Test
    void testRenektonFuryBar() {
        final IntSteps intSteps = new IntSteps(0, 100, 5);
        final RenektonFuryBar vladimirBloodPoolBar = new RenektonFuryBar();

        new AnimationTester()
                .withBeforeIterationAction(i -> {
                    if (i >= 20 && i <= 30) {
                        mockResource(100, 100);
                    } else {
                        mockResource(intSteps.nextInt(), 100);
                    }
                })
                .testAnimation(vladimirBloodPoolBar, 50);

    }
}