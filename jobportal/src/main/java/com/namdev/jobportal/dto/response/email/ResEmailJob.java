package com.namdev.jobportal.dto.response.email;
import java.util.List;

// DTO dùng để trả về thông tin công việc trong email
public class ResEmailJob {

    private String name;
    private double salary;
    private CompanyEmail company;
    private List<SkillEmail> skills;

    // inner class for company
    public static class CompanyEmail {
        private String name;

        public CompanyEmail(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
    // inner class for skill
    public static class SkillEmail {
        private String name;

        public SkillEmail(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public CompanyEmail getCompany() {
        return company;
    }

    public void setCompany(CompanyEmail company) {
        this.company = company;
    }

    public List<SkillEmail> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillEmail> skills) {
        this.skills = skills;
    }
    
}


