package fr.esiea.ex4A;

import fr.esiea.ex4A.inscription.AgifyClient;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {

    @Test
    void agifyServiceBean_test(){
        Launcher mock = new Launcher();

        AgifyClient agifyClient = mock.agifyClient();

        assertNotNull(agifyClient);
    }

}
