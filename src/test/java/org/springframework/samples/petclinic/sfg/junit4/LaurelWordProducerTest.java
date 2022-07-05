package org.springframework.samples.petclinic.sfg.junit4;

import org.junit.Before;
import org.junit.Test;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;


import static org.junit.jupiter.api.Assertions.*;

class LaurelWordProducerTest {

    HearingInterpreter hearingInterpreter;

    @Before
    void setUp() {
        hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
    }

    @Test
    void getWord() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Laurel", word);
    }
}