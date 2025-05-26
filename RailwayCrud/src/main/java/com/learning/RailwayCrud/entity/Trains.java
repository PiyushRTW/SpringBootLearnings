package com.learning.RailwayCrud.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

@Entity
@Table(name = "trains")
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainId;

    @Column(nullable = false)
    private long train_No;

    @Column(nullable = false)
    private String train_Name;

    @Column(nullable = false)
    private String train_Type;


    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public long getTrain_No() {
        return train_No;
    }

    public void setTrain_No(long train_No) {
        this.train_No = train_No;
    }

    public String getTrain_Name() {
        return train_Name;
    }

    public void setTrain_Name(String train_Name) {
        this.train_Name = train_Name;
    }

    public String getTrain_Type() {
        return train_Type;
    }

    public void setTrain_Type(String train_Type) {
        this.train_Type = train_Type;
    }

}
