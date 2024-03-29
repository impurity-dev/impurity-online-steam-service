package com.impurityonline.steam.exception;

import com.impurityonline.steam.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.impurityonline.steam.constant.Profiles.UNIT_TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author impurity
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SteamLibraryNotFoundExceptionTests extends AbstractTest {

    @Test
    @DisplayName("The steam library not found exception stores message properly")
    public void captures_message() {
        String testMessage = "apples";
        assertEquals(new SteamLibraryNotFoundException(testMessage).getMessage(), testMessage);
    }
}

