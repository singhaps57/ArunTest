package execute.devved.demoapp.modelClass;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anroid on 24/10/16.
 */
@SuppressLint("ParcelCreator")
public class SmsEntity implements Parcelable {
    String titlName;

    String Description;

    int  number;

    public SmsEntity() {

    }

    public  void  SmsEntity(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitlName() {
        return titlName;
    }

    public void setTitlName(String titlName) {
        this.titlName = titlName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titlName);
        parcel.writeString(Description);
        parcel.writeInt(number);

    }


    public static final Parcelable.Creator<SmsEntity> CREATOR
            = new Parcelable.Creator<SmsEntity>() {
        public SmsEntity createFromParcel(Parcel in) {
            return new SmsEntity(in);
        }

        public SmsEntity[] newArray(int size) {
            return new SmsEntity[size];
        }
    };

    public SmsEntity(Parcel in) {
        titlName = in.readString();
        Description = in.readString();
        number = in.readInt();
    }

}
