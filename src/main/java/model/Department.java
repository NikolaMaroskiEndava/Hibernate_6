package model;

import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String name;

    @OneToMany
    @Column(name = "department_employees")
    @JoinColumn(name = "department_id")
    private List<Employee> departmentEmployees;

    @Column(name = "activated_department")
    @Basic
    @Convert(converter = org.hibernate.type.TrueFalseConverter.class)
    private boolean active;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "zonedDateTime_zoneOffset")
    private ZonedDateTime zonedDateTime;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "offsetDateTime_zoneOffset")
    private OffsetDateTime offsetDateTime;

    public Department() {
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(List<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentEmployees=" + departmentEmployees +
                ", active=" + active +
                ", zonedDateTime=" + zonedDateTime +
                ", offsetDateTime=" + offsetDateTime +
                '}';
    }
}
