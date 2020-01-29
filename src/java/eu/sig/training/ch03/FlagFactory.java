package eu.sig.training.ch03;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlagFactory {

    private Map<Nationality, Flag> flags = Map.of(
            Nationality.DUTCH, new DutchFlag(),
            Nationality.GERMAN, new GermanFlag(),
            Nationality.BELGIAN, new BelgianFlag(),
            Nationality.FRENCH, new FrenchFlag(),
            Nationality.ITALIAN, new ItalianFlag(),
            Nationality.ROMANIA, new RomanianFlag(),
            Nationality.IRELAND, new IrishFlag(),
            Nationality.HUNGARIAN, new HungarianFlag(),
            Nationality.BULGARIAN, new BulgarianFlag(),
            Nationality.RUSSIA, new RussianFlag()
    );

    // tag::getFlag[]
    public List<Color> getFlagColors(Nationality nationality) {
        if (flags.containsKey(nationality)) {
            return flags.get(nationality).getColors();
        }

        return new UnclassifiedFlag().getColors();
    }

    class BulgarianFlag extends Flag {
        public BulgarianFlag() {
            super(Color.WHITE, Color.GREEN, Color.RED);
        }
    }

    class GermanFlag extends Flag {
        public GermanFlag() {
            super(Color.BLACK, Color.RED, Color.YELLOW);
        }
    }

    class DutchFlag extends Flag {
        public DutchFlag() {
            super(Color.RED, Color.WHITE, Color.BLUE);
        }
    }

    class BelgianFlag extends Flag {
        public BelgianFlag() {
            super(Color.BLACK, Color.YELLOW, Color.RED);
        }
    }

    class FrenchFlag extends Flag {
        public FrenchFlag() {
            super(Color.BLUE, Color.WHITE, Color.RED);
        }
    }

    class ItalianFlag extends Flag {
        public ItalianFlag() {
            super(Color.GREEN, Color.WHITE, Color.RED);
        }
    }

    class RomanianFlag extends Flag {
        public RomanianFlag() {
            super(Color.BLUE, Color.YELLOW, Color.RED);
        }
    }

    class IrishFlag extends Flag {
        public IrishFlag() {
            super(Color.GREEN, Color.WHITE, Color.ORANGE);
        }
    }

    class HungarianFlag extends Flag {
        public HungarianFlag() {
            super(Color.RED, Color.WHITE, Color.GREEN);
        }
    }

    class RussianFlag extends Flag {
        public RussianFlag() {
            super(Color.WHITE, Color.BLUE, Color.RED);
        }
    }

    class UnclassifiedFlag extends Flag {
        public UnclassifiedFlag() {
            super(Color.GRAY);
        }
    }
}
