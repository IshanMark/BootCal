package com.example.bootcal.Model;

/**
 * <h3>Model</h3>
 * This is the Model Class that we use to
 * initialize Constructors
 * initialize getters and setters
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */

public class Model {

    /**
     * Declaration of the variable
     */
    String date, event , note;

    /**
     * initialize Constructors
     */
    public Model(String date, String event, String note) {
        this.date = date;
        this.event = event;
        this.note = note;
    }

    /**
     * initialize getters and setters
     */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
