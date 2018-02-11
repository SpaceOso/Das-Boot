package tech.spaceoso.dasboot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tech.spaceoso.dasboot.controller.ShipwreckController;
import tech.spaceoso.dasboot.model.Shipwreck;
import tech.spaceoso.dasboot.repository.ShipwreckRepository;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        verify(shipwreckRepository).findOne(1l);

//        assertEquals(1l, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1l));
    }

    @Test
    public void testShipwreckCreate(){
        Shipwreck newWreck = new Shipwreck(2l, "Tester", "testing on my own", "going ok", 23, 23.34, 23.23, 1232);
        Shipwreck ddfe = new Shipwreck(2l, "faee", "testing on my own", "going ok", 23, 23.34, 23.23, 1232);

        when(shipwreckRepository.saveAndFlush(newWreck)).thenReturn(newWreck);

        Shipwreck tester = sc.create(newWreck);

        System.out.println(tester);

//        assertEquals(newWreck, tester);
        assertThat(newWreck, is(tester));
    }
}
