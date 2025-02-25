package com.bonepl.razersdk.animation;

import com.bonepl.razersdk.color.Color;
import com.bonepl.razersdk.color.StaticColor;
import com.bonepl.razersdk.sdk.RzKey;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {
    @Test
    void testCustomEffectCreation() {
        //given
        final EnumMap<RzKey, Color> inputMap = new EnumMap<>(RzKey.class);
        inputMap.put(RzKey.RZKEY_ESC, StaticColor.BLUE);
        inputMap.put(RzKey.RZKEY_ENTER, StaticColor.WHITE);

        //when
        final Frame frame = new Frame(inputMap);
        final Map<RzKey, Color> actualMap = frame.getKeysToColors();

        //then
        assertEquals(inputMap, actualMap);
    }
}