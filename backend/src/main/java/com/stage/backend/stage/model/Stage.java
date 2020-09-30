package com.stage.backend.stage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STAGE_TBL")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String name ;
    private String description ;
    private String date_deb ;
    private String date_fin ;
    private String lien_git ;
    private String status ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String titre) {
        this.name = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getLien_git() {
        return lien_git;
    }

    public void setLien_git(String lien_git) {
        this.lien_git = lien_git;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
