import com.apg.game.APG;
import org.junit.jupiter.api.Test;
import org.junit.runners.model.InitializationError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class APGTest {

    APG apg = new APG();

    @Test
    public void getterWidthAndHeightTest() {
        final int V_WIDTH_EXPECTED = 400;
        final int V_HEIGHT_EXPECTED = 208;

        final int V_WIDTH_ACTUAL = APG.getVWidth();
        final int V_HEIGHT_ACTUAL = APG.getVHeight();

        assertEquals(V_WIDTH_EXPECTED, V_WIDTH_ACTUAL);
        assertEquals(V_HEIGHT_EXPECTED, V_HEIGHT_ACTUAL);
    }

    @Test
    public void getterPPMTest() {

        final float PPM_EXPECTED = 100;

        final float PPM_ACTUAL = APG.getPPM();

        assertEquals(PPM_EXPECTED, PPM_ACTUAL);
    }

    @Test
    public void getterBits() {
        final short DEFAULT_BIT_EXPECTED = 1;
        final short PLAYER_BIT_EXPECTED = 2;
        final short PRESENT_BIT_EXPECTED = 8;
        final short PICKED_UP_BIT_EXPECTED = 16;

        final short DEFAULT_BIT_ACTUAL = APG.getDefaultBit();
        final short PLAYER_BIT_ACTUAL = APG.getPlayerBit();
        final short PRESENT_BIT_ACTUAL = APG.getPresentBit();
        final short PICKED_UP_BIT_ACTUAL = APG.getPickedUpBit();

        assertEquals(DEFAULT_BIT_EXPECTED, DEFAULT_BIT_ACTUAL);
        assertEquals(PLAYER_BIT_EXPECTED, PLAYER_BIT_ACTUAL);
        assertEquals(PRESENT_BIT_EXPECTED, PRESENT_BIT_ACTUAL);
        assertEquals(PICKED_UP_BIT_EXPECTED, PICKED_UP_BIT_ACTUAL);
    }

}
