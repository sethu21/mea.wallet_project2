package com.example.mea.wallet.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Teacher")
public class Teacher {
    @Id
    private String id;
    @Column(name = "name")
    private String Name;
    @Column(name ="lastname")
    private String LastName;
    @ElementCollection
    @CollectionTable(name = "subjects")
    @Column(name = "subject")

    private List<String>Subjects;

}
