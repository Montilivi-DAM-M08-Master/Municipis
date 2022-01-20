package cat.montilivi.municipis.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class Provincia implements Parcelable, Comparable<Provincia> {
    private int codiProvincia;
    private String nomProvincia;

    public Provincia(int codiProvincia, String nomProvincia) {
        this.codiProvincia = codiProvincia;
        this.nomProvincia = nomProvincia;
    }

    protected Provincia(Parcel in) {
        codiProvincia = in.readInt();
        nomProvincia = in.readString();
    }

    public static final Creator<Provincia> CREATOR = new Creator<Provincia>() {
        @Override
        public Provincia createFromParcel(Parcel in) {
            return new Provincia(in);
        }

        @Override
        public Provincia[] newArray(int size) {
            return new Provincia[size];
        }
    };

    public int getCodiProvincia() {
        return codiProvincia;
    }

    public void setCodiProvincia(int codiProvincia) {
        this.codiProvincia = codiProvincia;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codiProvincia);
        dest.writeString(nomProvincia);
    }

    @NonNull
    @Override
    public String toString() {
        return getNomProvincia();
    }


    @Override
    public boolean equals(@Nullable Object obj) {
/*        if (obj==null)
            return this == null;
        if (! (obj instanceof  Provincia))
            return false;*/
        return Objects.equals(codiProvincia, ((Provincia) obj).getCodiProvincia());
    }

    @Override
    public int compareTo(Provincia o) {
        return ((Integer)codiProvincia).compareTo(((Integer)o.codiProvincia));
    }
}
