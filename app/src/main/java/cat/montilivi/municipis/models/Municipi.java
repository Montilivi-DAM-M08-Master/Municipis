package cat.montilivi.municipis.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Municipi implements Parcelable, Comparable<Municipi> {
    private int codiProvincia;
    private int codiIne;
    private String nomProvincia;
    private String nomMunicipi;
    private int bandera;
    private int escut;

    //region Constructors
    public Municipi()
    {}
    public Municipi(int codiProvincia, int codiIne, String nomProvincia, String nomMunicipi, int bandara, int escut)
    {
        this.setCodiProvincia(codiProvincia);
        this.setCodiIne(codiIne);
        this.setNomMunicipi(nomMunicipi);
        this.setNomProvincia(nomProvincia);
        this.setBandera(bandara);
        this.setEscut(escut);
    }
    //endregion

    //region getters i setters
    public int getCodiProvincia() {
        return codiProvincia;
    }

    public void setCodiProvincia(int codiProvincia) {
        this.codiProvincia = codiProvincia;
    }

    public int getCodiIne() {
        return codiIne;
    }

    public void setCodiIne(int codiIne) {
        this.codiIne = codiIne;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public String getNomMunicipi() {
        return nomMunicipi;
    }

    public void setNomMunicipi(String nomMunicipi) {
        this.nomMunicipi = nomMunicipi;
    }
    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public int getEscut() {
        return escut;
    }

    public void setEscut(int escut) {
        this.escut = escut;
    }
    //endregion

    //region Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codiProvincia);
        dest.writeInt(codiIne);
        dest.writeString(nomProvincia);
        dest.writeString(nomMunicipi);
        dest.writeInt(bandera);
        dest.writeInt(escut);
    }

    public void readFromParcel (Parcel dades)
    {
        codiProvincia = dades.readInt();
        codiIne = dades.readInt();
        nomProvincia = dades.readString();
        nomMunicipi = dades.readString();
        bandera = dades.readInt();
        escut = dades.readInt();
    }
    public Municipi(Parcel dades)
    {
        readFromParcel(dades);
    }

    public final static Creator<Municipi> CREATOR = new Creator<Municipi>() {
        @Override
        public Municipi createFromParcel(Parcel source) {
            return new Municipi(source);
        }

        @Override
        public Municipi[] newArray(int size) {
            return new Municipi[size];
        }
    };
    //endregion

    @Override
    public String toString() {
        return nomMunicipi;
    }

    @Override
    public int compareTo(Municipi municipi) {
        return codiIne-municipi.codiIne;
    }
}

