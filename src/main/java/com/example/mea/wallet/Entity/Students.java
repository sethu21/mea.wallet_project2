package com.example.mea.wallet.Entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")



public class Students {
    @Id
    private String id;
    @Column(name = "name")
    private String Name;
    @Column(name = "lastname")
    private String Lastname;
    @ElementCollection
    @CollectionTable(name = "subjects")
    @Column(name = "subject")
    private List<String>Subjects;
}
