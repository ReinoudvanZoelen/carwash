package main.models;

/**
 * Created by Reino on 21-2-2017.
 */
public class Auto {
    private int id;
    private String naam;
    private boolean vies;
    private int wasTijd;

    public Auto(int id, String naam, boolean vies, int wasTijd) {
        this.id = id;
        this.naam = naam;
        this.vies = vies;
        this.wasTijd = wasTijd;
    }

    public Auto(String naam, boolean vies, int wasTijd){
        this.naam = naam;
        this.vies = vies;
        this.wasTijd = wasTijd;
    }

    @Override
    public String toString() {
        return naam + ", wastijd: " + wasTijd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isVies() {
        return vies;
    }

    public void setVies(boolean vies) {
        this.vies = vies;
    }

    public int getWasTijd() {
        return wasTijd;
    }

    public void setWasTijd(int wasTijd) {
        this.wasTijd = wasTijd;
    }
}
