package com.ensah.core.bo;

import java.util.List;


public class GroupForm {
    private Long idGroupe;
    private String nomGroupe;
    private String typeGroupe;
    private Long filiereId;
    private Long departementId;
    private List<Long> enseignantsIds;

    // Getters, setters et constructeur

    public Long getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Long idGroupe) {
        this.idGroupe = idGroupe;
    }
    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getTypeGroupe() {
        return typeGroupe;
    }

    public void setTypeGroupe(String typeGroupe) {
        this.typeGroupe = typeGroupe;
    }

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Long departementId) {
        this.departementId = departementId;
    }

    public List<Long> getEnseignantsIds() {
        return enseignantsIds;
    }

    public void setEnseignantsIds(List<Long> enseignantsIds) {
        this.enseignantsIds = enseignantsIds;
    }
}
