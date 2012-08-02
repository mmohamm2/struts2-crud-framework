package com.dakuupa.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author etwilliams Make sure you have the calendar.css file included.
 * Struts 2 tag: <s:property value="calendar" escape="false"/> where calendar is the
 * HTMLCalendar Object
 */
public class HTMLCalendar {

    private Date today = new Date();
    private HashMap<Integer, ArrayList<CalendarEvent>> eventMap = new HashMap<Integer, ArrayList<CalendarEvent>>();
    private int month;
    private int year;
    private String backImage = "";
    private String forwardImage = "";
    
    private String backAction = "";
    private String forwardAction = "";

    public HTMLCalendar(String backImage, String forwardImage, String backAction, String forwardAction) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        this.month = cal.get(Calendar.MONTH);
        this.year = cal.get(Calendar.YEAR);
        this.backImage = backImage;
        this.forwardImage = forwardImage;
        this.backAction = backAction;
        this.forwardAction = forwardAction;
    }

    public HTMLCalendar(int month, int year, String backImage, String forwardImage, String backAction, String forwardAction) {
        this.month = month;
        this.year = year;
        this.backImage = backImage;
        this.forwardImage = forwardImage;
        this.backAction = backAction;
        this.forwardAction = forwardAction;
    }

    public void addEvent(CalendarEvent event) {
        if (!eventMap.containsKey(event.getDayOfMonth())) {
            eventMap.put(event.getDayOfMonth(), new ArrayList<CalendarEvent>());
        }
        eventMap.get(event.getDayOfMonth()).add(event);
    }

    public String getHtml() {
        Calendar calBuild = Calendar.getInstance();
        calBuild.set(Calendar.MONTH, month);
        calBuild.set(Calendar.DAY_OF_MONTH, 1);
        calBuild.set(Calendar.YEAR, year);

        Calendar calToday = Calendar.getInstance();
        calToday.setTime(today);

        boolean highlightToday = false;

        if (calToday.get(Calendar.MONTH) == calBuild.get(Calendar.MONTH) && calToday.get(Calendar.YEAR) == calBuild.get(Calendar.YEAR)) {
            highlightToday = true;
        }

        StringBuilder stb = new StringBuilder();

        stb.append("<table align='center'><tr>");
        stb.append("<td>");
        stb.append("<td><a href='");
        stb.append(backAction);
        stb.append("'><img src='");
        stb.append(backImage);
        stb.append("' align='middle'/></a></td>");
        stb.append("<td style='font-size: 18pt'>");
        stb.append(getMonthString(month));
        stb.append(" ");
        stb.append(year);
        stb.append("</td>");
        stb.append("<td><a href='");
        stb.append(forwardAction);
        stb.append("'><img src='");
        stb.append(forwardImage);
        stb.append("' align='middle'/></a></td>");
        stb.append("</tr></table>");

        stb.append("<div class='htmlcalendar'>");
        stb.append("<table cellpadding='0' cellspacing='0' align='center'>");
        stb.append("<tr>");
        stb.append("<th>Sun</th>");
        stb.append("<th>Mon</th>");
        stb.append("<th>Tue</th>");
        stb.append("<th>Wed</th>");
        stb.append("<th>Thu</th>");
        stb.append("<th>Fri</th>");
        stb.append("<th>Sat</th>");
        stb.append("</tr>");

        int daycounter = 0;
        int currentDayOfMonth = 1;
        int firstDay = calBuild.get(Calendar.DAY_OF_WEEK);
        int numbDays = calBuild.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i <= 6; i++) {
            stb.append("<tr>");
            for (int x = 1; x <= 7; x++) {
                daycounter = (currentDayOfMonth - firstDay) + 1;
                currentDayOfMonth++;
                if ((daycounter > numbDays) || (daycounter < 1)) {
                    stb.append("<td class='nothing'>&nbsp;</td>");
                } else {
                    if (highlightToday && daycounter == calToday.get(Calendar.DAY_OF_MONTH)) {
                        stb.append("<td class='today'>");

                    } else {
                        stb.append("<td>");

                    }

                    stb.append(daycounter);

                    //list events
                    List<CalendarEvent> currentEvents = eventMap.get(daycounter);

                    if (currentEvents != null) {
                        for (CalendarEvent event : currentEvents) {
                            stb.append("<div class='event'><a href='");
                            stb.append(event.getLink());
                            stb.append(event.getId());
                            stb.append("'");
                            stb.append(event.getId());
                            stb.append("'>");
                            stb.append(event.getTitle());
                            stb.append("</a>");

                            stb.append("</div>");
                        }
                    }


                    stb.append("</td>");
                }

            }
            stb.append("</tr>");
        }

        stb.append("</table>");
        stb.append("</div>");

        return stb.toString();
    }

    private String getMonthString(int monthVal) {

        switch (monthVal) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "";
        }
    }
}
