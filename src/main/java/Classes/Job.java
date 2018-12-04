/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author mac
 */
public class Job implements Serializable{
    protected String JobTitle;
    protected String Company;
    protected String Location;
    protected String Summary;

    public Job() {
    }

    public Job(String JobTitle, String Company, String Location, String Summary) {
        this.JobTitle = JobTitle;
        this.Company = Company;
        this.Location = Location;
        this.Summary = Summary;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }
    
    
    
}
