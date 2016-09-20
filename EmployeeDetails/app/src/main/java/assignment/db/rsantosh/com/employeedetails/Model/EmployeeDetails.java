package assignment.db.rsantosh.com.employeedetails.Model;

/**
 * Created by C S Ramachandran on 20-09-2016.
 */
public class EmployeeDetails {

    public String strName;
    public String strAge;

    public EmployeeDetails(String strName, String strAge, byte[] bImage) {
        this.strName = strName;
        this.strAge = strAge;
        this.bImage = bImage;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrAge() {
        return strAge;
    }

    public void setStrAge(String strAge) {
        this.strAge = strAge;
    }

    public byte[] getbImage() {
        return bImage;
    }

    public void setbImage(byte[] bImage) {
        this.bImage = bImage;
    }

    public byte[] bImage;

}
