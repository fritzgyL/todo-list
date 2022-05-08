package com.fritzgyl.todolist.model;

import com.fritzgyl.todolist.model.audit.DateAudit;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "to_do")
public class ToDo extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    public ToDo(String title) {
        this.title = title;
    }

}
