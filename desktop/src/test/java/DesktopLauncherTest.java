import com.apg.game.APG;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DesktopLauncherTest {
    // Best to run individually. Gets IllegalStateException. Tests still pass
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    LwjglApplication app = new LwjglApplication(new APG(), config);

    @Test
    void DesktopLauncherNotNullTest() {

        assertNotNull(config);
        assertNotNull(app);
    }

    @Test
    void DesktopLauncherIsDesktopTypeTest() {
        Application.ApplicationType expected = Application.ApplicationType.Desktop;
        Application.ApplicationType actual = app.getType();
        assertEquals(expected, actual);
    }
}
