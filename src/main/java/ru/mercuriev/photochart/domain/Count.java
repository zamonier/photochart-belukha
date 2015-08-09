package ru.mercuriev.photochart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Count {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private int count;
    @Column
    private LocalDate timestamp;

    public Count() {
    }

    public Count(int count, LocalDate timestamp) {
        this.count = count;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Count{" +
                "count=" + count +
                ", timestamp=" + timestamp +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
