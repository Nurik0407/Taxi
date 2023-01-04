package classes;

import java.time.LocalDate;

public class License {
    private Long ID;
    private LocalDate dateOfIssue;
    private LocalDate expirationDate;


    public License(Long ID, LocalDate dateOfIssue, LocalDate expirationDate) {
        this.ID = ID;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public String toString() {
        return "\nLicense: " +
                "\nID: " + ID +
                "\ndateOfIssue: " + dateOfIssue +
                "\nexpirationDate: " + expirationDate ;
    }
}
