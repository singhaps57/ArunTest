package execute.devved.demoapp.entityClass;

import android.os.Parcel;
import android.os.Parcelable;

public class MultiLanguageEntity implements Parcelable {
	
	
	String id;
	
	String program_name;
	
	String program;
	
	
	String favorite;
	
	
	 public MultiLanguageEntity() {
	    	

	    }

	    private MultiLanguageEntity(Parcel in) {
	    	id = in.readString();
	    	program_name = in.readString();
	    	program = in.readString();
	    	
	    	favorite = in.readString();
	    	
	    	//image = in.readString();
	    	//video = in.readString();

	    	
	    	
	    }



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getProgram_name() {
		return program_name;
	}


	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}


	public String getProgram() {
		return program;
	}


	public void setProgram(String program) {
		this.program = program;
	}


	public String getFavorite() {
		return favorite;
	}


	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
	
	

	public static final Creator<MultiLanguageEntity> CREATOR = new Creator<MultiLanguageEntity>() {
		 

		 public MultiLanguageEntity createFromParcel(Parcel in)
	     {
	         return new MultiLanguageEntity(in);
	     }
	     public MultiLanguageEntity[] newArray(int size)
	     {
	         return new MultiLanguageEntity[size];
	     }
	 };
	 




	    public int describeContents() { 

	 return 0; 

	    } 

	    public void writeToParcel(Parcel parcel, int flags) {

	 parcel.writeString(id); 
	 parcel.writeString(program_name);
	 parcel.writeString(program);
	 
	 parcel.writeString(favorite);
	 
	 //parcel.writeString(txt);
	 //parcel.writeString(image);
	 //parcel.writeString(video);

	 //parcel.writeInt(publishTime); 

	    } 



	
	
	
	

}
