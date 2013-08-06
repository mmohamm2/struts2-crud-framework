package com.dakuupa.calendar;

/**
 *
 * @author etwilliams
 */
public class CalendarEvent {

    private int id;
    private int dayOfMonth;
    private String title;
    private String description;
    private String link;

    public CalendarEvent() {
    }

    public CalendarEvent(int id, int dayOfMonth, String title, String description, String link) {
        this.id = id;
        this.dayOfMonth = dayOfMonth;
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
