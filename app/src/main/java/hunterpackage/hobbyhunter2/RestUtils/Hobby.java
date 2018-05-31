package hunterpackage.hobbyhunter2.RestUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Hobby {

    public class User implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("iD")
        @Expose
        private Integer iD;

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

        public Integer getiD() {return iD;}

        public void setiD(Integer iD) {this.iD = iD;}
    }
}
