import org.example.Radio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio(30);

    @Test
    public void shouldSelectStation() {

        radio.setCurrentStation(21);

        Assertions.assertEquals(21, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSelectStationMoreMax() {

        radio.setCurrentStation(30);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSelectStationLessMin() {

        radio.setCurrentStation(-1);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSelectNextStation() {

        radio.setCurrentStation(13);
        radio.next();

        Assertions.assertEquals(14, radio.getCurrentStation());
    }

    @Test
    public void shouldSelectPrevStation() {

        radio.setCurrentStation(7);
        radio.prev();

        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldSelectNextStationAfterMax() {

        radio.setCurrentStation(29);
        radio.next();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSelectPrevStationAfterMin() {

        radio.setCurrentStation(0);
        radio.prev();

        Assertions.assertEquals(29, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {

        radio.setCurrentVolume(35);
        radio.volumeUp();

        Assertions.assertEquals(36, radio.getCurrentVolume());
    }

    @Test
    public void shouldReduceVolume() {

        radio.setCurrentVolume(35);
        radio.volumeDown();

        Assertions.assertEquals(34, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAfterMax() {

        radio.setCurrentVolume(100);
        radio.volumeUp();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotReduceVolumeAfterMin() {

        radio.setCurrentVolume(0);
        radio.volumeDown();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}
